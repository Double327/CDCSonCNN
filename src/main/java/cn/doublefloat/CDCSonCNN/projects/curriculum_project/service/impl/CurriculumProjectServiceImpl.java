package cn.doublefloat.CDCSonCNN.projects.curriculum_project.service.impl;

import java.util.Date;
import java.util.List;

import cn.doublefloat.CDCSonCNN.projects.curriculum_project.domain.CurriculumProject;
import cn.doublefloat.CDCSonCNN.projects.curriculum_project.mapper.CurriculumProjectMapper;
import cn.doublefloat.CDCSonCNN.projects.curriculum_project.service.CurriculumProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2020-11-27
 */
@Service
@Slf4j
public class CurriculumProjectServiceImpl implements CurriculumProjectService {
    @Autowired
    private CurriculumProjectMapper curriculumProjectMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public CurriculumProject selectCurriculumProjectById(Long id) {
        return curriculumProjectMapper.selectCurriculumProjectById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param curriculumProject 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<CurriculumProject> selectCurriculumProjectList(CurriculumProject curriculumProject) {
        return curriculumProjectMapper.selectCurriculumProjectList(curriculumProject);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param curriculumProject 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCurriculumProject(CurriculumProject curriculumProject) {
        log.info(curriculumProject.toString());
        return curriculumProjectMapper.insertCurriculumProject(curriculumProject);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param curriculumProject 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCurriculumProject(CurriculumProject curriculumProject) {
        curriculumProject.setUpdateTime(new Date());
        return curriculumProjectMapper.updateCurriculumProject(curriculumProject);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCurriculumProjectByIds(Long[] ids) {
        return curriculumProjectMapper.deleteCurriculumProjectByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCurriculumProjectById(Long id) {
        return curriculumProjectMapper.deleteCurriculumProjectById(id);
    }
}
