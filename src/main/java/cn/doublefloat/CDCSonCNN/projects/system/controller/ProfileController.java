package cn.doublefloat.CDCSonCNN.projects.system.controller;

import cn.doublefloat.CDCSonCNN.common.utils.SecurityUtils;
import cn.doublefloat.CDCSonCNN.common.utils.ServletUtils;
import cn.doublefloat.CDCSonCNN.framework.security.LoginUser;
import cn.doublefloat.CDCSonCNN.framework.security.service.TokenService;
import cn.doublefloat.CDCSonCNN.framework.web.controller.BaseController;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import cn.doublefloat.CDCSonCNN.projects.system.domain.User;
import cn.doublefloat.CDCSonCNN.projects.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李广帅
 * @date 2020/12/5 1:45 下午
 */
@RestController
@RequestMapping("/system/user/profile")
@Slf4j
public class ProfileController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    /**
     * 个人信息
     */
    @GetMapping
    public AjaxResult profile() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        User user = loginUser.getUser();
        log.debug(user.toString());
        AjaxResult ajax = AjaxResult.success(user);
        ajax.put("roleGroup", userService.selectUserRoleGroup(loginUser.getUsername()));
        return ajax;
    }

    /**
     * 修改用户
     */
    @PutMapping
    public AjaxResult updateProfile(@RequestBody User user) {
        return toAjax(userService.updateUserProfile(user));
    }

    /**
     * 重置密码
     */
    @PutMapping("/updatePwd")
    public AjaxResult updatePwd(String oldPassword, String newPassword) {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long id = loginUser.getUser().getId();
        String password = loginUser.getPassword();
        if (!SecurityUtils.matchesPassword(oldPassword, password)) {
            return AjaxResult.error("修改密码失败，旧密码错误");
        }
        if (SecurityUtils.matchesPassword(newPassword, password)) {
            return AjaxResult.error("新密码不能与旧密码相同");
        }
        return toAjax(userService.resetUserPwd(id, SecurityUtils.encryptPassword(newPassword)));
    }
}
