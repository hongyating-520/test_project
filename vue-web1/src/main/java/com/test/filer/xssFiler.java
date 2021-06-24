package com.test.filer;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
 * @author ZZQ
 * @Date 2021/6/17 10:52 上午
 */
@Component
public class xssFiler implements Filter {
    @Override

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入过滤器");
        System.out.println(chain);
        HttpServletRequest request1 = (HttpServletRequest) request;
        System.out.println(request1.getRequestURI());
        xssHttpWapper wapper = new xssHttpWapper(request1);
        chain.doFilter(wapper,response);
    }
}
