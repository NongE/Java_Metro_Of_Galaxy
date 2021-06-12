package com.levelup.mog.controller;

import com.levelup.mog.model.response.ResponseMessage;
import com.levelup.mog.service.MogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


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
    public ResponseEntity<ResponseMessage> get_stations(
            HttpServletRequest request
    ) {
        // Call get stations
        logger.info("API Call: get_stations!");
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

}
