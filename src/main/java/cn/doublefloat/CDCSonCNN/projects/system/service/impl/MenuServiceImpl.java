package cn.doublefloat.CDCSonCNN.projects.system.service.impl;

import cn.doublefloat.CDCSonCNN.projects.system.domain.Menu;
import cn.doublefloat.CDCSonCNN.projects.system.domain.vo.RouterVo;
import cn.doublefloat.CDCSonCNN.projects.system.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author 李广帅
 * @date 2020/11/12 2:03 下午
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Override
    public List<Menu> selectMenuList(Menu menu) {
        return null;
    }

    @Override
    public Set<String> selectMenuPermsByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Menu> selectMenuTreeByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Integer> selectMenuListByRoleId(Long roleId) {
        return null;
    }

    @Override
    public List<RouterVo> buildMenus(List<Menu> menus) {
        return null;
    }

    @Override
    public List<Menu> buildMenuTree(List<Menu> menus) {
        return null;
    }

    @Override
    public Menu selectMenuById(Long menuId) {
        return null;
    }

    @Override
    public boolean hasChildByMenuId(Long menuId) {
        return false;
    }

    @Override
    public boolean checkMenuExistRole(Long menuId) {
        return false;
    }

    @Override
    public int insertMenu(Menu menu) {
        return 0;
    }

    @Override
    public int updateMenu(Menu menu) {
        return 0;
    }

    @Override
    public int deleteMenuById(Long menuId) {
        return 0;
    }

    @Override
    public String checkMenuNameUnique(Menu menu) {
        return null;
    }
}
