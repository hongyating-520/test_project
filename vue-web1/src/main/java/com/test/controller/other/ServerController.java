package com.test.controller.other;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author ZZQ
 * @Date 2021/6/17 4:27 下午
 */
@RestController
@RequestMapping("/api")
public class ServerController {

    @RequestMapping("/server")
    public String server(@RequestBody ObjectParam param){
        System.out.println("server:"+param.toString());
        return "server sucess";
    }

}
