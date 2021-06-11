package com.levelup.mog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.levelup.mog.model.response.GetStations;
import com.levelup.mog.model.response.ResponseMessage;
import com.levelup.mog.service.MogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/mog_api")
public class MogController {

    private final MogService mogService;
    private Logger logger = LoggerFactory.getLogger(MogController.class);

    public MogController(MogService mogService) {
        this.mogService = mogService;
    }

    @GetMapping(value = "/get_station")
    public ResponseEntity<ResponseMessage> get_station(
            @RequestParam
                    String lineNumber
    ) {

        List<String> stations = new ArrayList<>();

        mogService.getStationNames(lineNumber).ifPresent(station ->
                {
                    station.forEach(stationIndex ->{
                        stations.add(stationIndex.getName());
                    });
                }
        );
        System.out.println(stations);
        logger.info("get_station active!");

        ResponseMessage result = new ResponseMessage();
        result.setPath("200");
        result.setStatus("200");
        result.setResult("200");
        result.setData(stations);


        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
