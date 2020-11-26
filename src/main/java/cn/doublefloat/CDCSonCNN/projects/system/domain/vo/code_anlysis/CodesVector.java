package cn.doublefloat.CDCSonCNN.projects.system.domain.vo.code_anlysis;

import cn.doublefloat.CDCSonCNN.projects.system.domain.code_analysis.CodesVec;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author 魏荣轩
 * @date 2020/11/18 9:54
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CodesVector {
    private String codeId;
    private String simHash;
    private String winnowing;
    /**
     * 向量反序列化
     *
     * @param codesVec 代码数据库实体
     *  simHash:xxx|winnowing:xxx
     */
    public CodesVector(CodesVec codesVec){
        String vector = codesVec.getVector();
        this.codeId = codeId;
        this.simHash = vector.split("|")[0].replaceAll("simHash:","");
        this.winnowing = vector.split("|")[1].replaceAll("winnowing","");
    }

}
