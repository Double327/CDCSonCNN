package cn.doublefloat.CDCSonCNN.projects.course.service;

import cn.doublefloat.CDCSonCNN.projects.course.domain.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/26 下午4:00
 */
@SpringBootTest
public class TestCourseService {

    @Autowired
    private CourseService courseService;

    @Test
    public void testList() {
        List<Course> list = courseService.list(new Course());
        list.forEach(System.out::println);
    }
}
