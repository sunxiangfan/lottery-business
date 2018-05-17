package com.lottery.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lottery.entity.Results;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * 用于JWT认证的过滤器
 */
public class JwtAuthorizeFilter implements Filter {

    @Value("${jwt.secret-key}")
    private String jwtSecretKey;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String auth = httpRequest.getHeader("Authorization");
        if ((auth != null) && (auth.length() > 7)) {
            String HeadStr = auth.substring(0, 6).toLowerCase();
            if (HeadStr.compareTo("bearer") == 0) {
                auth = auth.substring(7, auth.length());
                if (JwtHelper.parseJWT(auth, jwtSecretKey) != null) {
                    chain.doFilter(request, response);
                    return;
                }
            }
        }

        //验证不通过
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        //将验证不通过的错误返回
        ObjectMapper mapper = new ObjectMapper();
        Results results = Results.fail("token不合法！");
        httpResponse.getWriter().write(mapper.writeValueAsString(results));
        return;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
    }

}  