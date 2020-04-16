package com.ddxx.study.algorithms.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 是否二次分账标识
 */
public enum SecondSplitFlagEnum {
    NO(0, "非二次分账"), YES(1,"是二次分账");

    private Integer code;

    private String value;

    private SecondSplitFlagEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Map<String, SecondSplitFlagEnum> toMap() {
        SecondSplitFlagEnum[] ary = SecondSplitFlagEnum.values();
        Map<String, SecondSplitFlagEnum> enumMap = new HashMap<>();
        for (int num = 0; num < ary.length; num++) {
            String key = ary[num].name();
            enumMap.put(key, ary[num]);
        }

        return enumMap;
    }

    public static List<SecondSplitFlagEnum> toList() {
        SecondSplitFlagEnum[] ary = SecondSplitFlagEnum.values();

        return Arrays.asList(ary);
    }

    public static SecondSplitFlagEnum getEnumByName(String name) {
        if (StringUtils.isBlank(name)) return null;

        return toMap().get(name);
    }


    public static SecondSplitFlagEnum getEnumByCode(Integer code) {
        if (null == code) return null;

        for (SecondSplitFlagEnum secondSplitFlagEnum : SecondSplitFlagEnum.values()) {
            if (secondSplitFlagEnum.getCode().equals(code)) {
                return secondSplitFlagEnum;
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
        SecondSplitFlagEnum[] enums = SecondSplitFlagEnum.values();
        StringBuffer jsonStr = new StringBuffer("[");
        for (SecondSplitFlagEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{name:'").append(senum.name()).append("code:'").append(senum.getCode()).append("',description:'").append(senum.getValue()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }
}
