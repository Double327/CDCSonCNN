package cn.doublefloat.CDCSonCNN.project.teacher.mapper;

import cn.doublefloat.CDCSonCNN.project.teacher.domain.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.List;

/**
 * @author 李广帅
 * @date 2020/10/16 10:45 下午
 */
@SpringBootTest
public class TestTeacherMapper {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private TeacherMapper teacherMapper;


    @Test
    void testAddTeacher() {
        Teacher teacher = new Teacher();
        teacher.setNo("123456790");
        teacher.setName("张三");
        teacher.setCardId("123456789101112131");
        teacher.setCollege("智慧教育学院");
        teacher.setPassword(passwordEncoder.encode("123456"));
        teacher.setCreateBy(1L);
        teacher.setCreateTime(new Date());
        Integer integer = teacherMapper.addTeacher(teacher);
        System.out.println(integer);
    }


    @Test
    void testDeleteTeacher() {
    }


    @Test
    void testUpdateTeacher() {

    }


    @Test
    void testFindTeacherById() {
        Teacher teacher = teacherMapper.findTeacherById(1L);
        System.out.println(teacher);
    }


    @Test
    void testFindTeacherList() {
        Teacher teacher = new Teacher();
        teacher.setId(0L);
        System.out.println(teacher.getId() == null);
//        teacher.setName("张三");
        List<Teacher> teacherList = teacherMapper.findTeacherList(teacher);
        teacherList.forEach(System.out::println);
    }


    @Test
    void testCheckTeacherExist() {
        Integer integer = teacherMapper.checkTeacherExist(1L);
        System.out.println(integer);
    }


    @Test
    void testCheckTeacherNoUnique() {
    }


    @Test
    void testCheckTeacherCardIdUnique() {
    }
}
