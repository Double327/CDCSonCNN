package cn.doublefloat.CDCSonCNN.projects.system.mapper;

import cn.doublefloat.CDCSonCNN.projects.system.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/12 10:45 上午
 */
@Repository
public interface UserMapper {
    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    List<User> selectUserList(User user);

    /**
     * 通过学工号查询用户
     *
     * @param no 学工号
     * @return 用户对象信息
     */
    User selectUserByNo(String no);

    /**
     * 通过姓名查找用户
     *
     * @param name 姓名
     * @return 用户对象信息
     */
    List<User> selectUserByName(String name);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    User selectUserById(Long userId);

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    int insertUser(User user);

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    int updateUser(User user);

    /**
     * 重置用户密码
     *
     * @param no       学工号
     * @param password 密码
     * @return 结果
     */
    int resetUserPwd(@Param("no") String no, @Param("password") String password);

    /**
     * 通过用户ID删除用户
     *
     * @param ids         用户ID
     * @param loginUserId 登录用户ID
     * @return 结果
     */
    int deleteUserByIds(@Param("ids") Long[] ids, @Param("loginUserId") Long loginUserId);

    /**
     * 校验学工号称是否唯一
     *
     * @param no 学工号
     * @return 结果
     */
    int checkNoUnique(String no);

    /**
     * 校验手机号码是否唯一
     *
     * @param phone 手机号码
     * @return 结果
     */
    User checkPhoneUnique(String phone);

    /**
     * 校验email是否唯一
     *
     * @param email 用户邮箱
     * @return 结果
     */
    User checkEmailUnique(String email);
}
