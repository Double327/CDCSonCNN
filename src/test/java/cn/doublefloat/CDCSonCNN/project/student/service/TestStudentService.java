package cn.doublefloat.CDCSonCNN.project.student.service;

import cn.doublefloat.CDCSonCNN.project.student.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/9/26 9:10 下午
 */
@SpringBootTest
public class TestStudentService {

    @Autowired
    private StudentService studentService;

    @Test
    public void testAddStudent() {
        for (int i = 6; i < 100; i++) {
            Student student = new Student();
            /*学号*/
            student.setNo(String.format("18090%3d", i));
            System.out.println(String.format("18090%3d", i));
            /*姓名*/
            student.setName("牛生辉");
            /*身份证*/
            student.setCardId("320323200000000000");
            /*班级ID*/
            student.setClassId(1L);
            /*密码*/
            student.setPassword("90259");
//            Integer result = studentService.addStudent(student);
//            System.out.println(result);
        }
    }

    @Test
    public void testDeleteStudent() {
        Integer result = studentService.deleteStudent(10L);
        System.out.println(result);
    }

    @Test
    public void testUpdateStudent() {

    }

    @Test
    public void testFindStudentById() {
        Student studentById = studentService.findStudentById(11L);
        System.out.println(studentById);
    }

    @Test
    public void testFindStudentList() {
        Student student = new Student();
        student.setName("牛生辉");
        List<Student> studentList = studentService.findStudentList(student);
        studentList.forEach(System.out::println);
    }

    @Test
    public void testCheckStudentNo() {

    }

    @Test
    public void testCheckStudentCardId() {

    }
}
