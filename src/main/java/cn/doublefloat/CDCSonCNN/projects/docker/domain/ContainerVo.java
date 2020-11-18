package cn.doublefloat.CDCSonCNN.projects.docker.domain;

import lombok.Data;

/**
 * @author 李广帅
 * @date 2020/11/15 下午2:36
 */
@Data
public class ContainerVo {

    /**
     * 容器ID
     */
    private String id;

    /**
     * 容器名称
     */
    private String name;

    /**
     * 镜像名称
     */
    private String imageName;

    /**
     * 容器端口
     */
    private Integer innerPort;

    /**
     * 外部访问端口
     */
    private Integer publicPort;

    /**
     * 服务器IP
     */
    private String hostIp;

    /**
     * 访问路径
     */
    private String accessUrl;

    /**
     * CPU权重
     */
    private Integer cpuShare;

    /**
     * 内存限额
     */
    private Long memoryLimit;

    public String getAccessUrl() {
        return hostIp + ":" + publicPort + "/" + name;
    }
}
