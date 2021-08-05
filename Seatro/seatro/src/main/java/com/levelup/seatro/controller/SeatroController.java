package com.levelup.seatro.controller;


import com.levelup.seatro.database.emb.SubwayStations;
import com.levelup.seatro.model.ResponseMessage;
import com.levelup.seatro.repository.SubwayStationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/seatro_api")
public class SeatroController {

    @GetMapping(value = "/get_stations")
    public ResponseEntity<ResponseMessage> get_stations(
            HttpServletRequest request
    ){

        ResponseMessage responseMessage = new ResponseMessage();

        responseMessage.setPath(request.getRequestURI());
        responseMessage.setStatus(HttpStatus.OK.toString());
        responseMessage.setData(new int[]{1,2,3,4,5});

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }


}
