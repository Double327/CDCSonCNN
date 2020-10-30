package cn.doublefloat.CDCSonCNN.projects.student.domain;

import cn.doublefloat.CDCSonCNN.framework.web.domain.BaseUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 李广帅
 * @date 2020/9/25 2:57 下午
 */
@Data
@ApiModel(description = "学生类")
public class Student extends BaseUser {

    /**
     * 班级ID
     */
    @ApiModelProperty(value = "班级ID")
    private Long classId;

    /**
     * 班级名称
     */
    @ApiModelProperty(value = "班级名称")
    private String className;

    @Override
    public String toString() {
        return "Student{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                "} " + super.toString();
    }
}
