package com.test.config;

import com.test.filer.xssHttpWapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import springfox.documentation.RequestHandler;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @author:zzq
 * @Date:2021/6/7-06-07
 */
@Component
public class MyIntercepter implements HandlerInterceptor {

    @Autowired
    RequestMappingHandlerMapping requestHandlers;
    private String[] whileUrl = new String[]{"/login","/error","/userlogin","/vue/ha"};
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());


        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestHandlers.getHandlerMethods();
        //        if (1==1){
//            return true;
//        }
//        String uri = request.getRequestURI();
//        System.out.println("preHandle:"+uri);
//        Cookie[] cookies = request.getCookies();
//        for (String s : whileUrl) {
//            if (s.equals(uri)){
//                return true;
//            }
//        }
//        if (cookies !=null){
//            for (Cookie cookie : cookies) {
//                String userinfo = cookie.getName();
//                if ("userinfo".equals(userinfo)){
//                    String value = cookie.getValue();
//                    System.out.println(value);
//                    return true;
//                }
//            }
//        }
//
//        String method = request.getMethod();
//
//        if ("post".equals(method)){
//            String subscribeJson = getSubscribeJson(request);
//        }else if ("get".equals(method)) {
//            Map<String, String[]> parameterMap = request.getParameterMap();
//        }
//        //request.getRequestDispatcher("/login?redirectURL="+uri).forward(request,response);
//        response.sendRedirect("/login?redirectURL="+uri);//条状当前域名下
//        //response.sendRedirect("http://139.129.240.162");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //在请求接口返回modelAndView，此处可以获取
        if (modelAndView==null){
            return;
        }
        System.out.println("_------------_--------_");
        modelAndView.addObject("vuefont","vuelogo2");
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
    public String getSubscribeJson(HttpServletRequest request) {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
