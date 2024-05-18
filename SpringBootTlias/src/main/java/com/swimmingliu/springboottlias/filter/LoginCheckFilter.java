package com.swimmingliu.springboottlias.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.swimmingliu.springboottlias.pojo.Result;
import com.swimmingliu.springboottlias.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Component
@Slf4j
public class LoginCheckFilter implements Filter {
    @Autowired
    private JwtUtils jwtUtils;
    @Override   // chain.doFilter() 放行
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1. 把Req、Resp 转换为HttpServlet
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        // 2. 获取请求的URL
        String url = String.valueOf(req.getRequestURL());
        // 3. 判断 URL是否包含 login
        if (url.contains("login")){
            // 放行 login请求
            log.info("放行 login请求");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        // 4. 判断是否包含token, 如果不符合条件就直接返回Result error
        String jwt = req.getHeader("token");
        if (!StringUtils.hasLength(jwt)){
            log.info("请求头token为空,返回未登录的信息");
            Result result = Result.error("NOT_LOGIN");
            // 将Result对象转换为JSON
            String jsonString = JSONObject.toJSONString(result);
            // Resp写回JSON
            resp.getWriter().write(jsonString);
            return;
        }
        // 5. 解析token, 如果解析失败就返回Result error
        try {
            jwtUtils.parseJwtToken(jwt);
        } catch (Exception e) {
            log.info("解析JwtToken失败");
            e.printStackTrace();
            Result result = Result.error("NOT_LOGIN");
            // 将Result对象转换为JSON
            String jsonString = JSONObject.toJSONString(result);
            // Resp写回JSON
            resp.getWriter().write(jsonString);
            return;
        }
        // 6. 放行
        log.info("令牌合法, 直接放行");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
