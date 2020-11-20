package cn.doublefloat.CDCSonCNN.projects.code_analysis.service.impl;

import cn.doublefloat.CDCSonCNN.projects.code_analysis.mapper.CodesVectorMapper;
import cn.doublefloat.CDCSonCNN.projects.code_analysis.service.CodesVectorService;
import cn.doublefloat.CDCSonCNN.projects.system.domain.code_anlysis.CodesVector;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 魏荣轩
 * @date 2020/11/14 10:26
 */
@Service
public class CodesVectorServiceImpl implements CodesVectorService {

    @Autowired
    private CodesVectorMapper codesVectorMapper;

    /**
     * 获取代码向量
     *
     * @param codeFile 代码文件标示
     * @return 向量字符串
     */
    @Override
    public String selectCodesVector(String codeFile) {
        return null;
    }

    /**
     * 获取代码向量对象
     *
     * @param codeFile 代码文件标示
     * @return 实体
     */
    @Override
    public CodesVector selectCodesVectorDomain(String codeFile) {
        return null;
    }

    /**
     * 更新数据库中的代码向量
     *
     * @param codesVector 代码向量
     * @return 更细条数
     */
    @Override
    public int updateCodesVector(CodesVector codesVector) {
        return 0;
    }

    /**
     * 删除代码向量
     *
     * @param codeFile 代码标识
     * @return 删除条数
     */
    @Override
    public int deleteCodesVector(String codeFile) {
        return 0;
    }

    /**
     * 插入代码向量
     *
     * @param codesVector 代码向量
     * @return 影响条数
     */
    @Override
    public int insertCodesVector(CodesVector codesVector) {
        return 0;
    }
}
