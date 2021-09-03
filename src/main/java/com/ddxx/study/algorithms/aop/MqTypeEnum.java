

package com.ddxx.study.algorithms.aop;

public enum MqTypeEnum {
    INIT(100, "初始订单消息");

    private Integer key;
    private String value;

    MqTypeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
