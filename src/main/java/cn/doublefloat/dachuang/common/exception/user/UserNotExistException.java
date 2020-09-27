package cn.doublefloat.dachuang.common.exception.user;

/**
 * @author 李广帅
 * @date 2020/9/27 10:06 上午
 */
public class UserNotExistException extends UserException {

    private static final long serialVersionUID = 1L;

    public UserNotExistException() {
        super("user.not.exists", null);
    }
}
