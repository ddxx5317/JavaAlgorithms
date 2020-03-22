package com.ddxx.study.algorithms;

import com.ddxx.study.algorithms.events.MyListener;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AlgorithmsApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AlgorithmsApplication.class)

                // 设置当前应用类型
                .web(WebApplicationType.SERVLET)

                // 设置 banner 横幅打印方式、有关闭、日志、控制台
                .bannerMode(Banner.Mode.OFF)

                // 追加自定义的 initializer 到集合中
                //.initializers(new MyApplicationContextInitializer())

                // 追加自定义的 listeners 到集合中
                .listeners(new MyListener())
                .run(args);
    }
}
