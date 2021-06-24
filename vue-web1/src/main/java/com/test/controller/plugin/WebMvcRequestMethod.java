package com.test.controller.plugin;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import java.util.List;

/*
 * @author ZZQ
 * @Date 2021/6/16 11:52 上午
 */
@Component
public class WebMvcRequestMethod {
    private  List<RequestMappingInfoHandlerMapping> handlerMappings;

    private Myplugn myplugn;

    //定义含参构造方法时，参数有spring 容器管理注入对应bean
    public WebMvcRequestMethod(List<RequestMappingInfoHandlerMapping> handlerMappings) {
        System.out.println("handlerMappings");
        this.handlerMappings = handlerMappings;
    }
}
