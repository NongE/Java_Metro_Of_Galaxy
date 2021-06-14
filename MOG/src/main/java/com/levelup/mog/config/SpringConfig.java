package com.levelup.mog.config;

import com.levelup.mog.aop.TimeCalculation;
import com.levelup.mog.repository.MogRepository;
import com.levelup.mog.repository.MogSubwayInfoRepository;
import com.levelup.mog.repository.MogSubwayPeopleInfoRepository;
import com.levelup.mog.service.MogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MogRepository mogRepository;
    private final MogSubwayInfoRepository mogSubwayInfoRepository;
    private final MogSubwayPeopleInfoRepository mogSubwayPeopleInfoRepository;

    public SpringConfig(MogRepository mogRepository, MogSubwayInfoRepository mogSubwayInfoRepository, MogSubwayPeopleInfoRepository mogSubwayPeopleInfoRepository) {
        this.mogRepository = mogRepository;
        this.mogSubwayInfoRepository = mogSubwayInfoRepository;
        this.mogSubwayPeopleInfoRepository = mogSubwayPeopleInfoRepository;
    }

    @Bean
    public MogService mogService(){
        return new MogService(mogRepository, mogSubwayInfoRepository, mogSubwayPeopleInfoRepository);
    }

    @Bean
    public TimeCalculation timeCalculation(){
        return new TimeCalculation();
    }
}
