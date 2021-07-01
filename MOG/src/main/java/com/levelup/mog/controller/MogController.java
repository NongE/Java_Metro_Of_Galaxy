package com.levelup.mog.controller;

import com.levelup.mog.model.request.GetStationInfoRequest;
import com.levelup.mog.model.response.GetStationInfoResponse;
import com.levelup.mog.model.response.ResponseMessage;
import com.levelup.mog.service.MogService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;


@RestController
@RequestMapping(path = "/mog_api")
public class MogController {

    private final MogService mogService;

    private final Logger logger = LoggerFactory.getLogger(MogController.class);

    public MogController(MogService mogService) {
        this.mogService = mogService;
    }

    // Get all station names
    @GetMapping(value = "/get_stations")
    @ApiOperation(value = "역사 명을 반환하는 API", notes = "DB 내에 저장되어 있는 역사 명을 모두 반환합니다.")
    public ResponseEntity<ResponseMessage> get_stations(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        // Call get stations
        logger.info("API Call: get_stations");
        List<String> getStations = mogService.getStationNames();

        // Put stations list to ResponseMessage
        ResponseMessage result = new ResponseMessage();
        result.setPath(request.getRequestURI());
        result.setStatus(HttpStatus.OK.toString());
        result.setResult("success");
        result.setData(getStations);

        // Return ResponseEntity
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping(value = "/get_station_info")
    @ApiOperation(value = "특정 역사에 대한 정보를 반환하는 API", notes = "특정 역사에 대해 기본적인 정보(전화번호, 주소 등)와 앉을 수 있을지에 대한 예측치를 반환합니다.")
    public ResponseEntity<ResponseMessage> get_station_info(
            HttpServletRequest request,
            @RequestBody GetStationInfoRequest getStationInfoRequest
    ) {
        // Call get stations
        logger.info("API Call: get_station_info");

        //String stationName, String date, int time
        List<GetStationInfoResponse> lines = mogService.getStationInfo(getStationInfoRequest.getStationName(), getStationInfoRequest.getDate(), getStationInfoRequest.getDay(), getStationInfoRequest.getTime());

        // Put stations list to ResponseMessage
        ResponseMessage result = new ResponseMessage();
        result.setPath(request.getRequestURI());
        result.setStatus(HttpStatus.OK.toString());
        result.setResult("success");
        result.setData(lines);

        // Return ResponseEntity
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
