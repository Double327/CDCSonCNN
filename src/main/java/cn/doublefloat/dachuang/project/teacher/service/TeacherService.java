package cn.doublefloat.dachuang.project.teacher.service;

import cn.doublefloat.dachuang.project.teacher.domain.Teacher;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/9/25 4:01 下午
 */
public interface TeacherService {

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
     * @param id 教师编号
     * @return 删除结构
     */
    Integer deleteTeacher(Long id);

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
     * 检查教师学号是否存在
     *
     * @param no 学号
     * @return True：存在, False：不存在
     */
    Boolean checkTeacherNo(String no);

    /**
     * 检查身份证号是否存在
     *
     * @param cardId 身份证号
     * @return True：存在, False：不存在
     */
    Boolean checkTeacherCardId(String cardId);
}
