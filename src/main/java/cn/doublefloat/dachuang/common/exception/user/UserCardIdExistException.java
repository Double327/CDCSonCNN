package cn.doublefloat.dachuang.common.exception.user;

/**
 * @author 李广帅
 * @date 2020/9/27 10:10 上午
 */
public class UserCardIdExistException extends UserException {

    private static final long serialVersionUID = 1L;

    public UserCardIdExistException() {
        super("user.id-no.exists", null);
    }
}
