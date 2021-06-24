package com.test.controller.plugin;

import com.test.controller.other.ObjectParam;

/*
 * @author ZZQ
 * @Date 2021/6/15 4:32 下午
 */
//@Component
public class BPluginImpl implements Myplugn{
    @Override
    public boolean supports(ObjectParam objectParam) {
        return objectParam.getUsername().equals("B");
    }

    @Override
    public void run() {
        System.out.println("A插件");
    }
}
