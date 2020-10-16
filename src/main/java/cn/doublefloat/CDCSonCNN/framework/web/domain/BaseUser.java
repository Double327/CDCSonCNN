package cn.doublefloat.CDCSonCNN.framework.web.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author 李广帅
 * @date 2020/9/25 2:59 下午
 */
@Data
public abstract class BaseUser extends BaseEntity {

    /**
     * 编号
     */
    private Long id;

    /**
     * 身份编号（学号、工号）
     */
    private String no;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String cardId;

    /**
     * 出生日期
     */
    private Date birth;

    /**
     * 性别
     */
    private String sex;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private String status;

    /**
     * 最近登录时间
     */
    private Date lastLoginTime;

    @Override
    public String toString() {
        return "BaseUser{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", cardId='" + cardId + '\'' +
                ", birth=" + birth +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                "} " + super.toString();
    }
}
