package cn.doublefloat.CDCSonCNN.projects.iclass.service;

import cn.doublefloat.CDCSonCNN.projects.iclass.domain.Iclass;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/12/7 10:16 下午
 */
public interface IclassService {
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Iclass selectIclassById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param iclass 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Iclass> selectIclassList(Iclass iclass);

    /**
     * 新增【请填写功能名称】
     *
     * @param iclass 【请填写功能名称】
     * @return 结果
     */
    public int insertIclass(Iclass iclass);

    /**
     * 修改【请填写功能名称】
     *
     * @param iclass 【请填写功能名称】
     * @return 结果
     */
    public int updateIclass(Iclass iclass);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteIclassByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteIclassById(Long id);
}
