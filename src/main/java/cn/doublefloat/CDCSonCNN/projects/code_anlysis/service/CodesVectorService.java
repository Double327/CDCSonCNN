package cn.doublefloat.CDCSonCNN.projects.code_anlysis.service;

import cn.doublefloat.CDCSonCNN.projects.system.domain.code_anlysis.CodesVector;

/**
 * @author 魏荣轩
 * @date 2020/11/14 10:16
 */
public interface CodesVectorService {
    /**
     * 获取代码向量
     *
     * @param codeFile 代码文件标示
     * @return 向量字符串
     */
    String selectCodesVector(String codeFile);

    /**
     * 获取代码向量对象
     *
     * @param codeFile 代码文件标示
     * @return 实体
     */
    CodesVector selectCodesVectorDomain(String codeFile);

    /**
     * 更新数据库中的代码向量
     *
     * @param codesVector 代码向量
     * @return 更细条数
     */
    int updateCodesVector(CodesVector codesVector);

    /**
     * 删除代码向量
     *
     * @param codeFile 代码标识
     * @return 删除条数
     */
    int deleteCodesVector(String codeFile);

    /**
     * 插入代码向量
     *
     * @param codesVector 代码向量
     * @return 影响条数
     */
    int insertCodesVector(CodesVector codesVector);
}
