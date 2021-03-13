package org.example;

import org.example.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(AppConfig.class,args);
    }
}
