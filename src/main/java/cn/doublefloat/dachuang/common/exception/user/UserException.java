package cn.doublefloat.dachuang.common.exception.user;

import cn.doublefloat.dachuang.common.exception.BaseException;

/**
 * @author 李广帅
 * @date 2020/9/27 9:58 上午
 */
public class UserException extends BaseException {

    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
