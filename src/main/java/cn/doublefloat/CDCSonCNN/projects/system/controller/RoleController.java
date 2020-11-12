package cn.doublefloat.CDCSonCNN.projects.system.controller;

import cn.doublefloat.CDCSonCNN.common.constant.UserConstants;
import cn.doublefloat.CDCSonCNN.common.utils.SecurityUtils;
import cn.doublefloat.CDCSonCNN.framework.web.controller.BaseController;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import cn.doublefloat.CDCSonCNN.framework.web.page.TableDataResult;
import cn.doublefloat.CDCSonCNN.projects.system.domain.Role;
import cn.doublefloat.CDCSonCNN.projects.system.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/12 11:23 下午
 */
@Api(tags = "角色接口")
@RestController
@RequestMapping("/system/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public TableDataResult list(Role role) {
        startPage();
        List<Role> list = roleService.selectRoleList(role);
        return getTableData(list);
    }

    /**
     * 根据角色编号获取详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable Long id) {
        return AjaxResult.success(roleService.selectRoleById(id));
    }

    /**
     * 修改保存角色
     */
    @PutMapping
    public AjaxResult edit(@RequestBody Role role) {
        roleService.checkRoleAllowed(role);
        if (UserConstants.NOT_UNIQUE.equals(roleService.checkRoleNameUnique(role))) {
            return AjaxResult.error("修改角色'" + role.getName() + "'失败，角色名称已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(roleService.checkRoleKeyUnique(role))) {
            return AjaxResult.error("修改角色'" + role.getName() + "'失败，角色权限已存在");
        }
        role.setUpdateBy(SecurityUtils.getUserId());
        return toAjax(roleService.updateRole(role));
    }

    /**
     * 新增角色
     */
    @PostMapping
    public AjaxResult add(@RequestBody Role role) {
        if (UserConstants.NOT_UNIQUE.equals(roleService.checkRoleNameUnique(role))) {
            return AjaxResult.error("新增角色'" + role.getName() + "'失败，角色名称已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(roleService.checkRoleKeyUnique(role))) {
            return AjaxResult.error("新增角色'" + role.getName() + "'失败，角色权限已存在");
        }
        role.setCreateBy(SecurityUtils.getUserId());
        return toAjax(roleService.insertRole(role));

    }

    /**
     * 修改保存数据权限
     */
    @PutMapping("/dataScope")
    public AjaxResult dataScope(@RequestBody Role role) {
        roleService.checkRoleAllowed(role);
        return toAjax(roleService.authDataScope(role));
    }

    /**
     * 状态修改
     */
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody Role role) {
        roleService.checkRoleAllowed(role);
        role.setUpdateBy(SecurityUtils.getUserId());
        return toAjax(roleService.updateRoleStatus(role));
    }

    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        return toAjax(roleService.deleteRoleByIds(ids));
    }

    /**
     * 获取角色选择框列表
     */
    @GetMapping("/optionselect")
    public AjaxResult optionselect() {
        return AjaxResult.success(roleService.selectRoleAll());
    }
}
