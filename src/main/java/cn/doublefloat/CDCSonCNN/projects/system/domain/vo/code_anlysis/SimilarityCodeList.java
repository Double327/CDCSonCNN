package cn.doublefloat.CDCSonCNN.projects.system.domain.vo.code_anlysis;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.HashMap;

/**
 * @author 魏荣轩
 * @date 2020/11/14 9:54
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimilarityCodeList {

    /**
     * 相似文件列表
     */
    private HashMap<String , Double> similarityCodesList = new HashMap<>();

    /**
     * 主文件
     */
    private String codeFile;

}
