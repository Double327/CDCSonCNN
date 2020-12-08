package cn.doublefloat.CDCSonCNN.projects.curriculum_project.controller;

import java.security.Security;
import java.util.List;

import cn.doublefloat.CDCSonCNN.common.utils.SecurityUtils;
import cn.doublefloat.CDCSonCNN.common.utils.ServletUtils;
import cn.doublefloat.CDCSonCNN.framework.web.controller.BaseController;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import cn.doublefloat.CDCSonCNN.framework.web.page.TableDataResult;
import cn.doublefloat.CDCSonCNN.projects.curriculum_project.domain.CurriculumProject;
import cn.doublefloat.CDCSonCNN.projects.curriculum_project.service.CurriculumProjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 课题Controller
 *
 * @author 李广帅
 * @date 2020-11-27
 */
@Api(tags = "课题管理接口")
@RestController
@RequestMapping("/curriculumProject")
public class CurriculumProjectController extends BaseController {
    @Autowired
    private CurriculumProjectService CurriculumProjectService;

    /**
     * 查询课题列表
     */
    @GetMapping("/list")
    public TableDataResult list(CurriculumProject curriculumProject) {
        startPage();
        List<CurriculumProject> list = CurriculumProjectService.selectCurriculumProjectList(curriculumProject);
        return getTableData(list);
    }

//    /**
//     * 导出课题列表
//     */
//    @GetMapping("/export")
//    public AjaxResult export(CurriculumProject curriculumProject)
//    {
//        List<CurriculumProject> list = CurriculumProjectService.selectCurriculumProjectList(curriculumProject);
//        ExcelUtil<CurriculumProject> util = new ExcelUtil<CurriculumProject>(CurriculumProject.class);
//        return util.exportExcel(list, "project");
//    }

    /**
     * 获取课题详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(CurriculumProjectService.selectCurriculumProjectById(id));
    }

    /**
     * 新增课题
     */
    @PostMapping
    public AjaxResult add(@RequestBody CurriculumProject curriculumProject) {
        curriculumProject.setCreateBy(SecurityUtils.getUserId());
        curriculumProject.setCreateBy(1L);
        return toAjax(CurriculumProjectService.insertCurriculumProject(curriculumProject));
    }

    /**
     * 修改课题
     */
    @PutMapping
    public AjaxResult edit(@RequestBody CurriculumProject curriculumProject) {
        return toAjax(CurriculumProjectService.updateCurriculumProject(curriculumProject));
    }

    /**
     * 删除课题
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(CurriculumProjectService.deleteCurriculumProjectByIds(ids));
    }
}
