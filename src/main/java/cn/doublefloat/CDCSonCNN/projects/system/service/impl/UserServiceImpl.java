package cn.doublefloat.CDCSonCNN.projects.system.service.impl;

import cn.doublefloat.CDCSonCNN.common.constant.UserConstants;
import cn.doublefloat.CDCSonCNN.common.exception.CustomException;
import cn.doublefloat.CDCSonCNN.common.utils.ConvertUtils;
import cn.doublefloat.CDCSonCNN.common.utils.SecurityUtils;
import cn.doublefloat.CDCSonCNN.common.utils.StringUtils;
import cn.doublefloat.CDCSonCNN.framework.security.LoginUser;
import cn.doublefloat.CDCSonCNN.framework.security.service.TokenService;
import cn.doublefloat.CDCSonCNN.projects.system.domain.User;
import cn.doublefloat.CDCSonCNN.projects.system.domain.UserRole;
import cn.doublefloat.CDCSonCNN.projects.system.mapper.UserMapper;
import cn.doublefloat.CDCSonCNN.projects.system.mapper.UserRoleMapper;
import cn.doublefloat.CDCSonCNN.projects.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/12 2:03 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private TokenService tokenService;

    @Override
    public List<User> selectUserList(User user) {
        return userMapper.selectUserList(user);
    }

    @Override
    public User selectUserByNo(String no) {
        return userMapper.selectUserByNo(no);
    }

    @Override
    public List<User> selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    @Override
    public User selectUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public String selectUserRoleGroup(String no) {
        return null;
    }

    @Override
    public String checkNoUnique(String no) {
        int count = userMapper.checkNoUnique(no);
        if (count > 0) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public String checkPhoneUnique(User user) {
        Long userId = StringUtils.isNull(user.getId()) ? -1L : user.getId();
        User info = userMapper.checkPhoneUnique(user.getPhone());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != userId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public String checkEmailUnique(User user) {
        Long userId = StringUtils.isNull(user.getId()) ? -1L : user.getId();
        User info = userMapper.checkEmailUnique(user.getEmail());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != userId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public void checkUserAllowed(User user) {
        if (StringUtils.isNotNull(user.getId()) && user.isAdmin()) {
            throw new CustomException("不允许操作超级管理员用户");
        }
    }

    @Override
    public int insertUser(User user) {
        // 新增用户信息
        int rows = userMapper.insertUser(user);
        // 新增用户与角色管理
        insertUserRole(user);
        return rows;
    }

    public void insertUserRole(User user) {
        Long[] roles = user.getRoleIds();
        if (StringUtils.isNotNull(roles)) {
            // 新增用户与角色管理
            List<UserRole> list = new ArrayList<>();
            for (Long roleId : roles) {
                UserRole ur = new UserRole();
                ur.setUserId(user.getId());
                ur.setRoleId(roleId);
                list.add(ur);
            }
            if (!list.isEmpty()) {
                userRoleMapper.batchUserRole(list);
            }
        }
    }

    @Override
    public int updateUser(User user) {
        Long userId = user.getId();
        // 删除用户与角色关联
        userRoleMapper.deleteUserRoleByUserId(userId);
        // 新增用户与角色管理
        insertUserRole(user);
        return userMapper.updateUser(user);
    }

    @Override
    public int updateUserStatus(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int updateUserProfile(User user) {
        user.setId(SecurityUtils.getLoginUser().getUser().getId());
        int result = userMapper.updateUser(user);
        //更新redis缓存
        refreshTokenClaims(user.getId());
        return result;
    }

    private void refreshTokenClaims(Long id) {
        //更新redis缓存
        LoginUser loginUser = SecurityUtils.getLoginUser();
        loginUser.setUser(userMapper.selectUserById(id));
        tokenService.refreshToken(loginUser);
    }

    @Override
    public int resetPwd(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int resetUserPwd(Long id, String password) {
        return userMapper.resetUserPwd(id, password);
    }

    @Override
    public int deleteUserByIds(String ids) {
        Long[] userIds = ConvertUtils.toLongArray(ids);
        for (Long userId : userIds) {
            checkUserAllowed(new User(userId));
            // 删除用户与角色关联
            userRoleMapper.deleteUserRoleByUserId(userId);
        }
        Long userId = SecurityUtils.getUserId();
        return userMapper.deleteUserByIds(userIds, userId);
    }
}
