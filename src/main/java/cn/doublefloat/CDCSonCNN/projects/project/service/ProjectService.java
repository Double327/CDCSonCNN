package cn.doublefloat.CDCSonCNN.projects.project.service;

import cn.doublefloat.CDCSonCNN.projects.project.domain.Project;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2020-11-27
 */
public interface ProjectService {
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Project selectProjectById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param project 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Project> selectProjectList(Project project);

    /**
     * 新增【请填写功能名称】
     *
     * @param project 【请填写功能名称】
     * @return 结果
     */
    public int insertProject(Project project);

    /**
     * 修改【请填写功能名称】
     *
     * @param project 【请填写功能名称】
     * @return 结果
     */
    public int updateProject(Project project);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteProjectByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteProjectById(Long id);
}
