package cn.doublefloat.CDCSonCNN.projects.docker.service;

import cn.doublefloat.CDCSonCNN.projects.docker.domain.ContainerVo;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.Info;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/13 1:19 下午
 */
public interface DockerService {

    /**
     * 获取Docker客户端信息
     *
     * @return 客户端信息
     */
    public Info getClientInfo();

    /**
     * 获取镜像列表
     *
     * @return 镜像列表
     */
    public List<Image> getImagesList();

    /**
     * 创建容器
     *
     * @param tomcatVersion 镜像名
     * @param cpuShares     CPU权重
     * @param memory        内存空间
     * @return 相应信息
     */
    CreateContainerResponse createTomcatContainer(String tomcatVersion, int cpuShares, long memory);

    /**
     * 推送war包到Tomcat容器
     *
     * @param containerId 容器ID
     * @param appRootPath war包路径
     * @return 结果
     */
    int pushWarToTomcat(String containerId, String appRootPath);

    /**
     * 获取项目访问路径
     *
     * @param containerId 容器ID
     * @return 路径
     */
    String getAppAccessUrl(String containerId);

    /**
     * 删除容器
     *
     * @param containerId 容器ID
     * @return 结果
     */
    int removeContainer(String containerId);

    /**
     * 启动容器
     *
     * @param containerId 容器ID
     * @return 结果
     */
    int startContainer(String containerId);

    /**
     * 暂停容器
     *
     * @param containerId 容器ID
     * @return 结果
     */
    int pauseContainer(String containerId);

    /**
     * 停止容器运行
     *
     * @param containerId 容器ID
     * @return 结果
     */
    int stopContainer(String containerId);

    /**
     * 停止容器
     *
     * @param containerId 容器ID
     * @return 结果
     */
    int killContainer(String containerId);

    /**
     * 获取容器信息
     *
     * @param containerId 容器ID
     * @return 容器信息
     */
    ContainerVo getContainerInfo(String containerId);


}
