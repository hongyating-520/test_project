package com.test.controller;

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
@RequestMapping("/vue")
public class TestController {

    @Resource
    TestDemo testDemo;

    @RequestMapping("/ha")
    public String gethh(String username,String password){
        System.out.println(username+"-"+password);
        testDemo.testHa();
        return username;
    }
}
