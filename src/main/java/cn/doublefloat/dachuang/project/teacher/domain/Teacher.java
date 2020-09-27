package cn.doublefloat.dachuang.project.teacher.domain;

import cn.doublefloat.dachuang.framework.web.domain.BaseUser;
import lombok.Data;
import lombok.ToString;

/**
 * @author 李广帅
 * @date 2020/9/25 3:17 下午
 */
@Data
@ToString
public class Teacher extends BaseUser {

    /**
     * 学院名称
     */
    private String college;
}
