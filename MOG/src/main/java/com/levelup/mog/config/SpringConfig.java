package com.levelup.mog.config;

import com.levelup.mog.aop.TimeCalculation;
import com.levelup.mog.repository.MogPredictSubwayUserRepository;
import com.levelup.mog.repository.MogRepository;
import com.levelup.mog.repository.MogSubwayInfoRepository;
import com.levelup.mog.service.MogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MogRepository mogRepository;
    private final MogSubwayInfoRepository mogSubwayInfoRepository;
    private final MogPredictSubwayUserRepository mogPredictSubwayUserRepository;
    // private final MogSubwayPeopleInfoRepository mogSubwayPeopleInfoRepository;
    private final SetProperty setProperty;

    public SpringConfig(MogRepository mogRepository, MogSubwayInfoRepository mogSubwayInfoRepository, MogPredictSubwayUserRepository mogPredictSubwayUserRepository, SetProperty setProperty) {
        this.mogRepository = mogRepository;
        this.mogSubwayInfoRepository = mogSubwayInfoRepository;
        this.mogPredictSubwayUserRepository = mogPredictSubwayUserRepository;
        this.setProperty = setProperty;
    }

    @Bean
    public MogService mogService(){
        return new MogService(mogRepository, mogSubwayInfoRepository, mogPredictSubwayUserRepository, setProperty);
    }

    @Bean
    public TimeCalculation timeCalculation(){
        return new TimeCalculation();
    }
}
