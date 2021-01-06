package com.ddxx.study.algorithms.completableFutures;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2020/12/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CompletableFutureTest {

    @Before
    public void init() {
        System.out.println("开始测试----------------");
    }

    @After
    public void destory() {
        System.out.println("结束测试----------------");
    }

    @Test
    public void testWhenComplete() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            if(new Random().nextInt()%2>=0) {
                int i = 12/0;
            }
            System.out.println("run end ...");
        });

        future.whenComplete(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void t, Throwable action) {
                System.out.println("执行完成！");
            }

        });
        future.exceptionally(new Function<Throwable, Void>() {
            @Override
            public Void apply(Throwable t) {
                System.out.println("执行失败！"+t.getMessage());
                return null;
            }
        });
    }

    @Test
    public void test02() {
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApply(s -> {
            Assert.assertFalse(Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });
        Assert.assertEquals("MESSAGE", cf.getNow(null));
    }

    @Test
    public void test03() {
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture("thenAccept message")
                .thenAccept(s -> result.append(s));
        Assert.assertTrue("Result was empty", result.length() > 0);
    }

    @Test
    public void test04() {
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).runAfterBoth(
                CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
                () -> result.append("done"));
        System.out.println(result);
        Assert.assertTrue("Result was empty", result.length() > 0);
    }

    @Test
    public void test05() {
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).thenAcceptBoth(
                CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
                (s1, s2) -> result.append(s1 + s2));
        System.out.println(result);
        Assert.assertEquals("MESSAGEmessage", result.toString());
    }
}
