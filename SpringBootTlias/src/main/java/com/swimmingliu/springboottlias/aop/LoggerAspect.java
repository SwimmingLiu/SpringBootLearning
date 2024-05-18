package com.swimmingliu.springboottlias.aop;

import com.alibaba.fastjson.JSONObject;
import com.swimmingliu.springboottlias.mapper.OperateLogMapper;
import com.swimmingliu.springboottlias.pojo.OperateLog;
import com.swimmingliu.springboottlias.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.swimmingliu.springboottlias.anno.Logger)")
    public Object jointPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1. 第一步，获取操作人 ==> userid
        String token = request.getHeader("token");
        Claims claims = jwtUtils.parseJwtToken(token);
        Integer userId = (Integer) claims.get("id");
        // 2. 第二步，获取操作时间 ==> LocalDateTime
        LocalDateTime currentTime = LocalDateTime.now();
        // 3. 第三步，拿到类名和方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        // 4. 第四步，拿到方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        // 5. 放行，执行连接点方法，并计算耗时
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        //方法返回值
        String returnValue = JSONObject.toJSONString(result);

        long costTime = end - begin;
        // 6. 将OperateLog写入数据库
        OperateLog operateLog = new OperateLog(userId, currentTime, className, methodName,
                methodParams, returnValue, costTime);
        operateLogMapper.insertLog(operateLog);
        log.info("AOP记录操作日志: {}" , operateLog);
        return result;
    }
}
