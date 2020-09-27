package cn.doublefloat.dachuang.project.exception;

import cn.doublefloat.dachuang.common.exception.user.*;
import cn.doublefloat.dachuang.framework.web.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李广帅
 * @date 2020/9/27 1:31 下午
 */
@RestController
public class TestExceptionController {
    @PostMapping("/testException")
    public AjaxResult testException() {
        return AjaxResult.success();
    }

    @GetMapping("/doubleCaptchaErrorException")
    public AjaxResult doubleCaptchaErrorException() {
        if (true) {
            throw new CaptchaErrorException();
        }
        return AjaxResult.success();
    }
//
//    @GetMapping("/captchaExpireException")
//    public AjaxResult doubleCaptchaExpireException() {
//        if (true) {
//            throw new CaptchaExpireException();
//        }
//        return AjaxResult.success();
//    }
//
//    @GetMapping("/userCardIdExistException")
//    public AjaxResult doubleUserCardIdExistException() {
//        if (true) {
//            throw new UserCardIdExistException();
//        }
//        return AjaxResult.success();
//    }
//
//    @GetMapping("/captchaErrorException")
//    public AjaxResult doubleUserNoExistException() {
//        if (true) {
//            throw new UserNoExistException();
//        }
//        return AjaxResult.success();
//    }
//
//    @GetMapping("/userNotExistException")
//    public AjaxResult doubleUserNotExistException() {
//        if (true) {
//            throw new UserNotExistException();
//        }
//        return AjaxResult.success();
//    }
//
//    @GetMapping("/userPasswordNotMatchException")
//    public AjaxResult doubleUserPasswordNotMatchException() {
//        if (true) {
//            throw new UserPasswordNotMatchException();
//        }
//        return AjaxResult.success();
//    }
}
