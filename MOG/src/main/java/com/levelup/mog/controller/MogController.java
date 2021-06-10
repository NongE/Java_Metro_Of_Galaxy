package com.levelup.mog.controller;

import com.levelup.mog.service.MogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/mog_api")
public class MogController {

    private final MogService mogService;
    private Logger logger = LoggerFactory.getLogger(MogController.class);

    public MogController(MogService mogService) {
        this.mogService = mogService;
    }

    @GetMapping("/get_station")
    public List<String> get_station(
            @RequestParam
            String lineNumber
    ){
        List<String> stations = new ArrayList<String>();

        mogService.getStationNames(lineNumber).ifPresent( station ->
                station.forEach( stationIndex ->
                        stations.add(stationIndex.getName())
                )
        );
        logger.info("get_station active!");
        return stations;
    }

}
