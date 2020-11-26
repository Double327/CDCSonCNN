package cn.doublefloat.CDCSonCNN.projects.course.mapper;

import cn.doublefloat.CDCSonCNN.projects.course.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/26 上午11:04
 */
@Repository
public interface CourseMapper {

    /**
     * 根据ID查找课程
     *
     * @param id ID
     * @return 课程信息
     */
    public Course findCourseById(Long id);

    /**
     * 获取课程列表
     *
     * @param course 查询条件
     * @return 课程信息
     */
    public List<Course> findCourseList(Course course);

    /**
     * 添加课程信息
     *
     * @param course 课程信息
     * @return 结果
     */
    public int insertCourse(Course course);

    /**
     * 删除课程信息
     *
     * @param ids 课程ID
     * @return 结果
     */
    public int deleteCourseByIds(Long[] ids);

    /**
     * 更新课程信息
     *
     * @param course 课程信息
     * @return 结果
     */
    public int updateCourse(Course course);

    /**
     * 修改课程状态
     *
     * @param course 课程信息
     * @return 结果
     */
    public int changeStatus(Course course);
}
