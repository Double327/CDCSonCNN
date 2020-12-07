package cn.doublefloat.CDCSonCNN.projects.system.domain;

import cn.doublefloat.CDCSonCNN.framework.web.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 李广帅
 * @date 2020/11/12 10:45 上午
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role extends BaseEntity implements Serializable {

    /**
     * 角色ID
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色权限
     */
    private String roleKey;

    /**
     * 角色排序
     */
    private String sortNum;

    /**
     * 角色状态（0正常 1停用）
     */
    private String status;

    /**
     * 用户是否存在此角色标识 默认不存在
     */
    private boolean flag = false;

    /**
     * 菜单组
     */
    private Long[] menuIds;


    public Role(Long id) {
        this.id = id;
    }

    public static boolean isAdmin(Long roleId) {
        return roleId != null && 1L == roleId;
    }

    public boolean isAdmin() {
        return isAdmin(this.id);
    }
}
