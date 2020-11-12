package cn.doublefloat.CDCSonCNN.projects.system.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 李广帅
 * @date 2020/11/12 10:45 上午
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleMenu implements Serializable {
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;
}
