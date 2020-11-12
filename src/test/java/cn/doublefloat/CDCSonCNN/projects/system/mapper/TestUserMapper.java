package cn.doublefloat.CDCSonCNN.projects.system.mapper;

import cn.doublefloat.CDCSonCNN.projects.system.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * @author 李广帅
 * @date 2020/11/12 10:22 下午
 */
@SpringBootTest
public class TestUserMapper {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据条件分页查询用户列表
     */
    @Test
    void selectUserList() {
        List<User> users = userMapper.selectUserList(new User());
        users.forEach(System.out::println);
    }

    /**
     * 通过学工号查询用户
     */
    @Test
    void selectUserByNo() {
        User user = userMapper.selectUserByNo("18090255");
        System.out.println(user);
    }

    /**
     * 通过姓名查找用户
     */
    void selectUserByName() {
    }

    /**
     * 通过用户ID查询用户
     */
    void selectUserById() {
    }

    /**
     * 新增用户信息
     */
    void insertUser() {
    }

    /**
     * 修改用户信息
     */
    void updateUser() {
    }

    /**
     * 重置用户密码
     */
    void resetUserPwd() {
    }

    /**
     * 通过用户ID删除用户
     */
    void deleteUserByIds() {
    }

    /**
     * 校验学工号称是否唯一
     */
    void checkNoUnique() {
    }

    /**
     * 校验手机号码是否唯一
     */
    void checkPhoneUnique() {
    }

    /**
     * 校验email是否唯一
     */
    void checkEmailUnique() {
    }
}
