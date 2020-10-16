package cn.doublefloat.CDCSonCNN.project.student.mapper;

import cn.doublefloat.CDCSonCNN.project.student.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.List;

/**
 * @author 李广帅
 * @date 2020/9/25 5:25 下午
 */
@SpringBootTest
public class TestStudentMapper {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 添加学生信息
     */
    @Test
    void testAddStudent() {
        Student student = new Student();
        student.setNo("18090255");
        student.setName("李广帅");
        student.setCardId("320323200003277016");
        String password = passwordEncoder.encode("18090255");
        System.out.println(password.length());
        student.setPassword(password);
        student.setClassId(1L);
        student.setCreateBy(0L);
        student.setCreateTime(new Date());
        Integer integer = studentMapper.addStudent(student);
        if (integer == 1) {
            System.out.println("添加成功");
        }
    }

    /**
     * 删除学生信息Datetime
     */
    @Test
    void testDeleteStudent() {
        Student student = new Student();
        student.setId(2L);
        student.setDeleteBy(3L);
        student.setDeleteTime(new Date());
        Integer integer = studentMapper.deleteStudent(student);
        System.out.println(integer);
    }

    /**
     * 更新学生信息
     */
    @Test
    void testUpdateStudent() {
        Student student = studentMapper.findStudentById(3L);
        student.setName("无名氏");
        Integer integer = studentMapper.updateStudent(student);
        System.out.println(integer);
    }

    /**
     * 根据学生编号查找学生信息
     */
    @Test
    void testFindStudentById() {
        Student student = studentMapper.findStudentById(1L);
        System.out.println(student);
    }

    /**
     * 条件查询学生列表
     */
    @Test
    void testFindStudentList() {
        List<Student> studentList = studentMapper.findStudentList(new Student());
        studentList.forEach(System.out::println);
    }

    /**
     * 检查学生学号是否存在
     */
    @Test
    void testCheckStudentNo() {

    }

    /**
     * 检查身份证号是否存在
     */
    @Test
    void testCheckStudentCardId() {

    }
}
