package com.levelup.seatro.controller;


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
        List<Map<String, String>> subwayStations = new ArrayList<>();

        try {
            // Map을 가지고 있는 리스트의 형식으로 저장
            subwayStations = seatroService.findAllSubwayStations();

            // 결과
            responseMessage.setStatus(HttpStatus.OK.toString());

            Exception e = new Exception("고이ㅡ");
            throw e;

        } catch (Exception e) {

            subwayStations.add(new HashMap() {
                {
                    put("line_number", "1호선");
                    put("station_name", "시청역");
                }
            });

            // 결과
            responseMessage.setStatus(HttpStatus.FOUND.toString());

        } finally {
            // 요청한 경로
            responseMessage.setPath(request.getRequestURI());
            // 데이터 (리스트 형태)
            responseMessage.setData(subwayStations);
        }


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
