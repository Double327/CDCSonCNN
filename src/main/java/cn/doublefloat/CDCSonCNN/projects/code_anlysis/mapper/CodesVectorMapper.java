package cn.doublefloat.CDCSonCNN.projects.code_anlysis.mapper;

/**
 * @author 魏荣轩
 * @date 2020/11/12 20:12
 */
public interface CodesVectorMapper {
    /**
     * 获取代码已有向量
     *
     * @param fileName 文件名
     * @return 向量组
     */
    StringBuffer selectCodesVector(String fileName);

    /**
     * 更新代码向量
     *
     * @param codesVector 代码向量
     * @param fileName 文件名
     * @return 影响条数
     */
    int updateCodesVector(StringBuffer codesVector, String fileName);

    /**
     * 插入代码向量
     *
     * @param codesVector 代码向量
     * @param fileName 文件名
     * @return 影响条数
     */
    int insertCodesVector(StringBuffer codesVector, String fileName);

    /**
     * 删除代码向量
     *
     * @param fileName 文件名
     * @return 影响条数
     */
    int deleteCodesVector(String fileName);
}
