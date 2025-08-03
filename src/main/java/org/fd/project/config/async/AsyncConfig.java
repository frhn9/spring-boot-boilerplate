package org.fd.project.config.async;

import lombok.RequiredArgsConstructor;
import org.fd.project.config.properties.ApplicationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@EnableAsync
@Configuration
@RequiredArgsConstructor
public class AsyncConfig {

    private final ApplicationProperties applicationProperties;

    @Bean
    public TaskExecutor processExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("process-thread-");
        executor.initialize();

        return executor;
    }

    @Bean
    public TaskExecutor integrationExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("integration-thread-");
        executor.initialize();

        return executor;
    }

    @Bean
    public TaskExecutor virtualThreadExecutor() {
        ThreadFactory virtualThreadFactory = Thread.ofVirtual().name("virtual-thread-", 0).factory();
        return new TaskExecutorAdapter(Executors.newThreadPerTaskExecutor(virtualThreadFactory));
    }

}