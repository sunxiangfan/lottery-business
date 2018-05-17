package com.lottery.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
  
  
/* 
 * 注册jwt认证过滤器 
 */  
@Configuration  
public class JwtConfig {  
      
    /* 
     * 注册过滤器类和过滤的url 
     */  
    @Bean  
    public FilterRegistrationBean basicFilterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();  
        JwtAuthorizeFilter filter = new JwtAuthorizeFilter();  
        registrationBean.setFilter(filter);  
          
        List<String> urlPatterns = new ArrayList<>();  
        urlPatterns.add("/test/*");
          
        registrationBean.setUrlPatterns(urlPatterns);  
        return registrationBean;  
    }  
}  
