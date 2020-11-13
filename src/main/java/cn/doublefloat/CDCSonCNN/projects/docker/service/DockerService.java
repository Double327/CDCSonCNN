package cn.doublefloat.CDCSonCNN.projects.docker.service;

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

    public List<Image> getImagesList();

    int pauseContainer(String containerId);

    int stopContainer(String containerId);

    int killContainer(String containerId);


}
