package cn.doublefloat.CDCSonCNN.projects.system.service;

import cn.doublefloat.CDCSonCNN.projects.system.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/10/12 10:45 上午
 */
public interface UserService {
    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    List<User> selectUserList(User user);

    /**
     * 通过学工号查询用户
     *
     * @param no 学工号
     * @return 用户对象信息
     */
    User selectUserByNo(String no);

    /**
     * 根据姓名查询用户
     *
     * @param name 姓名
     * @return 用户对象信息
     */
    List<User> selectUserByName(String name);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    User selectUserById(Long userId);

    /**
     * 根据学工号查询用户所属角色组
     *
     * @param no 学工号
     * @return 结果
     */
    String selectUserRoleGroup(String no);


    /**
     * 校验学工号是否唯一
     *
     * @param no 学工号
     * @return 结果
     */
    String checkNoUnique(String no);

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    String checkPhoneUnique(User user);

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    String checkEmailUnique(User user);

    /**
     * 校验用户是否允许操作
     *
     * @param user 用户信息
     */
    void checkUserAllowed(User user);

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    int insertUser(User user);

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    int updateUser(User user);

    /**
     * 修改用户状态
     *
     * @param user 用户信息
     * @return 结果
     */
    int updateUserStatus(User user);

    /**
     * 修改用户基本信息
     *
     * @param user 用户信息
     * @return 结果
     */
    int updateUserProfile(User user);

    /**
     * 重置用户密码
     *
     * @param user 用户信息
     * @return 结果
     */
    int resetPwd(User user);

    /**
     * 重置用户密码
     *
     * @param no       学工号
     * @param password 密码
     * @return 结果
     */
    int resetUserPwd(String no, String password);

    /**
     * 通过用户ID删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
    int deleteUserByIds(String userId);
}
