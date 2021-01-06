package com.ddxx.study.algorithms.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum PermissionEnum {
    ALLOW_SELECT(1 << 0, "查询"),// 0001=1
    ALLOW_INSERT(1 << 1, "新增"),// 0010=2
    ALLOW_UPDATE(1 << 2, "修改"),// 0100=4
    ALLOW_DELETE(1 << 3, "删除");// 1000=8

    private Integer code;

    private String description;

    PermissionEnum(Integer code, String description) {
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

    public static Map<String, PermissionEnum> toMap() {
        PermissionEnum[] ary = PermissionEnum.values();
        Map<String, PermissionEnum> enumMap = new HashMap<>();
        for (int num = 0; num < ary.length; num++) {
            String key = ary[num].name();
            enumMap.put(key, ary[num]);
        }

        return enumMap;
    }

    public static List<PermissionEnum> toList() {
        PermissionEnum[] ary = PermissionEnum.values();

        return Arrays.asList(ary);
    }

    public static PermissionEnum getEnumByName(String name) {
        if (StringUtils.isBlank(name)) return null;

        return toMap().get(name);
    }

    public static PermissionEnum getEnumByCode(Integer code) {
        if (null == code) return null;

        for (PermissionEnum logicDelete : PermissionEnum.values()) {
            if (logicDelete.getCode().equals(code)) {
                return logicDelete;
            }
        }
        return null;
    }
}

