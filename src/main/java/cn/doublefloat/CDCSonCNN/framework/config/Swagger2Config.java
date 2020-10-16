package cn.doublefloat.CDCSonCNN.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李广帅
 * @date 2020/7/19 10:52 下午
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket webApiConfig() {
        ParameterBuilder tokenParam = new ParameterBuilder();
        tokenParam.name("token").description("请求Token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(tokenParam.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(parameters)
                .apiInfo(webApiInfo());
    }


    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("课设项目管理系统API文档")
                .description("课设项目管理系统后台API文档")
                .version("1.0")
                .contact(new Contact("李广帅", "www.doublefloat.cn", "203814477@qq.com"))
                .build();
    }
}