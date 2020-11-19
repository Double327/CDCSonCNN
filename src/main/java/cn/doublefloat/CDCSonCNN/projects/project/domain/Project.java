package cn.doublefloat.CDCSonCNN.projects.project.domain;

import cn.doublefloat.CDCSonCNN.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * @author 李广帅
 * @date 2020/11/18 下午9:32
 */
@Data
public class Project extends BaseEntity {

    /**
     *
     */
    private Long id;

    private String name;

    private String desc;

    private Long curriculumProjectId;

    private String curriculumProjectName;

    private Long studentId;

    private Long teacherId;

    private String filePath;

    private Integer commitTimes;

    private Double score;

    private String comments;

    private String opinion;

    private String bugs;
}
