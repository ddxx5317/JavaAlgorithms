package com.ddxx.study.algorithms.annotations;

import com.ddxx.study.algorithms.enums.MqTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 原始数据处理注解
 *
 * @author cheng.chen@dmall.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RawDataProcess {

    MqTypeEnum mqTypeEnum() default MqTypeEnum.INIT;
}
