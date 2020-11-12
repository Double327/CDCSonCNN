package cn.doublefloat.CDCSonCNN.projects.system.mapper;

import cn.doublefloat.CDCSonCNN.projects.system.domain.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/12 11:17 上午
 */
@SpringBootTest
public class TestMenuMapper {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询系统菜单列表
     */
    @Test
    void selectMenuList() {
        List<Menu> menus = menuMapper.selectMenuList(new Menu());
        menus.forEach(System.out::println);
    }

    /**
     * 根据用户所有权限
     */
    @Test
    void selectMenuPerms() {
        List<String> list = menuMapper.selectMenuPerms();
        list.forEach(System.out::println);
    }

    /**
     * 根据用户ID查询权限
     */
    @Test
    void selectMenuPermsByUserId() {
        List<String> list = menuMapper.selectMenuPermsByUserId(1L);
        list.forEach(System.out::println);
    }

    /**
     * 根据用户ID查询菜单
     */
    @Test
    void selectMenuTreeAll() {
        List<Menu> menus = menuMapper.selectMenuTreeAll();
        menus.forEach(System.out::println);
    }

    /**
     * 根据用户ID查询菜单
     */
    @Test
    void selectMenuTreeByUserId() {
        List<Menu> menus = menuMapper.selectMenuTreeByUserId(1L);
        menus.forEach(System.out::println);
    }

    /**
     * 根据角色ID查询菜单树信息
     */
    void selectMenuListByRoleId() {

    }

    /**
     * 根据菜单ID查询信息
     */
    void selectMenuById() {

    }

    /**
     * 是否存在菜单子节点
     */
    void hasChildByMenuId() {

    }

    /**
     * 新增菜单信息
     */
    void insertMenu() {

    }

    /**
     * 修改菜单信息
     */
    void updateMenu() {

    }

    /**
     * 删除菜单管理信息
     */
    void deleteMenuById() {

    }

    /**
     * 校验菜单名称是否唯一
     */
    void checkMenuNameUnique() {

    }
}
