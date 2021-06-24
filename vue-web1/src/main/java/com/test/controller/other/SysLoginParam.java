package com.test.controller.other;

import io.swagger.annotations.ApiModelProperty;

/*
 * @author ZZQ
 * @Date 2021/6/22 2:22 下午
 */
public class SysLoginParam {

    private String mobile;
    private String password;
    private Integer loginType;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }
}
