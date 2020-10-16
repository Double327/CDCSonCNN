package cn.doublefloat.CDCSonCNN.framework.web.controller;

import cn.doublefloat.CDCSonCNN.framework.security.service.LoginService;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李广帅
 * @date 2020/10/16 2:16 下午
 */
@Api(tags = "用户登录模块")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public AjaxResult login(String no, String password, String code, String uuid) {
        String token = loginService.login(no, password, code, uuid);
        AjaxResult success = AjaxResult.success();
        success.put("token", token);
        return success;
    }
}
