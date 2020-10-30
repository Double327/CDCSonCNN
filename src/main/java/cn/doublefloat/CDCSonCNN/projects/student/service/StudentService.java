package cn.doublefloat.CDCSonCNN.projects.student.service;

import cn.doublefloat.CDCSonCNN.projects.student.domain.Student;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/9/25 3:44 下午
 */
public interface StudentService {

    /**
     * 添加学生信息
     *
     * @param student 学生信息
     * @return 添加结果
     */
    Integer addStudent(Student student);

    /**
     * 删除学生信息
     *
     * @param id 学生编号
     * @return 删除结构
     */
    Integer deleteStudent(Long id);

    /**
     * 更新学生信息
     *
     * @param student 学生信息
     * @return 更新结果
     */
    Integer updateStudent(Student student);

    /**
     * 根据学生编号查找学生信息
     *
     * @param id 学生编号
     * @return 学生信息
     */
    Student findStudentById(Long id);

    /**
     * 根据学号查找学生信息
     *
     * @param no 学号
     * @return 学生信息
     */
    Student findStudentByNo(String no);

    /**
     * 条件查询学生列表
     *
     * @param student 查询条件
     * @return 学生信息列表
     */
    List<Student> findStudentList(Student student);

    /**
     * 检查学生是否存在
     *
     * @param id 学生ID
     * @return True：存在, False：不存在
     */
    Boolean checkStudentExist(Long id);

    /**
     * 检查学生学号是否存在
     *
     * @param no 学号
     * @return True：存在, False：不存在
     */
    Boolean checkStudentNo(String no);

    /**
     * 检查身份证号是否存在
     *
     * @param cardId 身份证号
     * @return True：存在, False：不存在
     */
    Boolean checkStudentCardId(String cardId);

}
