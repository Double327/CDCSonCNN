package cn.doublefloat.CDCSonCNN.project.teacher.domain;

import cn.doublefloat.CDCSonCNN.framework.web.domain.BaseUser;
import lombok.Data;
import lombok.ToString;

/**
 * @author 李广帅
 * @date 2020/9/25 3:17 下午
 */
@Data
public class Teacher extends BaseUser {

    /**
     * 学院名称
     */
    private String college;

    @Override
    public String toString() {
        return "Teacher{" +
                "college='" + college + '\'' +
                "} " + super.toString();
    }
}
