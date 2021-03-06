package cn.doublefloat.CDCSonCNN.framework.web.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李广帅
 * @date 2020/7/19 4:18 下午
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 状态
     */
    private String status;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;

    /**
     * 删除人
     */
    private Long deleteBy;

    /**
     * 删除时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date deleteTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 请求参数
     */
    @JsonIgnore
    private Map<String, Object> params;

    @SuppressWarnings("unchecked")
    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", deleteBy=" + deleteBy +
                ", deleteTime=" + deleteTime +
                ", note='" + remark + '\'' +
                ", params=" + params +
                '}';
    }
}
