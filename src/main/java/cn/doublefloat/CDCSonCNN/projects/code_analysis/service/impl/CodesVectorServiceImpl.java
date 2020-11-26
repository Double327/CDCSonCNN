package cn.doublefloat.CDCSonCNN.projects.code_analysis.service.impl;

import cn.doublefloat.CDCSonCNN.projects.code_analysis.mapper.CodesVectorMapper;
import cn.doublefloat.CDCSonCNN.projects.code_analysis.service.CodesVectorService;
import cn.doublefloat.CDCSonCNN.projects.system.domain.code_analysis.CodesVec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        return codesVectorMapper.selectCodesVector(codeFile);
    }

    /**
     * 获取代码向量对象
     *
     * @param codeFile 代码文件标示
     * @return 实体
     */
    @Override
    public CodesVec selectCodesVectorDomain(String codeFile) {
        return codesVectorMapper.selectCodesVectorAsDomain(codeFile);
    }

    /**
     * 更新数据库中的代码向量
     *
     * @param codeFile 代码文件
     * @param vector 代码预处理文件
     * @return 更细条数
     */
    @Override
    public int updateCodesVector(String codeFile, String vector) {
        if(codesVectorMapper.selectCodesVector(codeFile) != null) {
            return codesVectorMapper.updateCodesVector(new CodesVec(codeFile, vector, new Date()));
        }else {
            return 0;
        }
    }

    /**
     * 删除代码向量
     *
     * @param codeFile 代码标识
     * @return 删除条数
     */
    @Override
    public int deleteCodesVector(String codeFile) {
        if(codesVectorMapper.selectCodesVector(codeFile) != null) {
            return codesVectorMapper.deleteCodesVector(codeFile);
        }else {
            return 0;
        }
    }

    /**
     * 插入代码向量
     *
     * @param codeFile 代码
     * @param vector 代码预处理
     * @return 影响条数
     */
    @Override
    public int insertCodesVector(String codeFile, String vector) {
        if(codesVectorMapper.selectCodesVector(codeFile) == null) {
            return codesVectorMapper.insertCodesVector(new CodesVec(codeFile, vector, new Date()));
        }else {
            return 0;
        }
    }
}
