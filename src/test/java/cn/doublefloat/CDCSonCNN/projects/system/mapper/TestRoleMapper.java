package cn.doublefloat.CDCSonCNN.projects.system.mapper;

import cn.doublefloat.CDCSonCNN.projects.system.domain.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/12 11:35 上午
 */
@SpringBootTest
public class TestRoleMapper {

    @Autowired
    private RoleMapper roleMapper;


    @Test
    void selectRoleList() {
        List<Role> roles = roleMapper.selectRoleList(new Role());
        roles.forEach(System.out::println);
    }
}
