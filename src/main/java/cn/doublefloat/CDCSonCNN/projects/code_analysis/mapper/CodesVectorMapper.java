package cn.doublefloat.CDCSonCNN.projects.code_analysis.mapper;

import cn.doublefloat.CDCSonCNN.projects.system.domain.code_analysis.CodesVec;
import org.springframework.stereotype.Repository;

/**
 * @author 魏荣轩
 * @date 2020/11/12 20:12
 */
@Repository
public interface CodesVectorMapper {

    /**
     * 获取代码向量实体
     *
     * @param fileName 文件名
     * @return 实体
     */
    CodesVec selectCodesVectorAsDomain(String fileName);

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
     * @param codesVec 实体
     * @return 影响条数
     */
    int updateCodesVector(CodesVec codesVec);

    /**
     * 插入代码向量
     *
     * @param codesVec 实体
     * @return 影响条数
     */
    int insertCodesVector(CodesVec codesVec);

    /**
     * 删除代码向量
     *
     * @param fileName 文件名
     * @return 影响条数
     */
    int deleteCodesVector(String fileName);
}
