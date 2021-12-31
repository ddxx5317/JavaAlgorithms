package com.ddxx.study.algorithms.service;


import com.ddxx.study.algorithms.annotations.ProcessType;
import com.ddxx.study.algorithms.enums.ProcessTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@ProcessType(type = ProcessTypeEnum.INSERT)
@Service
@Slf4j
public class BProcessor implements IProcessor {
    @Override
    public String doTest() {
        return "BProcessor Result";
    }
}
