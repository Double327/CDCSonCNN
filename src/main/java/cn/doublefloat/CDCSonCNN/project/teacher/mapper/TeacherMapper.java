package cn.doublefloat.CDCSonCNN.project.teacher.mapper;

import cn.doublefloat.CDCSonCNN.project.teacher.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/10/16 9:04 上午
 */
@Repository
public interface TeacherMapper {
    /**
     * 添加教师信息
     *
     * @param teacher 教师信息
     * @return 添加结果
     */
    Integer addTeacher(Teacher teacher);

    /**
     * 删除教师信息
     *
     * @param teacher 教师信息
     * @return 删除结构
     */
    Integer deleteTeacher(Teacher teacher);

    /**
     * 更新教师信息
     *
     * @param teacher 教师信息
     * @return 更新结果
     */
    Integer updateTeacher(Teacher teacher);

    /**
     * 根据教师编号查找教师信息
     *
     * @param id 教师编号
     * @return 教师信息
     */
    Teacher findTeacherById(Long id);

    /**
     * 条件查询教师列表
     *
     * @param teacher 查询条件
     * @return 教师信息列表
     */
    List<Teacher> findTeacherList(Teacher teacher);

    /**
     * 检查教师是否存在
     *
     * @param id ID
     * @return 结果
     */
    Integer checkTeacherExist(Long id);

    /**
     * 检查教师工号是否存在
     *
     * @param no 工号
     * @return True：存在, False：不存在
     */
    Integer checkTeacherNoUnique(String no);

    /**
     * 检查身份证号是否存在
     *
     * @param cardId 身份证号
     * @return True：存在, False：不存在
     */
    Integer checkTeacherCardIdUnique(String cardId);
}
