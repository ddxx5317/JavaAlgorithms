package com.ddxx.study.algorithms;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;;

public class ReadFile {
    public static String readfile(String filepath) {
        JSONObject jsonObject = new JSONObject(true);
        try {
            File file = new File(filepath);
            if (file.isDirectory()) {
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        String path = readfile.getPath();
                        String fullName = path.substring(path.indexOf("\\java\\") + 6, path.lastIndexOf(".")).replace("\\", ".");
                        Class<?> clazz = Class.forName(fullName);
                        Object[] objects = clazz.getEnumConstants();
                        Method getCodeMethod = getInvokeMethod(clazz, Arrays.asList("getCode","getKey"),0);
                        Method getMsgMethod = getInvokeMethod(clazz, Arrays.asList("getValuex","getXxxx","getDescriptionx"),0);

                        if (getCodeMethod == null || getMsgMethod == null){
                            System.out.println("无效枚举:"+clazz.getName());
                            continue;
                        }
                        String fileName = clazz.getName();
                        for (Object obj : objects) {
                            jsonObject.put(fileName.substring(fileName.lastIndexOf(".")+1)+"_"+getCodeMethod.invoke(obj).toString(),getMsgMethod.invoke(obj));
                        }

                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return jsonObject.toJSONString();
    }

    private static Method getInvokeMethod(Class<?> clazz, List<String> methodNames,int index) {
        Method invokeMethod = null;
        try {
            invokeMethod = clazz.getMethod(methodNames.get(index));
        }catch (Exception e){
            if(e instanceof  NoSuchMethodException) {
                invokeMethod = getInvokeMethod(clazz,methodNames,++index);
            }
        }
        return invokeMethod;
    }

    public static void main(String[] args) {
        String result = readfile("D:\\IdeaProjects\\JavaAlgorithms\\src\\main\\java\\com\\ddxx\\study\\algorithms\\enums");
        System.out.println(result);
    }
}