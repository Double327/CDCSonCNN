package cn.doublefloat.CDCSonCNN.projects.system.controller;

import cn.doublefloat.CDCSonCNN.common.constant.UserConstants;
import cn.doublefloat.CDCSonCNN.common.utils.SecurityUtils;
import cn.doublefloat.CDCSonCNN.framework.web.controller.BaseController;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import cn.doublefloat.CDCSonCNN.framework.web.page.TableDataResult;
import cn.doublefloat.CDCSonCNN.projects.system.domain.User;
import cn.doublefloat.CDCSonCNN.projects.system.service.RoleService;
import cn.doublefloat.CDCSonCNN.projects.system.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/12 11:14 下午
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/system/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 获取用户列表
     */
    @GetMapping("/list")
    public TableDataResult list(User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        return getTableData(list);
    }

    /**
     * 根据用户编号获取详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable Long id) {
        AjaxResult ajax = AjaxResult.success(userService.selectUserById(id));
        ajax.put("roleIds", roleService.selectRoleListByUserId(id));
        return ajax;
    }

    /**
     * 新增用户
     */
    @PostMapping
    public AjaxResult add(@RequestBody User user) {
        if (UserConstants.NOT_UNIQUE.equals(userService.checkNoUnique(user.getNo()))) {
            return AjaxResult.error("新增用户'" + user.getNo() + "'失败，登录账号已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getNo() + "'失败，手机号码已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getNo() + "'失败，邮箱账号已存在");
        }
        user.setCreateBy(SecurityUtils.getUserId());
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        return toAjax(userService.insertUser(user));
    }

    /**
     * 修改用户
     */
    @PutMapping
    public AjaxResult edit(@RequestBody User user) {
        userService.checkUserAllowed(user);
        if (UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
            return AjaxResult.error("修改用户'" + user.getNo() + "'失败，手机号码已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return AjaxResult.error("修改用户'" + user.getNo() + "'失败，邮箱账号已存在");
        }
        user.setUpdateBy(SecurityUtils.getUserId());
        return toAjax(userService.updateUser(user));
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        return toAjax(userService.deleteUserByIds(ids));
    }

    /**
     * 重置密码
     */
    @PutMapping("/resetPwd")
    public AjaxResult resetPwd(@RequestBody User user) {
        userService.checkUserAllowed(user);
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        user.setUpdateBy(SecurityUtils.getUserId());
        return toAjax(userService.resetPwd(user));
    }

    /**
     * 状态修改
     */
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody User user) {
        userService.checkUserAllowed(user);
        user.setUpdateBy(SecurityUtils.getUserId());
        return toAjax(userService.updateUserStatus(user));
    }
}
