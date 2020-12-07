package cn.doublefloat.CDCSonCNN.projects.system.controller;

import cn.doublefloat.CDCSonCNN.common.constant.UserConstants;
import cn.doublefloat.CDCSonCNN.common.utils.SecurityUtils;
import cn.doublefloat.CDCSonCNN.framework.web.controller.BaseController;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import cn.doublefloat.CDCSonCNN.projects.system.domain.Menu;
import cn.doublefloat.CDCSonCNN.projects.system.service.MenuService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/6 2:37 下午
 */
@Api(tags = "菜单接口")
@RestController
@RequestMapping("/system/menu")
@Slf4j
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    /**
     * 获取菜单列表
     */
    @GetMapping("/list")
    public AjaxResult list(Menu menu) {
        List<Menu> menus = menuService.selectMenuList(menu);
        return AjaxResult.success(menuService.buildMenuTree(menus));
    }

    /**
     * 根据菜单编号获取详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable Long id) {
        return AjaxResult.success(menuService.selectMenuById(id));
    }

    /**
     * 获取菜单下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(Menu dept) {
        List<Menu> menus = menuService.selectMenuList(dept);
        return AjaxResult.success(menuService.buildMenuTreeSelect(menus));
    }

    /**
     * 加载对应角色菜单列表树
     */
    @GetMapping(value = "/roleMenuTreeselect/{roleId}")
    @ResponseBody
    public AjaxResult roleMenuTreeselect(@PathVariable("roleId") Long roleId) {
        return AjaxResult.success(menuService.selectMenuListByRoleId(roleId));
    }

    /**
     * 新增菜单
     */
    @PostMapping
    public AjaxResult add(@RequestBody @Validated Menu menu) {
        log.debug(String.valueOf(menu));
        if (UserConstants.NOT_UNIQUE.equals(menuService.checkMenuNameUnique(menu))) {
            return AjaxResult.error("新增菜单'" + menu.getName() + "'失败，菜单名称已存在");
        }
        menu.setCreateBy(SecurityUtils.getUserId());
        return toAjax(menuService.insertMenu(menu));
    }

    /**
     * 修改菜单
     */
    @PutMapping
    public AjaxResult edit(@RequestBody Menu menu) {
        if (UserConstants.NOT_UNIQUE.equals(menuService.checkMenuNameUnique(menu))) {
            return AjaxResult.error("修改菜单'" + menu.getName() + "'失败，菜单名称已存在");
        }
        menu.setUpdateBy(SecurityUtils.getUserId());
        return toAjax(menuService.updateMenu(menu));
    }

    /**
     * 删除菜单
     */
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable("id") Long id) {
        if (menuService.hasChildByMenuId(id)) {
            return AjaxResult.error("存在子菜单,不允许删除");
        }
        if (menuService.checkMenuExistRole(id)) {
            return AjaxResult.error("菜单已分配,不允许删除");
        }
        return toAjax(menuService.deleteMenuById(id));
    }
}
