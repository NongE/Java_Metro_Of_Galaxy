package com.levelup.seatro.controller;


import com.levelup.seatro.model.ResponseMessage;
import com.levelup.seatro.service.SeatroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(path = "/seatro_api")
public class SeatroController {

    private final SeatroService seatroService;

    public SeatroController(SeatroService seatroService) {
        System.out.println("Active!");
        this.seatroService = seatroService;
    }


    @GetMapping(value = "/get_stations")
    public ResponseEntity<ResponseMessage> get_stations(
            HttpServletRequest request
    ){

        ResponseMessage responseMessage = new ResponseMessage();

        Map<String, String> subwayStations = seatroService.findAllSubwayStations();

        responseMessage.setPath(request.getRequestURI());
        responseMessage.setStatus(HttpStatus.OK.toString());
        responseMessage.setData(subwayStations);


        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }


}
