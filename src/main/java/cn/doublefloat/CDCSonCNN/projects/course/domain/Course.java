package cn.doublefloat.CDCSonCNN.projects.course.domain;

import cn.doublefloat.CDCSonCNN.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * @author 李广帅
 * @date 2020/11/26 上午10:50
 */
@Data
public class Course extends BaseEntity {
    /**
     * 编号
     */
    private Long id;

    /**
     * 课程名
     */
    private String name;

    /**
     * 教师ID
     */
    private Long teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 助教ID
     */
    private Long assistantId;

    /**
     * 助教姓名
     */
    private String assistantName;

    /**
     * 课时
     */
    private Integer classHour;

    /**
     * 学分
     */
    private Integer credits;

    /**
     * 描述信息
     */
    private String desc;

}
