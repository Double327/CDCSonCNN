package cn.doublefloat.CDCSonCNN.projects.system.domain.code_anlysis;

import lombok.Data;

import java.util.Date;

/**
 * @author 魏荣轩
 * @date 2020/11/12 23:31
 */
@Data
public class CodesVector {

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
    private Date update_time;
}
