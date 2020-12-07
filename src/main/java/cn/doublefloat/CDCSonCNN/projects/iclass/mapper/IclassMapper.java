package cn.doublefloat.CDCSonCNN.projects.iclass.mapper;

import cn.doublefloat.CDCSonCNN.projects.iclass.domain.Iclass;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/12/7 10:17 下午
 */
@Repository
public interface IclassMapper {
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
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteIclassById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteIclassByIds(Long[] ids);
}
