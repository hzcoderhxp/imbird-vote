package com.stone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class Application {
    private static Logger logger= LoggerFactory.getLogger(Application.class);
    private static File lockFile=null;
    public static void main(String[] args) {
        //test
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setRegisterShutdownHook(true);
        
        springApplication.addListeners((ApplicationListener<ApplicationReadyEvent>) event -> {
            logger.warn("imbird-vote Context Started!");
            ConfigurableApplicationContext context =event.getApplicationContext();
            String homePath=context.getEnvironment().getProperty("env.home.path");
            lockFile=new File(homePath+"/vote-lock");
            try {
                if(!lockFile.exists())
                    lockFile.createNewFile();
            } catch (IOException e) {
                logger.error(e.getMessage(),e);
            }
        });


        ConfigurableApplicationContext appContext = springApplication.run(args);


        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            while(appContext.isActive())
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(),e);
                }
            if(lockFile.exists())
                lockFile.delete();
            logger.warn("imbird-vote Context Closed!");
        }));
    }


}
