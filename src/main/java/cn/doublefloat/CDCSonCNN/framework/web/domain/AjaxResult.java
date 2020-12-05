package cn.doublefloat.CDCSonCNN.framework.web.domain;

import cn.doublefloat.CDCSonCNN.common.utils.StringUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author 李广帅
 * @date 2020/7/20 2:21 下午
 */

@Data
@ToString
@ApiModel(description = "简单相应数据")
public class AjaxResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码标识
     */
    @ApiModelProperty(value = "错误码")
    public static final String CODE_TAG = "code";

    /**
     * 消息标识
     */
    @ApiModelProperty(value = "提示信息")
    public static final String MSG_TAG = "msg";

    /**
     * 数据标识
     */
    @ApiModelProperty(value = "数据")
    public static final String DATA_TAG = "data";

    /**
     * 初始化空 AjaxResult对象
     */
    public AjaxResult() {

    }

    /**
     * 初始化 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  消息内容
     */
    public AjaxResult(HttpStatus code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  消息内容
     * @param data 数据
     */
    public AjaxResult(HttpStatus code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static AjaxResult success() {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @param data 数据
     * @return 成功消息
     */
    public static AjaxResult success(Object data) {
        return AjaxResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 消息内容
     * @return 成功消息
     */
    public static AjaxResult success(String msg) {
        return AjaxResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  消息内容
     * @param data 数据
     * @return 成功消息
     */
    public static AjaxResult success(String msg, Object data) {
        return new AjaxResult(HttpStatus.OK, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return 错误消息
     */
    public static AjaxResult error() {
        return AjaxResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 消息内容
     * @return 错误消息
     */
    public static AjaxResult error(String msg) {
        return AjaxResult.error(msg, null);
    }

    /**
     * 返回错误信息
     *
     * @param msg  消息内容
     * @param data 数据
     * @return 错误消息
     */
    public static AjaxResult error(String msg, Object data) {
        return new AjaxResult(HttpStatus.INTERNAL_SERVER_ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  消息内容
     * @return 错误消息
     */
    public static AjaxResult error(org.springframework.http.HttpStatus code, String msg) {
        return new AjaxResult(code, msg, null);
    }

}
