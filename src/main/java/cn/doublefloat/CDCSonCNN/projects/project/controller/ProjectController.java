package cn.doublefloat.CDCSonCNN.projects.project.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import cn.doublefloat.CDCSonCNN.common.exception.CustomException;
import cn.doublefloat.CDCSonCNN.common.utils.FileUtils;
import cn.doublefloat.CDCSonCNN.framework.web.controller.BaseController;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import cn.doublefloat.CDCSonCNN.framework.web.page.TableDataResult;
import cn.doublefloat.CDCSonCNN.projects.project.domain.Project;
import cn.doublefloat.CDCSonCNN.projects.project.service.ProjectService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 项目管理Controller
 *
 * @author 李广帅
 * @date 2020-11-27
 */
@Api(tags = "学生项目管理接口")
@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;

    /**
     * 项目存储路径
     */
    @Value("${project.path}")
    private String projectPath;

    @PostMapping("/upload")
    public AjaxResult uploadProject(@RequestParam MultipartFile file, @RequestParam Long projectId) {
        try {
            InputStream inputStream = file.getInputStream();
            log.info("文件保存路径:" + projectPath);
            log.info("上传文件名:" + file.getOriginalFilename());
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
        return AjaxResult.success("项目文件上传成功!");
    }

    /**
     * 查询项目列表
     */
    @GetMapping("/list")
    public TableDataResult list(Project project) {
        startPage();
        List<Project> list = projectService.selectProjectList(project);
        return getTableData(list);
    }

//    /**
//     * 导出项目列表
//     */
//    @PreAuthorize("@ss.hasPermi('system:project:export')")
//    @Log(title = "项目", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(Project project)
//    {
//        List<Project> list = ProjectService.selectProjectList(project);
//        ExcelUtil<Project> util = new ExcelUtil<Project>(Project.class);
//        return util.exportExcel(list, "project");
//    }

    /**
     * 获取项目详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(projectService.selectProjectById(id));
    }

    /**
     * 新增项目
     */
    @PostMapping
    public AjaxResult add(Project project) {
        return toAjax(projectService.insertProject(project));
    }

    /**
     * 修改项目
     */
    @PutMapping
    public AjaxResult edit(Project project) {
        return toAjax(projectService.updateProject(project));
    }

    /**
     * 删除项目
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(projectService.deleteProjectByIds(ids));
    }
}
