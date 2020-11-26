package cn.doublefloat.CDCSonCNN.projects.course.service.impl;

import cn.doublefloat.CDCSonCNN.projects.course.domain.Course;
import cn.doublefloat.CDCSonCNN.projects.course.mapper.CourseMapper;
import cn.doublefloat.CDCSonCNN.projects.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/26 上午11:03
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Course findCourseById(Long id) {
        return courseMapper.findCourseById(id);
    }

    @Override
    public List<Course> list(Course course) {
        return courseMapper.findCourseList(course);
    }

    @Override
    public int add(Course course) {
        return courseMapper.insertCourse(course);
    }

    @Override
    public int delete(Long[] ids) {
        return courseMapper.deleteCourseByIds(ids);
    }

    @Override
    public int update(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public int changeStatus(Course course) {
        return courseMapper.changeStatus(course);
    }
}
