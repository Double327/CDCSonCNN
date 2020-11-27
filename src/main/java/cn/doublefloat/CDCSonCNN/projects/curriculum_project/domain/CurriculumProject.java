package cn.doublefloat.CDCSonCNN.projects.curriculum_project.domain;

import java.util.Date;

import cn.doublefloat.CDCSonCNN.framework.web.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 课题对象
 *
 * @author 李广帅
 * @date 2020-11-27
 */
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
    @JsonFormat(pattern = "yyyy-MM-dd  hh:mm:ss")
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deleteTime;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setAttachmentFilePath(String attachmentFilePath) {
        this.attachmentFilePath = attachmentFilePath;
    }

    public String getAttachmentFilePath() {
        return attachmentFilePath;
    }

    @Override
    public void setDeleteBy(Long deleteBy) {
        this.deleteBy = deleteBy;
    }

    @Override
    public Long getDeleteBy() {
        return deleteBy;
    }

    @Override
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    @Override
    public Date getDeleteTime() {
        return deleteTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("courseId", getCourseId())
                .append("name", getName())
                .append("desc", getDesc())
                .append("status", getStatus())
                .append("beginTime", getBeginTime())
                .append("endTime", getEndTime())
                .append("attachmentFilePath", getAttachmentFilePath())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("deleteBy", getDeleteBy())
                .append("deleteTime", getDeleteTime())
                .append("remark", getRemark())
                .toString();
    }
}
