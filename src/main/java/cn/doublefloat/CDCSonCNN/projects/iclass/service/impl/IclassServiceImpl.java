package cn.doublefloat.CDCSonCNN.projects.iclass.service.impl;

import cn.doublefloat.CDCSonCNN.projects.iclass.domain.Iclass;
import cn.doublefloat.CDCSonCNN.projects.iclass.mapper.IclassMapper;
import cn.doublefloat.CDCSonCNN.projects.iclass.service.IclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 李广帅
 * @date 2020/12/7 10:25 下午
 */
@Service
public class IclassServiceImpl implements IclassService {
    @Autowired
    private IclassMapper iclassMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Iclass selectIclassById(Long id) {
        return iclassMapper.selectIclassById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param iclass 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Iclass> selectIclassList(Iclass iclass) {
        return iclassMapper.selectIclassList(iclass);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param iclass 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertIclass(Iclass iclass) {
        iclass.setCreateTime(new Date());
        return iclassMapper.insertIclass(iclass);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param iclass 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateIclass(Iclass iclass) {
        iclass.setUpdateTime(new Date());
        return iclassMapper.updateIclass(iclass);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteIclassByIds(Long[] ids) {
        return iclassMapper.deleteIclassByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteIclassById(Long id) {
        return iclassMapper.deleteIclassById(id);
    }
}
