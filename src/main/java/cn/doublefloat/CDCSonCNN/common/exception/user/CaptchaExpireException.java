package cn.doublefloat.CDCSonCNN.common.exception.user;

/**
 * @author 李广帅
 * @date 2020/9/27 10:04 上午
 */
public class CaptchaExpireException extends UserException {

    private static final long serialVersionUID = 1L;

    public CaptchaExpireException() {
        super("user.captcha.expire", null);
    }
}
