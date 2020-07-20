package com.ddxx.study.algorithms.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 逻辑删除枚举
 */
public enum LogicDelete {
    /*
     * 1.废弃，0.有效
     */
    DELETED(1, "删除"), NORMAL(0, "正常");


    private Integer code;

    private String description;

    private LogicDelete(Integer code, String description) {
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

    public static Map<String, LogicDelete> toMap() {
        LogicDelete[] ary = LogicDelete.values();
        Map<String, LogicDelete> enumMap = new HashMap<>();
        for (int num = 0; num < ary.length; num++) {
            String key = ary[num].name();
            enumMap.put(key, ary[num]);
        }

        return enumMap;
    }

    public static List<LogicDelete> toList() {
        LogicDelete[] ary = LogicDelete.values();

        return Arrays.asList(ary);
    }

    public static LogicDelete getEnumByName(String name) {
        if (StringUtils.isBlank(name)) return null;

        return toMap().get(name);
    }


    public static LogicDelete getEnumByCode(Integer code) {
        if (null == code) return null;

        for (LogicDelete logicDelete : LogicDelete.values()) {
            if (logicDelete.getCode().equals(code)) {
                return logicDelete;
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
        LogicDelete[] enums = LogicDelete.values();
        StringBuffer jsonStr = new StringBuffer("[");
        for (LogicDelete senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{name:'").append(senum.name()).append("code:'").append(senum.getCode()).append("',description:'").append(senum.getDescription()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }
}

