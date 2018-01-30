package com.stone.config.event;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.stone.event.IListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Created by chenghao on 6/12/17.
 */

@Configuration
public class EventConfig {
    @Autowired
    private ApplicationContext applicationContext;
    private static ExecutorService executorService= Executors.newFixedThreadPool(16);
    @Bean
    public EventBus eventBus(){
        EventBus eventBus= new AsyncEventBus(executorService);
        Map<String,IListener> listenerMap=applicationContext.getBeansOfType(IListener.class);
        listenerMap.keySet().stream()
                .peek(item->eventBus.register(listenerMap.get(item)))
                .collect(Collectors.toList());
        return eventBus;
    }
}
