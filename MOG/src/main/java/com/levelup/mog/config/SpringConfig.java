package com.levelup.mog.config;

import com.levelup.mog.aop.TimeCalculation;
import com.levelup.mog.repository.MogRepository;
import com.levelup.mog.repository.MogSubwayIntoRepository;
import com.levelup.mog.service.MogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MogRepository mogRepository;
    private final MogSubwayIntoRepository mogSubwayIntoRepository;

    public SpringConfig(MogRepository mogRepository, MogSubwayIntoRepository mogSubwayIntoRepository) {
        this.mogRepository = mogRepository;
        this.mogSubwayIntoRepository = mogSubwayIntoRepository;
    }

    @Bean
    public MogService mogService(){
        return new MogService(mogRepository, mogSubwayIntoRepository);
    }

    @Bean
    public TimeCalculation timeCalculation(){
        return new TimeCalculation();
    }
}
