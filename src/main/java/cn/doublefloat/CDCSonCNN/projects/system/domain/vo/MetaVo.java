package cn.doublefloat.CDCSonCNN.projects.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 李广帅
 * @date 2020/11/11 7:03 下午
 */
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class MetaVo implements Serializable {

    /**
     * 路由标题
     */
    private String title;

    /**
     * 菜单图标
     */
    private String icon;
}
