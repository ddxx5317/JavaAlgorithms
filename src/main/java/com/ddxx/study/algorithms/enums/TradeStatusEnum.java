package com.ddxx.study.algorithms.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交易状态
 */
public enum TradeStatusEnum {
    WAITING(0,"未支付"), PAYING(1,"支付中"), PAYED(2,"已支付"),;

    private Integer code;

    private String description;

    private TradeStatusEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Map<String, TradeStatusEnum> toMap() {
        TradeStatusEnum[] ary = TradeStatusEnum.values();
        Map<String, TradeStatusEnum> enumMap = new HashMap<>();
        for (int num = 0; num < ary.length; num++) {
            String key = ary[num].name();
            enumMap.put(key, ary[num]);
        }

        return enumMap;
    }

    public static List<TradeStatusEnum> toList() {
        TradeStatusEnum[] ary = TradeStatusEnum.values();

        return Arrays.asList(ary);
    }

    public static TradeStatusEnum getEnumByName(String name) {
        if (StringUtils.isBlank(name)) return null;

        return toMap().get(name);
    }


    public static TradeStatusEnum getEnumByCode(Integer code) {
        if (null == code) return null;

        for (TradeStatusEnum tradeStatus : TradeStatusEnum.values()) {
            if (tradeStatus.getCode().equals(code)) {
                return tradeStatus;
            }
        }

        return null;
    }

    /**
     * 取枚举的json字符串
     *
     * @return
     */
    public static String getJsonStr() {
        TradeStatusEnum[] enums = TradeStatusEnum.values();
        StringBuffer jsonStr = new StringBuffer("[");
        for (TradeStatusEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{name:'").append(senum.name()).append("code:'").append(senum.getCode()).append("',description:'").append(senum.getDescription()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }
}
