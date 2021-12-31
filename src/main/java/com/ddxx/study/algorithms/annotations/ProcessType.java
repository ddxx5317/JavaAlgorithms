package com.ddxx.study.algorithms.annotations;

import com.ddxx.study.algorithms.enums.ProcessTypeEnum;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ProcessType {
    ProcessTypeEnum type() default ProcessTypeEnum.QUERY;
}