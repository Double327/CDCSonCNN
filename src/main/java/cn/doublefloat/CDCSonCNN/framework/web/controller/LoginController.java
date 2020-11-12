package cn.doublefloat.CDCSonCNN.framework.web.controller;

import cn.doublefloat.CDCSonCNN.common.utils.ServletUtils;
import cn.doublefloat.CDCSonCNN.framework.security.LoginUser;
import cn.doublefloat.CDCSonCNN.framework.security.service.LoginService;
import cn.doublefloat.CDCSonCNN.framework.security.service.PermissionService;
import cn.doublefloat.CDCSonCNN.framework.security.service.TokenService;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import cn.doublefloat.CDCSonCNN.projects.system.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author 李广帅
 * @date 2020/10/16 2:16 下午
 */
@Api(tags = "用户登录模块")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public AjaxResult login(String no, String password, String code, String uuid) {
        String token = loginService.login(no, password, code, uuid);
        AjaxResult success = AjaxResult.success();
        success.put("token", token);
        return success;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("/getUserInfo")
    public AjaxResult getInfo() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        User user = loginUser.getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }
}
