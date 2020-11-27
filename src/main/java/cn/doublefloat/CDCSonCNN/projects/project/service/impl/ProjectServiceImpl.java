package cn.doublefloat.CDCSonCNN.projects.project.service.impl;

import java.util.List;

import cn.doublefloat.CDCSonCNN.projects.project.domain.Project;
import cn.doublefloat.CDCSonCNN.projects.project.mapper.ProjectMapper;
import cn.doublefloat.CDCSonCNN.projects.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目管理Service业务层处理
 *
 * @author ruoyi
 * @date 2020-11-27
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    /**
     * 查询项目
     *
     * @param id 项目ID
     * @return 项目
     */
    @Override
    public Project selectProjectById(Long id) {
        return projectMapper.selectProjectById(id);
    }

    /**
     * 查询项目列表
     *
     * @param project 项目
     * @return 项目
     */
    @Override
    public List<Project> selectProjectList(Project project) {
        return projectMapper.selectProjectList(project);
    }

    /**
     * 新增项目
     *
     * @param project 项目
     * @return 结果
     */
    @Override
    public int insertProject(Project project) {
        return projectMapper.insertProject(project);
    }

    /**
     * 修改项目
     *
     * @param project 项目
     * @return 结果
     */
    @Override
    public int updateProject(Project project) {
        return projectMapper.updateProject(project);
    }

    /**
     * 批量删除项目
     *
     * @param ids 需要删除的项目ID
     * @return 结果
     */
    @Override
    public int deleteProjectByIds(Long[] ids) {
        return projectMapper.deleteProjectByIds(ids);
    }

    /**
     * 删除项目信息
     *
     * @param id 项目ID
     * @return 结果
     */
    @Override
    public int deleteProjectById(Long id) {
        return projectMapper.deleteProjectById(id);
    }
}
