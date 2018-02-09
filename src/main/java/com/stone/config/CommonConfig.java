package com.stone.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by chenghao on 1/10/17.
 */

@Configuration
public class CommonConfig {
    @Value("${server.inner.port}")
    private Integer port;

    @Bean
    public EmbeddedServletContainerFactory embeddedServletContainerFactory(){
        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
        factory.addBuilderCustomizers(builder -> builder.addHttpListener(port,"0.0.0.0"));
        return factory;
    }


}
