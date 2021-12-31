package com.ddxx.study.algorithms.bits;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2020/11/20
 */
public class TestDemo {
    public static void main(String[] args) {
        //Long base = 0x004000000L;
        Long base2 = 0b100000000000000000000000000L;
        System.out.println(base2);
        Long base = 0x004000000L;
        System.out.println(Long.toBinaryString(base));
        System.out.println(base);

        List<Long> relatedOrderIds1 = new ArrayList<>();
        relatedOrderIds1.add(28324382L);
        relatedOrderIds1.add(28324482L);

        buildParentOrderId(base,relatedOrderIds1);

        List<Long> relatedOrderIds2 = new ArrayList<>();
        relatedOrderIds2.add(28324382L);
        relatedOrderIds2.add(28324482L);
        buildParentOrderId(base,relatedOrderIds2);
    }
    private static void buildParentOrderId(final Long base,final List<Long> relatedOrderIds) {
        AtomicReference<Long> parentOrderId = new AtomicReference(base);
        relatedOrderIds.forEach(relatedOrderId ->{
            parentOrderId.updateAndGet(result -> result | relatedOrderId);
        });
        System.out.println(parentOrderId.get());
    }
}
