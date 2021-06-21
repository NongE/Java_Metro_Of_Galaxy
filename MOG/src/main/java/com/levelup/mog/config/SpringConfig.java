package com.levelup.mog.config;

import com.levelup.mog.aop.TimeCalculation;
import com.levelup.mog.repository.PredictSubwayUserRepository;
import com.levelup.mog.repository.SubwayIdRepository;
import com.levelup.mog.repository.SubwayInfoRepository;
import com.levelup.mog.service.MogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final SubwayIdRepository subwayIdRepository;
    private final SubwayInfoRepository subwayInfoRepository;
    private final PredictSubwayUserRepository predictSubwayUserRepository;
    private final SetProperty setProperty;

    public SpringConfig(SubwayIdRepository subwayIdRepository, SubwayInfoRepository subwayInfoRepository, PredictSubwayUserRepository predictSubwayUserRepository, SetProperty setProperty) {
        this.subwayIdRepository = subwayIdRepository;
        this.subwayInfoRepository = subwayInfoRepository;
        this.predictSubwayUserRepository = predictSubwayUserRepository;
        this.setProperty = setProperty;
    }

    @Bean
    public MogService mogService(){
        return new MogService(subwayIdRepository, subwayInfoRepository, predictSubwayUserRepository, setProperty);
    }

    @Bean
    public TimeCalculation timeCalculation(){
        return new TimeCalculation();
    }
}
