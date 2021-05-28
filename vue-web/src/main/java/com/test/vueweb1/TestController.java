package com.test.vueweb1;

import com.test.server.TestDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author:zzq
 * @Date:2021/5/28-05-28
 */

@RestController
@RequestMapping("/")
public class TestController {

    @Resource
    TestDemo testDemo;

    @RequestMapping("/ha")
    public String gethh(String code){
        System.out.println(code);
        testDemo.testHa();
        return code;
    }
}
