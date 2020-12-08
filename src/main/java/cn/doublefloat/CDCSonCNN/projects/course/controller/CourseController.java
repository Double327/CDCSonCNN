package cn.doublefloat.CDCSonCNN.projects.course.controller;

import cn.doublefloat.CDCSonCNN.common.utils.SecurityUtils;
import cn.doublefloat.CDCSonCNN.common.utils.ServletUtils;
import cn.doublefloat.CDCSonCNN.framework.web.controller.BaseController;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import cn.doublefloat.CDCSonCNN.framework.web.page.TableDataResult;
import cn.doublefloat.CDCSonCNN.projects.course.domain.Course;
import cn.doublefloat.CDCSonCNN.projects.course.service.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李广帅
 * @date 2020/11/26 上午10:54
 */
@Api(tags = "课程信息接口")
@RestController
@RequestMapping("/course")
public class CourseController extends BaseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    public TableDataResult list(Course course) {
        return getTableData(courseService.list(course));
    }

    @PostMapping
    public AjaxResult add(@RequestBody Course course) {
        course.setCreateBy(SecurityUtils.getUserId());
        return toAjax(courseService.add(course));
    }

    @DeleteMapping("/{ids}")
    public AjaxResult delete(@PathVariable Long[] ids) {
        return toAjax(courseService.delete(ids));
    }

    @PutMapping
    public AjaxResult update(@RequestBody Course course) {
        course.setUpdateBy(SecurityUtils.getUserId());
        return toAjax(courseService.update(course));
    }

    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody Course course) {
        course.setUpdateBy(SecurityUtils.getUserId());
        return toAjax(courseService.changeStatus(course));
    }
}
