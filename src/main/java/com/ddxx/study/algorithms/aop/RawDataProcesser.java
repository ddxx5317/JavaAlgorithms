package com.ddxx.study.algorithms.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 用于原始数据处理
 *
 * @author cheng.chen@dmall.com
 */
@EnableAspectJAutoProxy
@Aspect
@Component
@Slf4j
public class RawDataProcesser {

    @Around(value = "@annotation(rawDataProcess)")
    public Object rawDataProcesser(ProceedingJoinPoint pjp, RawDataProcess rawDataProcess) throws Throwable {
        Object result = null;
        // 请求参数
        Object[] args = pjp.getArgs();
        log.info(JSON.toJSONString(args));
        // mqType
        MqTypeEnum mqTypeEnum = rawDataProcess.mqTypeEnum();
        log.info(JSON.toJSONString(mqTypeEnum));
        return pjp.proceed();
    }

}
