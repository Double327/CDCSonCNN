package cn.doublefloat.CDCSonCNN.common.exception;

import cn.doublefloat.CDCSonCNN.common.utils.MessageUtils;
import cn.doublefloat.CDCSonCNN.common.utils.StringUtils;

/**
 * @author 李广帅
 * @date 2020/9/27 9:47 上午
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String module;

    private String code;

    private Object[] args;

    private String defaultMessage;

    public BaseException(String module, String code, Object[] args, String defaultMessage) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String defaultMessage) {
        this(null, null, null, defaultMessage);
    }

    @Override
    public String getMessage() {
        String message = null;
        if (!StringUtils.isEmpty(code)) {
            message = MessageUtils.message(code, args);
        }
        if (message == null) {
            message = defaultMessage;
        }
        return message;
    }

    public String getModule() {
        return module;
    }

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
