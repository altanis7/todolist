package com.minlab.todolist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**")                  // WebMvcConfigurer 를 상속받은 WebConfig Configuration 파일을 만들고, 서버의 모든 API (.addMapping("/**"))
                .allowedOrigins("http://todo.ap-northeast-2.elasticbeanstalk.com/:5000", "http://localhost:8080")      //를 localhost:8001 에서 접속할 수 있도록 설정 (.allowedOrigins("http://localhost:8080"))
                .allowCredentials(true);
    }
}
