package com.levelup.seatro.controller;


import com.levelup.seatro.model.ResponseMessage;
import com.levelup.seatro.service.SeatroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/seatro_api")
public class SeatroController {

    private final SeatroService seatroService;

    public SeatroController(SeatroService seatroService) {
        this.seatroService = seatroService;
    }


    @GetMapping(value = "/get_stations")
    public ResponseEntity<ResponseMessage> get_stations(
            HttpServletRequest request
    ){

        // 응답에 필요한 Message 선언
        ResponseMessage responseMessage = new ResponseMessage();

        // Map을 가지고 있는 리스트의 형식으로 저장
        List<Map<String, String>> subwayStations = seatroService.findAllSubwayStations();

        // 요청한 경로
        responseMessage.setPath(request.getRequestURI());
        // 결과
        responseMessage.setStatus(HttpStatus.OK.toString());
        // 데이터 (리스트 형태)
        responseMessage.setData(subwayStations);


        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }


}
