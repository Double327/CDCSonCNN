package cn.doublefloat.CDCSonCNN.projects.course.mapper;

import cn.doublefloat.CDCSonCNN.projects.course.domain.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
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
        List<Course> list = courseMapper.findCourseList(new Course());
        list.forEach(System.out::println);
    }

    @Test
    public void testAdd() {
        Course course = new Course();
        course.setName("设计模式");
        course.setTeacherId(1L);
        course.setClassHour(10);
        course.setCredits(10);
        course.setCreateBy(1L);
        course.setCreateTime(new Date());
        int add = courseMapper.insertCourse(course);
        System.out.println(add);
    }

    @Test
    public void testUpdate() {
        Course course = courseMapper.findCourseById(1L);
        course.setName("计算机网络");
        int update = courseMapper.updateCourse(course);
        System.out.println(update);
    }

    @Test
    public void testDelete() {
        Long[] ids = {1L, 2L};
        int res = courseMapper.deleteCourseByIds(ids);
        System.out.println(res);
    }

    @Test
    public void testChangeCourseStatus() {
        Course course = new Course();
        course.setId(1L);
        course.setStatus("1");
        int i = courseMapper.changeStatus(course);
        System.out.println(i);
    }
}
