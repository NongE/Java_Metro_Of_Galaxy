package com.levelup.seatro.config;

import com.levelup.seatro.repository.SubwayStationsRepository;
import com.levelup.seatro.service.SeatroService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SeatroConfig implements WebMvcConfigurer {

    // react 3000 포트 허용
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**")
                .allowedOrigins("http://localhost:3000");
    }

}
