package cn.doublefloat.CDCSonCNN.projects.iclass.domain;

import cn.doublefloat.CDCSonCNN.framework.web.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author 李广帅
 * @date 2020/12/7 10:21 下午
 */
@Data
public class Iclass extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 班级编号
     */
    private Long id;

    /**
     * 班级序列号
     */
    private String name;

    /**
     * 班主任
     */
    private Long master;

    /**
     * 班级辅导员
     */
    private Long counselor;

    /**
     * 状态
     */
    private String status;

    /**
     * 删除者
     */
    private Long deleteBy;

    /**
     * 删除时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deleteTime;

    /**
     * 备注
     */
    private String note;

}