//package com.test.secrity;
//
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///*
// * @author ZZQ
// * @Date 2021/6/22 2:15 下午
// */
//public class JwtAccessDeniedHandler implements AccessDeniedHandler, AuthenticationEntryPoint {
//    @Override
//    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
//        System.out.println("用户访问没有授权资源");
//        System.out.println(e.getMessage());
//        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e==null?"用户访问没有授权资源":e.getMessage());
//    }
//
//    @Override
//    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//        System.out.println("用户访问资源没有携带正确的token");
//        System.out.println(e.getMessage());
//        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e==null?"用户访问资源没有携带正确的token":e.getMessage());
//
//    }
//}
