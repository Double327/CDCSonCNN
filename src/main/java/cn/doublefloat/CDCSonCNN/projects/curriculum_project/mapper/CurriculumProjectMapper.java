package cn.doublefloat.CDCSonCNN.projects.curriculum_project.mapper;

import cn.doublefloat.CDCSonCNN.projects.curriculum_project.domain.CurriculumProject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 课题管理Mapper接口
 *
 * @author 李广帅
 * @date 2020-11-27
 */
@Repository
public interface CurriculumProjectMapper {
    /**
     * 查询 课题管理
     *
     * @param id ID
     * @return 结果
     */
    CurriculumProject selectCurriculumProjectById(Long id);

    /**
     * 查询课题列表
     *
     * @param curriculumProject 课题
     * @return 课题集合
     */
    List<CurriculumProject> selectCurriculumProjectList(CurriculumProject curriculumProject);

    /**
     * 新增课题
     *
     * @param curriculumProject 课题
     * @return 结果
     */
    int insertCurriculumProject(CurriculumProject curriculumProject);

    /**
     * 修改课题
     *
     * @param curriculumProject 课题
     * @return 结果
     */
    int updateCurriculumProject(CurriculumProject curriculumProject);

    /**
     * 删除课题
     *
     * @param id 课题ID
     * @return 结果
     */
    int deleteCurriculumProjectById(Long id);

    /**
     * 批量删除课题
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteCurriculumProjectByIds(Long[] ids);
}
