package cn.doublefloat.CDCSonCNN.project.student.controller;

import cn.doublefloat.CDCSonCNN.framework.web.controller.BaseController;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import cn.doublefloat.CDCSonCNN.framework.web.page.TableDataResult;
import cn.doublefloat.CDCSonCNN.project.student.domain.Student;
import cn.doublefloat.CDCSonCNN.project.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/9/25 3:33 下午
 */
@CrossOrigin
@RestController
@RequestMapping("/student")
@Api(tags = "学生接口")
public class StudentController extends BaseController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/add")
    @ApiOperation(value = "添加学生信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "no", value = "学号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "cardId", value = "身份证号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "classId", value = "班级ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "birth", value = "出生日期", dataType = "Date"),
            @ApiImplicitParam(name = "sex", value = "性别", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
    })
    public AjaxResult addStudent(Student student) {
        return toAjax(studentService.addStudent(student));
    }

    @ApiOperation(value = "学生删除信息接口")
    @DeleteMapping("/delete/{id}")
    public AjaxResult deleteStudent(@PathVariable Long id) {
        return toAjax(studentService.deleteStudent(id));
    }

    @ApiOperation(value = "学生修改信息接口")
    @PutMapping("/update")
    public AjaxResult updateStudent(Student student) {
        return toAjax(studentService.updateStudent(student));
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value = "学生信息查询接口")
    public AjaxResult findStudentById(@PathVariable Long id) {
        return AjaxResult.success(studentService.findStudentById(id));
    }

    @GetMapping("/list")
    @ApiOperation(value = "学生信息列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "请求页数", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "页面数据数", required = true, dataType = "String"),
            @ApiImplicitParam(name = "orderColumn", value = "排序字段名", required = false, dataType = "String"),
            @ApiImplicitParam(name = "asc", value = "排序方式", required = false, dataType = "String"),
    })
    public TableDataResult findStudentList(Student student) {
        startPage();
        List<Student> studentList = studentService.findStudentList(student);
        return getTableData(studentList);
    }
}
