package cn.doublefloat.CDCSonCNN.projects.project.domain;

import cn.doublefloat.CDCSonCNN.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 tb_project
 *
 * @author 李广帅
 * @date 2020-11-27
 */
public class Project extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 项目ID
     */
    private Long id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目描述
     */
    private String description;

    /**
     * 课设ID
     */
    private Long curriculumProjectId;

    /**
     * 学生ID
     */
    private Long studentId;

    /**
     * 教师ID
     */
    private Long teacherId;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 提交次数
     */
    private Long commitTimes;

    /**
     * 分数
     */
    private Long score;

    /**
     * 导师评价
     */
    private String comments;

    /**
     * 导师指导意见
     */
    private String opinion;

    /**
     * 项目遗留问题
     */
    private String bugs;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCurriculumProjectId(Long curriculumProjectId) {
        this.curriculumProjectId = curriculumProjectId;
    }

    public Long getCurriculumProjectId() {
        return curriculumProjectId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setCommitTimes(Long commitTimes) {
        this.commitTimes = commitTimes;
    }

    public Long getCommitTimes() {
        return commitTimes;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getScore() {
        return score;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setBugs(String bugs) {
        this.bugs = bugs;
    }

    public String getBugs() {
        return bugs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("desc", getDescription())
                .append("curriculumProjectId", getCurriculumProjectId())
                .append("studentId", getStudentId())
                .append("teacherId", getTeacherId())
                .append("filePath", getFilePath())
                .append("commitTimes", getCommitTimes())
                .append("score", getScore())
                .append("comments", getComments())
                .append("opinion", getOpinion())
                .append("bugs", getBugs())
                .toString();
    }
}
