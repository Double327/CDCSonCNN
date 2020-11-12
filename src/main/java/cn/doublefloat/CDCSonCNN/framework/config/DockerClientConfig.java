package cn.doublefloat.CDCSonCNN.framework.config;

import cn.doublefloat.CDCSonCNN.common.exception.CustomException;
import cn.doublefloat.CDCSonCNN.projects.docker.domain.DockerClientDTO;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.DockerCmdExecFactory;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.jaxrs.JerseyDockerCmdExecFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;

/**
 * @author 李广帅
 * @date 2020/10/30 3:43 下午
 */
@Component
public class DockerClientConfig {


    /**
     * docker服务器地址
     */
    @Value("${docker.url}")
    private String dockerUrl;

    public static DockerClient getDockerClient(DockerClientDTO dockerClientDTO) {
        // 进行安全认证
        com.github.dockerjava.core.DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                // 服务器ip
                .withDockerHost("tcp://" + dockerClientDTO.getHost() + ":" + dockerClientDTO.getPort())
                .withDockerTlsVerify(true)
                // 证书的本地位置
                .withDockerCertPath(dockerClientDTO.getCertAndKeyFilePath())
                // 私钥的本地位置
                //.withDockerConfig(dockerClientDTO.getCertAndKeyFilePath())
                // API版本 可通过在服务器 docker version 命令查看
                .withApiVersion("1.31")
                // 默认
                .withRegistryUrl("https://index.docker.io/v1/")
                // 默认
                .withRegistryUsername(dockerClientDTO.getRegistryUsername())
                // 默认
                .withRegistryPassword(dockerClientDTO.getRegistryPassword())
                // 默认
                .withRegistryEmail(dockerClientDTO.getRegistryEmail())
                .build();

        // docker命令执行工厂
        DockerCmdExecFactory dockerCmdExecFactory = new JerseyDockerCmdExecFactory()
                .withReadTimeout(60000)
                .withConnectTimeout(60000)
                .withMaxTotalConnections(100)
                .withMaxPerRouteConnections(10);

        return DockerClientBuilder.getInstance(config).withDockerCmdExecFactory(dockerCmdExecFactory).build();
    }
}
