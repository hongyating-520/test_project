//package com.test.secrity;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.SecurityBuilder;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
//import org.springframework.security.web.authentication.logout.LogoutHandler;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///*
// * @author ZZQ
// * @Date 2021/6/22 12:47 下午
// */
////@Configuration
////@EnableWebSecurity
//public class mySecrity extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        JwtAccessDeniedHandler jwtAccessDeniedHandler = new JwtAccessDeniedHandler();
//        http
//       //配置拦截路径
//        .authorizeRequests()
//        //登入不拦截，跨域不拦截
//        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//        .antMatchers("/login").permitAll()
//        .anyRequest().authenticated()
//        //配置csrf
//        .and().csrf().disable().exceptionHandling().authenticationEntryPoint(jwtAccessDeniedHandler).accessDeniedHandler(jwtAccessDeniedHandler)
//       .and().formLogin().loginProcessingUrl("/login");
//
//
//    }
//}
//
