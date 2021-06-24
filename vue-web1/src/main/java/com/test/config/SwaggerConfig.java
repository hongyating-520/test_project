package com.test.config;

import com.google.common.base.Predicate;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.function.Function;

/*
 * @author ZZQ
 * @Date 2021/6/13 11:35 下午
 */
//@Configuration
//@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApiSystem() {
        return new Docket(DocumentationType.SWAGGER_2)
                /* 设置拦截验证：如果有如配置所有请求header中需要添加token，配置全局响应码
                 全局参数(如header中的token)
              private List<Parameter> parameter() {
                   List<Parameter> params = new ArrayList<>();
                   params.add(new ParameterBuilder().name("token")
                           .description("请求令牌")
                           .modelRef(new ModelRef("string"))
                           .parameterType("header")
                           .required(false).build());
                   return params;
               }*/
                //.globalOperationParameters(PARAMETERS)
                //动态设置是否开启
                //.enable(swagger2Enable)
                //分组设置
                .groupName("group001")
                .enable(true)
                .useDefaultResponseMessages(false)
                //设置文档说明信息
                .apiInfo(apiInfo("彩连科技系统设置接口api文档"))
                .select()
                //包扫描路径RequestHandlerSelectors.basePackage("com.test.controller")
//                .apis(RequestHandlerSelectors.basePackage("com.test.controller"))
                //怕断类上是否含有注解生成文档
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //如果需要设置自定义注解表示不需要生成接口文档的注解
                //.apis(not(withMethodAnnotation(NotIncludeSwagger.class)))
                //设置拦截需要生成文档的url：规则满足AntPathMatcherurl规则
                .paths(PathSelectors.any()).build();
    }
    private ApiInfo apiInfo(String title) {
        return new ApiInfoBuilder()
                //文档标题
                .title(title)
                //文档描述
                .description("为彩连科技前端开发、移动端开发人员提供的接口文档").termsOfServiceUrl("www.clkj-stewards.com")
                //文档版本
                .version("1.0").contact(new Contact("clkj管理员", "www.clkj.com", "server@clkj.com")).build();
    }
    private Predicate<String> allowPaths(){
        Predicate<String> regex = PathSelectors.regex("/*");
        return regex;
    }

}
