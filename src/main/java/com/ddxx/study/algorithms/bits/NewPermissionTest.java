package com.ddxx.study.algorithms.bits;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2021/1/6
 * https://www.cnblogs.com/hihtml5/p/6483783.html
 */
public class NewPermissionTest {
    public static void main(String[] args) {
        final NewPermission permission= new NewPermission();

        //添加查询核插入权限
        permission.setPermission(NewPermission.ALLOW_SELECT | NewPermission.ALLOW_INSERT);

        //当前存储值
        final int flag = permission.getFlag();
        System.out.println(flag);


        //判断仅仅是否有查询和插入权限
        if (permission.isOnlyAllow(NewPermission.ALLOW_SELECT | NewPermission.ALLOW_INSERT)){
            System.out.println("ok");
        }

        //判断是否有插入权限
        if (permission.isAllow(NewPermission.ALLOW_INSERT)){
            System.out.println("ok");
        }
    }
}
