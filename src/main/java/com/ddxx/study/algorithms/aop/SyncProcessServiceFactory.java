package com.ddxx.study.algorithms.aop;

import com.ddxx.study.algorithms.annotations.ProcessType;
import com.ddxx.study.algorithms.enums.ProcessTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service("syncProcessServiceFactory")
@Slf4j
public class SyncProcessServiceFactory implements ApplicationContextAware {
    private ApplicationContext appCtx;

    private static Map<ProcessTypeEnum, Object> SERVICE_MAP = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appCtx = applicationContext;

        //注册服务
        registerService();
    }

    /**
     * 注册服务接口
     */
    /**
     * 注册服务接口
     */
    private void registerService() {
        final Map<String, Object> annotationTypes = appCtx.getBeansWithAnnotation(ProcessType.class);
        for (Object bean : annotationTypes.values()) {
            final Class<?> clazz = bean.getClass();
            if (clazz == null){
                continue;
            }
            final ProcessType processType = clazz.getAnnotation(ProcessType.class);
            if (processType == null){
                continue;
            }
            final ProcessTypeEnum serviceName = processType.type();
            if (serviceName != null){
                SERVICE_MAP.putIfAbsent(serviceName, bean);
                log.debug("register annotation service, serviceName={},bean={}", serviceName, bean);
            }
        }
    }

    /**
     * 获取服务名称
     * @param processType
     * @return
     */
    public static Object getInstance(final ProcessTypeEnum processType) {
        if (processType != null) {
            return SERVICE_MAP.get(processType);
        }
        return null;
    }
}
