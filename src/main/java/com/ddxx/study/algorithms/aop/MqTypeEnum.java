

package com.ddxx.study.algorithms.aop;

public enum MqTypeEnum {
    OFC_INIT(100, "ofc初始订单消息"),
    ORDER_CANCEL(200, "订单取消消息"),
    ORDER_INTERCEPTION(300, "订单拦截消息"),
    ORDER_PACK(400, "订单打包"),
    ORDER_UPDATE(500, "订单修改"),
    COMMUNITY_ORDER(600, "社区拼团订单"),
    ORDER_MIDDLE_STAGE(700, "订单中台"),
    POP_DELIVERY(800, "POP发货消息"),
    POP_V20_DELIVERY(900, "POP发货消息"),
    WAYBILL_ORDER_MODIFY(1000, "修改配送时间或备注"),
    ORDER_PAY_POST(1100, "订单预授权"),
    PIGEON_SMS(1200, "短信绑定隐号"),
    BDPM_APPROVE(2000, "任务系统审批结果");

    private Integer key;
    private String value;

    private MqTypeEnum(Integer key, String value) {
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
