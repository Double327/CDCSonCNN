package cn.doublefloat.CDCSonCNN.projects.system.domain;

import cn.doublefloat.CDCSonCNN.framework.web.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/12 10:48 上午
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseEntity implements Serializable {
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 学工号
     */
    private String no;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 身份证号码
     */
    private String cardId;

    /**
     * 学院
     */
    private String college;


    /**
     * 班级
     */
    private String className;

    /**
     * 班级ID
     */
    private Long classId;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

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
     * 帐号状态（0正常 1停用）
     */
    private String status;

    /**
     * 最后登陆时间
     */
    private Date lastLoginTime;

    /**
     * 最后登陆时间
     */
    private Date loginDate;

    /**
     * 角色对象
     */
    private List<Role> roles;

    /**
     * 角色组
     */
    private Long[] roleIds;

    public User(Long id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin(this.id);
    }

    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }
}
