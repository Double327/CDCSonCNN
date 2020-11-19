package cn.doublefloat.CDCSonCNN.projects.project.controller;

import cn.doublefloat.CDCSonCNN.common.exception.CustomException;
import cn.doublefloat.CDCSonCNN.common.utils.FileUtils;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import cn.doublefloat.CDCSonCNN.projects.project.domain.Project;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author 李广帅
 * @date 2020/10/30 2:51 下午
 */
@RestController
@RequestMapping("/project")
@Slf4j
@Api(tags = "项目管理接口")
public class ProjectController {

    /**
     * 项目存储路径
     */
    @Value("${project.path}")
    private String projectPath;

    @PostMapping("/upload")
    public AjaxResult uploadProject(@RequestParam MultipartFile file, @RequestParam Project project) {
        try {
            InputStream inputStream = file.getInputStream();
            log.info("文件保存路径:" + projectPath);
            log.info("上传文件名:" + file.getOriginalFilename());
            FileUtils.saveFile((FileInputStream) inputStream, projectPath, file.getOriginalFilename());
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
        return AjaxResult.success("项目文件上传成功!");
    }

    @PutMapping("/update")
    public AjaxResult updateProject(Project project) {
        return AjaxResult.success("操作成功");
    }


}
