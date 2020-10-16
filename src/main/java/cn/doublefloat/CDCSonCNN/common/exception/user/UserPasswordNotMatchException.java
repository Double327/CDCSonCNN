package cn.doublefloat.CDCSonCNN.common.exception.user;

/**
 * @author 李广帅
 * @date 2020/9/27 10:01 上午
 */
public class UserPasswordNotMatchException extends UserException {

    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}
