package com.test.controller.plugin;


import com.test.controller.other.ObjectParam;
import org.springframework.plugin.core.Plugin;

/*
 * @author ZZQ
 * @Date 2021/6/15 4:31 下午
 */
public interface Myplugn extends Plugin<ObjectParam> {

    void run();
}
