package com.ynu.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@WebAppConfiguration
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.ynu.controller"))
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("CSI项目接口文档")
//                .description("CSI项目接口测试")
//                .version("1.0.0")
//                .termsOfServiceUrl("")
//                .license("")
//                .licenseUrl("")
//                .build();
//    }
    @Bean
    public Docket api() {
//        ParameterBuilder ticketPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<Parameter>();
//        ticketPar.name("token").description("token")
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).build();
//        pars.add(ticketPar.build());


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.ynu.controller"))
                .paths(PathSelectors.any())
                .build();
//                .globalOperationParameters(pars);//配置头部行
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CSI员工之家")
                .description("CSI员工之家接口文档\r\n 小组成员：宋晨明、翁恺敏、孔飞、刘竹风、王正正、王雷翔、张骏哲、李鑫\r\n 指导老师：辛宝和")
                //服务条款网址
                .version("1.0")
                .contact(new Contact("SongChenming", "https://github.com/cmFighting", "1148392984@qq.com"))
                .build();
    }
}
