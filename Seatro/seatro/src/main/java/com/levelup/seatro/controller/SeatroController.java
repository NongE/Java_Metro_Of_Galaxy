package com.levelup.seatro.controller;


import com.levelup.seatro.database.entity.StationUsers;
import com.levelup.seatro.model.ResponseMessage;
import com.levelup.seatro.model.StationInfoRequest;
import com.levelup.seatro.service.SeatroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = {"/seatro_api"})
public class SeatroController {

    private final SeatroService seatroService;

    public SeatroController(SeatroService seatroService) {
        this.seatroService = seatroService;
    }


    @GetMapping(value = {"/get_stations"})
    public ResponseEntity<ResponseMessage> get_stations(
            HttpServletRequest request
    ) {
        // 응답에 필요한 Message 선언
        ResponseMessage responseMessage = new ResponseMessage();

        // 요청한 경로
        responseMessage.setPath(request.getRequestURI());

        // 반환할 데이터 저장
        Map<String, Object> data = new HashMap<>();

        // 역사 목록
        Map<String, Object> subwayStations = seatroService.getAllSubwayStations();
        data.put("station_list", subwayStations.get("data"));

        // 이용객이 많은 역사
        Map<String, Object> popularStation = getPopularStation();
        data.put("popular_station", popularStation);

        responseMessage.setData(data);

        responseMessage.setStatus(subwayStations.get("status").toString());

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    // 현 시간대에 이용객이 가장 많은 역사, 호선 정보 구하기
    private Map<String, Object> getPopularStation() {

        // 현재 가장 인원이 많은 역사 임시 저장
        StationUsers _popularStation = seatroService.findPopularStation();

        Map<String, Object> stationInfo = new HashMap<>() {{
                put("time", _popularStation.getStationUsersEmb().getCheckInTime());
                put("line_number", _popularStation.getStationUsersEmb().getLineNumber());
                put("station_name", _popularStation.getStationUsersEmb().getStationName());
                put("people", _popularStation.getPeople());
            }
        };

        return stationInfo;

    }

    @PostMapping(value = {"/get_station_info"})
    public ResponseEntity<ResponseMessage> getStationInfo(
            @RequestBody
            StationInfoRequest stationInfoRequest,
            HttpServletRequest request
    ){
        ResponseMessage responseMessage = new ResponseMessage();

        // 요청한 경로
        responseMessage.setPath(request.getRequestURI());

        // 반환할 데이터 저장
        List<Map<String, Object>> data = seatroService.getStationInfo(stationInfoRequest.getLineNumber(), stationInfoRequest.getStationName(), stationInfoRequest.getTime());

        responseMessage.setData(data);

        responseMessage.setStatus(HttpStatus.OK.toString());


        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }



}
