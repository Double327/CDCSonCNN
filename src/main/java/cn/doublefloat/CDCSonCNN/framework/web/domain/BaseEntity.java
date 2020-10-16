package cn.doublefloat.CDCSonCNN.framework.web.domain;

import lombok.Data;

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
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除人
     */
    private Long deleteBy;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 备注
     */
    private String note;

    /**
     * 请求参数
     */
    private Map<String, Object> params;

    public Map<String, Object> getParams()
    {
        if (params == null)
        {
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
                ", note='" + note + '\'' +
                ", params=" + params +
                '}';
    }
}
