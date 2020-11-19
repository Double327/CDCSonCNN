package cn.doublefloat.CDCSonCNN.projects.docker.service.impl;

import cn.doublefloat.CDCSonCNN.common.utils.StringUtils;
import cn.doublefloat.CDCSonCNN.projects.docker.domain.ContainerVo;
import cn.doublefloat.CDCSonCNN.projects.docker.service.DockerService;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李广帅
 * @date 2020/11/15 下午2:19
 */
@Service
public class DockerServiceImpl implements DockerService {

    @Autowired
    private DockerClient dockerClient;

    private Map<String, ContainerVo> containerMap = new HashMap<>();

    @Override
    public Info getClientInfo() {
        return dockerClient.infoCmd().exec();
    }

    @Override
    public List<Image> getImagesList() {
        return dockerClient.listImagesCmd().exec();
    }

    @Override
    public CreateContainerResponse createTomcatContainer(String tomcatVersion, int cpuShares, long memory) {
        return null;
    }

    @Override
    public int pushWarToTomcat(String containerId, String appRootPath) {
        dockerClient.copyArchiveToContainerCmd(containerId).withHostResource(appRootPath).withRemotePath("/usr/local/tomcat/webapps").exec();
        return 0;
    }

    @Override
    public String getAppAccessUrl(String containerId) {
        ContainerVo containerVo = containerMap.get(containerId);
        if (StringUtils.isNotNull(containerVo)) {
            return containerVo.getAccessUrl();
        }
        return null;
    }

    @Override
    public int removeContainer(String containerId) {
        dockerClient.removeContainerCmd(containerId).exec();
        return 0;
    }

    @Override
    public int startContainer(String containerId) {
        dockerClient.startContainerCmd(containerId).exec();
        return 0;
    }

    @Override
    public int pauseContainer(String containerId) {
        dockerClient.pauseContainerCmd(containerId).exec();
        return 0;
    }

    @Override
    public int stopContainer(String containerId) {
        dockerClient.stopContainerCmd(containerId).exec();
        return 0;
    }

    @Override
    public int killContainer(String containerId) {
        dockerClient.killContainerCmd(containerId).exec();
        return 0;
    }

    @Override
    public ContainerVo getContainerInfo(String containerId) {
        return containerMap.get(containerId);
    }

    private void refreshContainerMap() {
        List<Container> containerList = dockerClient.listContainersCmd().exec();
        for (Container container : containerList) {
            InspectContainerResponse containerResponse = dockerClient.inspectContainerCmd(container.getId()).exec();
            ContainerVo containerVo = new ContainerVo();
            containerVo.setId(containerResponse.getId());
            containerVo.setImageName(containerResponse.getImageId());
            containerVo.setCpuShare(containerResponse.getHostConfig().getCpuShares());
            containerVo.setMemoryLimit(containerResponse.getHostConfig().getMemory());
            containerMap.put(container.getId(), containerVo);
        }
    }
}
