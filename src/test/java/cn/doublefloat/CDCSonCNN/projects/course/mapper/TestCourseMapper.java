package cn.doublefloat.CDCSonCNN.projects.course.mapper;

import cn.doublefloat.CDCSonCNN.projects.course.domain.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/26 上午11:42
 */
@SpringBootTest
public class TestCourseMapper {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void testList() {
        List<Course> list = courseMapper.list(new Course());
        list.forEach(System.out::println);
    }
}
