package com.minlab.todolist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**")                  // WebMvcConfigurer 를 상속받은 WebConfig Configuration 파일을 만들고, 서버의 모든 API (.addMapping("/**"))
                .allowedOrigins("http://todo.ap-northeast-2.elasticbeanstalk.com/:5000", "http://localhost:8080", "http://localhost:3000")      // 프론트가 접속할 수 있게 3000 설정
                .allowCredentials(true);
    }
}
