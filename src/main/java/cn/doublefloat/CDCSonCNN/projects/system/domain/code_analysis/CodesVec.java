package cn.doublefloat.CDCSonCNN.projects.system.domain.code_analysis;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.Date;

/**
 * @author 魏荣轩
 * @date 2020/11/12 23:31
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CodesVec {

    public CodesVec(String id, String vector, Date updateTime){
        this.id = id;
        this.updateTime = updateTime;
        this.vector = vector;
    }
    /**
     * 代码文件名
     */
    private String id;

    /**
     * 代码向量
     */
    private String vector;

    /**
     * 更新日期
     */
    private Date updateTime;
}
