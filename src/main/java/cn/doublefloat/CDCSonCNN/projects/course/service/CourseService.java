package cn.doublefloat.CDCSonCNN.projects.course.service;

import cn.doublefloat.CDCSonCNN.projects.course.domain.Course;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/26 上午11:01
 */
public interface CourseService {

    /**
     * 获取课程列表
     *
     * @param course 查询条件
     * @return 课程信息
     */
    public List<Course> list(Course course);

    /**
     * 添加课程信息
     *
     * @param course 课程信息
     * @return 结果
     */
    public int add(Course course);

    /**
     * 删除课程信息
     *
     * @param ids 课程ID
     * @return 结果
     */
    public int delete(Long[] ids);

    /**
     * 更新课程信息
     *
     * @param course 课程信息
     * @return 结果
     */
    public int update(Course course);

    /**
     * 修改课程状态
     *
     * @param course 课程信息
     * @return 结果
     */
    public int changeStatus(Course course);
}
