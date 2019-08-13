package com.training.ordermatching.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@Configuration
public class OrderThreadPoolsConfig {
    @Value("${order.threadNamePrefix}")
    private String threadNamePrefix;    // 配置线程池中的线程名称前缀

    @Value("${order.corePoolSize}")
    private Integer corePoolSize;       // 配置线程池中的核心线程数

    @Value("${order.maxPoolSize}")
    private Integer maxPoolSize;        // 配置最大线程数

    @Value("${order.queueCapacity}")
    private Integer queueCapacity;

    @Bean
    public AsyncTaskExecutor orderTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
