package cn.doublefloat.dachuang.common.exception.user;

/**
 * @author 李广帅
 * @date 2020/9/27 10:12 上午
 */
public class UserNoExistException extends UserException {

    private static final long serialVersionUID = 1L;

    public UserNoExistException() {
        super("user.no.exists", null);
    }
}
