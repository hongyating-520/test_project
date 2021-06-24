package com.test.controller.other;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.SmartLifecycle;

/*
 * @author ZZQ
 * @Date 2021/6/14 1:56 下午
 */
@ApiModel(value = "apimodel",  description = "apimodel描述说明")
public class ObjectParam implements SmartLifecycle {

    @ApiModelProperty(value = "客户名")
    private String  username;
    @ApiModelProperty(value = "passwor")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void start() {
        System.out.println("start liftcycle");
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public String toString() {
        return "ObjectParam{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
