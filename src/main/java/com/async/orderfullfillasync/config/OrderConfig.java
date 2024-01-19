package com.async.orderfullfillasync.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class OrderConfig {

    @Bean("asyncTaskExecutor")
    public Executor asyncTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        threadPoolTaskExecutor.setCorePoolSize(4); //its setting thread pool size means number of threads
        threadPoolTaskExecutor.setQueueCapacity(150);//this implies that a thread can hold max 150 tasks at a time
        threadPoolTaskExecutor.setMaxPoolSize(4);//if queue capacity crosses its limit (150), it will create new thread & max it can create 4 more threads
        threadPoolTaskExecutor.setThreadNamePrefix("AsyncExecutor-");

        return  threadPoolTaskExecutor;
    }

}
