package cn.doublefloat.CDCSonCNN.projects.docker.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 李广帅
 * @date 2020/11/9 3:19 下午
 */
@Data
@Accessors(chain = true)
public class DockerClientDTO {
    /**
     * 私钥和证书文件路径
     */
    private String certAndKeyFilePath;
    /**
     * 主机ip
     */
    private String host;

    /**
     * 端口
     */
    private String port;

    /**
     * 注册用户名
     */
    private String registryUsername;

    /**
     * 注册密码
     */
    private String registryPassword;

    /**
     * 注册邮箱
     */
    private String registryEmail;

    public DockerClientDTO(String host, String port, String certAndKeyFilePath) {
        this.host = host;
        this.port = port;
        this.certAndKeyFilePath = certAndKeyFilePath;
    }
}
