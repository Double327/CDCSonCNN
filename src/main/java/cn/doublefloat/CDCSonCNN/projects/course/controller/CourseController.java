package cn.doublefloat.CDCSonCNN.projects.course.controller;

import cn.doublefloat.CDCSonCNN.framework.web.controller.BaseController;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import cn.doublefloat.CDCSonCNN.framework.web.page.TableDataResult;
import cn.doublefloat.CDCSonCNN.projects.course.domain.Course;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李广帅
 * @date 2020/11/26 上午10:54
 */
@RestController
@RequestMapping("/course")
public class CourseController extends BaseController {

    @GetMapping("/list")
    public TableDataResult list(Course course) {
        return null;
    }

    @PostMapping("/add")
    public AjaxResult add(Course course) {
        return null;
    }

    @DeleteMapping("/")
    public AjaxResult delete(Long[] ids) {
        return null;
    }

    @PutMapping("/update")
    public AjaxResult update(Course course) {
        return null;
    }

    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(Course course) {
        return null;
    }
}
