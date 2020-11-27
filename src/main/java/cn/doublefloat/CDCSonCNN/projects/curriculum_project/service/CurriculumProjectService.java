package cn.doublefloat.CDCSonCNN.projects.curriculum_project.service;

import cn.doublefloat.CDCSonCNN.projects.curriculum_project.domain.CurriculumProject;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author 李广帅
 * @date 2020-11-27
 */
public interface CurriculumProjectService
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public CurriculumProject selectCurriculumProjectById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param curriculumProject 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CurriculumProject> selectCurriculumProjectList(CurriculumProject curriculumProject);

    /**
     * 新增【请填写功能名称】
     * 
     * @param curriculumProject 【请填写功能名称】
     * @return 结果
     */
    public int insertCurriculumProject(CurriculumProject curriculumProject);

    /**
     * 修改【请填写功能名称】
     * 
     * @param curriculumProject 【请填写功能名称】
     * @return 结果
     */
    public int updateCurriculumProject(CurriculumProject curriculumProject);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCurriculumProjectByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCurriculumProjectById(Long id);
}
