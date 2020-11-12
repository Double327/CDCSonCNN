package cn.doublefloat.CDCSonCNN.projects.code_anlysis.mapper;

import cn.doublefloat.CDCSonCNN.projects.system.domain.code_anlysis.CodesVector;

/**
 * @author 魏荣轩
 * @date 2020/11/12 20:12
 */
public interface CodesVectorMapper {

    /**
     * 获取代码向量实体
     *
     * @param fileName 文件名
     * @return 实体
     */
    CodesVector selectCodesVectorAsDomain(String fileName);

    /**
     * 获取代码已有向量
     *
     * @param fileName 文件名
     * @return 向量组
     */
    String selectCodesVector(String fileName);

    /**
     * 更新代码向量
     *
     * @param codesVector 实体
     * @return 影响条数
     */
    int updateCodesVector(CodesVector codesVector);

    /**
     * 插入代码向量
     *
     * @param codesVector 实体
     * @return 影响条数
     */
    int insertCodesVector(CodesVector codesVector);

    /**
     * 删除代码向量
     *
     * @param fileName 文件名
     * @return 影响条数
     */
    int deleteCodesVector(String fileName);
}
