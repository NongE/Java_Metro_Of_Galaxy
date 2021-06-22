package com.levelup.mog.config;

import com.levelup.mog.aop.TimeCalculation;
import com.levelup.mog.repository.PredictSubwayUserRepository;
import com.levelup.mog.repository.SubwayIdRepository;
import com.levelup.mog.repository.SubwayInfoRepository;
import com.levelup.mog.service.MogService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class SpringConfig {

    private final SubwayIdRepository subwayIdRepository;
    private final SubwayInfoRepository subwayInfoRepository;
    private final PredictSubwayUserRepository predictSubwayUserRepository;

    public SpringConfig(SubwayIdRepository subwayIdRepository,SubwayInfoRepository subwayInfoRepository, PredictSubwayUserRepository predictSubwayUserRepository) {
        this.subwayIdRepository = subwayIdRepository;
        this.subwayInfoRepository = subwayInfoRepository;
        this.predictSubwayUserRepository = predictSubwayUserRepository;
    }

    @Bean
    public MogService mogService(){
        return new MogService(subwayIdRepository, subwayInfoRepository, predictSubwayUserRepository, setProperty());
    }

    @ConfigurationProperties("api")
    @Bean
    public SetProperty setProperty(){
        return new SetProperty();
    }


    @Bean
    public TimeCalculation timeCalculation(){
        return new TimeCalculation();
    }


}
