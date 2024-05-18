package com.swimmingliu.springboottlias.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.swimmingliu.springboottlias.pojo.Result;
import com.swimmingliu.springboottlias.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor{
    @Autowired
    private JwtUtils jwtUtils;
    @Override   // return true 放行 false 不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 2. 获取请求的URL
        String url = String.valueOf(request.getRequestURL());
        // 3. 判断 URL是否包含 login
        if (url.contains("login")){
            // 放行 login请求
            log.info("放行 login请求");
            return true;
        }
        // 4. 判断是否包含token, 如果不符合条件就直接返回Result error
        String jwt = request.getHeader("token");
        if (!StringUtils.hasLength(jwt)){
            log.info("请求头token为空,返回未登录的信息");
            Result result = Result.error("NOT_LOGIN");
            // 将Result对象转换为JSON
            String jsonString = JSONObject.toJSONString(result);
            // Resp写回JSON
            response.getWriter().write(jsonString);
            return false;
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
            response.getWriter().write(jsonString);
            return false;
        }
        // 6. 放行
        log.info("令牌合法, 直接放行");
        return true;
    }

    @Override // Controller 执行之后的操作
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override // 视图渲染完毕后运行, 最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
