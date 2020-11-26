package cn.doublefloat.CDCSonCNN.projects.code_analysis.controller;

import cn.doublefloat.CDCSonCNN.projects.code_analysis.service.CodesVectorService;
import cn.doublefloat.CDCSonCNN.projects.system.domain.code_analysis.CodesVec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 魏荣轩
 * @date 2020/11/14 10:28
 */
@Controller
public class CodesVectorController {

    @Autowired
    private CodesVectorService codesVectorService;

    /**
     * 新增代码向量
     *
     * @param codeFile 代码文件ID
     * @param vector 向量
     * @return 新增条数
     */
    public int insertCodesVector(String codeFile, String vector){
        return codesVectorService.insertCodesVector(codeFile, vector);
    }

    /**
     * 删除代码向量
     *
     * @param codeFile 代码文件ID
     * @return 删除条数
     */
    public int deleteCodeVector(String codeFile){
        return codesVectorService.deleteCodesVector(codeFile);
    }

    /**
     * 搜索代码向量实体
     *
     * @param codeFile 代码文件ID
     * @return 代码向量实体
     */
    public CodesVec selectCodesVectorByCodeFile(String codeFile){
        return codesVectorService.selectCodesVectorDomain(codeFile);
    }

    /**
     * 更新代码向量
     *
     * @param codeFile 代码文件
     * @param vector 预处理文本
     * @return 更新条数
     */
    public int updateCodesVector(String codeFile, String vector){
        return codesVectorService.updateCodesVector(codeFile, vector);
    }

}
