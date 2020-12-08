package cn.doublefloat.CDCSonCNN.projects.curriculum_project.domain;

import java.util.Date;

import cn.doublefloat.CDCSonCNN.framework.web.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 课题对象
 *
 * @author 李广帅
 * @date 2020-11-27
 */
@Data
public class CurriculumProject extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 课题ID
     */
    private Long id;

    /**
     * 课程ID
     */
    private Long courseId;

    /**
     * 课程名
     */
    private String courseName;

    /**
     * 课题名称
     */
    private String name;

    /**
     * 描述
     */
    private String desc;

    /**
     * 状态
     */
    private String status;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date beginTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date endTime;

    /**
     * 附件路径
     */
    private String attachmentFilePath;

    /**
     * 删除人
     */
    private Long deleteBy;

    /**
     * 删除时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deleteTime;
}
