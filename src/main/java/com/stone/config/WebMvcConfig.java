package com.stone.config;

import com.stone.filter.LoggingFilter;
import com.stone.interceptor.ExecuteTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by john on 16-7-6.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private static final String characterEncoding = "UTF-8";

    @Autowired
    private ApplicationContext applicationContext;


    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding(characterEncoding);
        return messageSource;
    }
    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setValidationMessageSource(messageSource());
        return factoryBean;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(new CustomJacksonMessageConverter());
    }




    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(applicationContext.getBean(ExecuteTimeInterceptor.class)).addPathPatterns("/**");
    }

/*    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static*//**").addResourceLocations("classpath:/static/");
    }*/



    @Bean
    public FilterRegistrationBean encodeFilterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter =new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        registration.setFilter(characterEncodingFilter);
        registration.addUrlPatterns("/*");
        registration.setName("encodeFilter");
        registration.setOrder(2);
        return registration;
    }


    @Bean
    public FilterRegistrationBean loggingFilterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        LoggingFilter loggingFilter =new LoggingFilter();
        registration.setFilter(loggingFilter);
        registration.addUrlPatterns("/*");
        registration.setName("loggingFilter");
        registration.setOrder(7);
        return registration;
    }

    @Bean  // Magic entry
    public DispatcherServlet dispatcherServlet() {
        DispatcherServlet ds = new DispatcherServlet();
        ds.setThrowExceptionIfNoHandlerFound(true);
        return ds;
    }
}
