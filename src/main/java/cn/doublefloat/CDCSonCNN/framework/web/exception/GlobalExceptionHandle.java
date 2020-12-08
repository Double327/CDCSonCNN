package cn.doublefloat.CDCSonCNN.framework.web.exception;

import cn.doublefloat.CDCSonCNN.common.exception.CustomException;
import cn.doublefloat.CDCSonCNN.common.exception.user.*;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 李广帅
 * @date 2020/9/27 10:13 上午
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandle.class);

    @ExceptionHandler(CaptchaErrorException.class)
    public AjaxResult handlerCaptchaErrorException(CaptchaErrorException e) {
        log.error(e.getMessage(), e);
        log.info("验证码错误");
        return AjaxResult.error(e.getMessage());
    }

    @ExceptionHandler(CaptchaExpireException.class)
    public AjaxResult handlerCaptchaExpireException(CaptchaExpireException e) {
        log.error(e.getMessage(), e);
        return AjaxResult.error(e.getMessage());
    }

    @ExceptionHandler(UserCardIdExistException.class)
    public AjaxResult handlerUserCardIdExistException(UserCardIdExistException e) {
        log.error(e.getMessage(), e);
        return AjaxResult.error(e.getMessage());
    }

    @ExceptionHandler(UserNoExistException.class)
    public AjaxResult handlerUserNoExistException(UserNoExistException e) {
        log.error(e.getMessage(), e);
        return AjaxResult.error(e.getMessage());
    }

    @ExceptionHandler(UserNotExistException.class)
    public AjaxResult handlerUserNotExistException(UserNotExistException e) {
        System.out.println("UserNotExist错误");
        log.error(e.getMessage(), e);
        return AjaxResult.error(e.getMessage());
    }

    @ExceptionHandler(UserPasswordNotMatchException.class)
    public AjaxResult handlerUserPasswordNotMatchException(UserPasswordNotMatchException e) {
        System.out.println("UserPasswordNotMatch错误");
        log.error(e.getMessage(), e);
        return AjaxResult.error(e.getMessage());
    }

    @ExceptionHandler(CustomException.class)
    public AjaxResult handleCustomException(CustomException e) {
        log.error(e.getMessage());
        return AjaxResult.error(e.getMessage());
    }
}
