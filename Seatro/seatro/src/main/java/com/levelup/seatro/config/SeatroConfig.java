package com.levelup.seatro.config;

import com.levelup.seatro.controller.SeatroController;
import com.levelup.seatro.repository.SubwayStationsRepository;
import com.levelup.seatro.service.SeatroService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeatroConfig {

    private final SubwayStationsRepository subwayStationsRepository;


    public SeatroConfig(SubwayStationsRepository subwayStationsRepository) {
        this.subwayStationsRepository = subwayStationsRepository;
    }


    @Bean
    public SeatroService seatroService(){
        return new SeatroService(subwayStationsRepository);
    }

}
