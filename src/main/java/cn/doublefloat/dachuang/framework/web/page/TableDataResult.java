package cn.doublefloat.dachuang.framework.web.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author 李广帅
 * @date 2020/7/19 4:24 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "列表相应数据")
public class TableDataResult implements Serializable {

    /**
     * 总条数
     */
    @ApiModelProperty(value = "数据总条数")
    private Long total;

    /**
     * 数据行
     */
    @ApiModelProperty(value = "数据列表")
    private List<?> rows;

    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码")
    private Integer code;

    /**
     * 状态信息
     */
    @ApiModelProperty(value = "提示信息")
    private String msg;
}
