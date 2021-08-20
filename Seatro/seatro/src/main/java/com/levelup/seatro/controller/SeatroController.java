package com.levelup.seatro.controller;


import com.levelup.seatro.database.entity.StationUsers;
import com.levelup.seatro.model.ResponseMessage;
import com.levelup.seatro.service.SeatroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
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
    ) {

        // 응답에 필요한 Message 선언
        ResponseMessage responseMessage = new ResponseMessage();

        // 요청한 경로
        responseMessage.setPath(request.getRequestURI());

        List<Map<String, String>> subwayStations = new ArrayList<>();

        subwayStations = seatroService.findAllSubwayStations();

        if(subwayStations.size() == 1){
            responseMessage.setStatus(HttpStatus.FOUND.toString());
        }else{
            responseMessage.setStatus(HttpStatus.OK.toString());
        }



        Map<String, Object> data = new HashMap<>();

        data.put("stations list", subwayStations);

        StationUsers tmp = seatroService.findPopularStation();

        Map<String, Object> tmpData = new HashMap<>();
        tmpData.put("time", tmp.getStationUsersEmb().getCheckInTime());
        tmpData.put("line_number", tmp.getStationUsersEmb().getLineNumber());
        tmpData.put("station_name", tmp.getStationUsersEmb().getStationName());
        tmpData.put("people", tmp.getPeople());

        data.put("popular station", tmpData);

        responseMessage.setData(data);
        // responseMessage.setData(subwayStations);

        System.out.println(getClientIp(request));

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    private String getClientIp(HttpServletRequest request) {

        String ip = request.getHeader("X-Forwrded-For");

        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


}
