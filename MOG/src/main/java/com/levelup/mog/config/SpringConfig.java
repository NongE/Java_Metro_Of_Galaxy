package com.levelup.mog.config;

import com.levelup.mog.repository.MogRepository;
import com.levelup.mog.service.MogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MogRepository mogRepository;

    public SpringConfig(MogRepository mogRepository) {
        this.mogRepository = mogRepository;
    }

    @Bean
    public MogService mogService(){
        return new MogService(mogRepository);
    }
}
