package com.levelup.mog.controller;

import com.levelup.mog.model.dto.SubwayUser;
import com.levelup.mog.model.request.GetStationInfoRequest;
import com.levelup.mog.model.response.GetStationInfoResponse;
import com.levelup.mog.model.response.ResponseMessage;
import com.levelup.mog.service.MogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
    ) throws UnsupportedEncodingException {
        // Call get stations
        logger.info("API Call: get_stations");
        List<String> getStations = mogService.getStationNames();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        HttpEntity<String> entity = new HttpEntity<>(headers);

//        UriComponents build = UriComponentsBuilder.fromHttpUrl(url)
//                .build(false)
//                .encode(StandardCharsets.UTF_8);
//
//        System.out.println(build.toString());
//        SubwayUser su = restTemplate.exchange(build.toString(), HttpMethod.GET, entity, SubwayUser.class).getBody();
//
//        System.out.println(su);


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
    public ResponseEntity<ResponseMessage> get_station_info(
            HttpServletRequest request,
            @RequestBody GetStationInfoRequest getStationInfoRequest
    ) {
        // Call get stations
        logger.info("API Call: get_stations");
        List<GetStationInfoResponse> getStationsInfo = mogService.getStationInfo(getStationInfoRequest.getStationName(), getStationInfoRequest.getDate(), getStationInfoRequest.getTime());

        // Put stations list to ResponseMessage
        ResponseMessage result = new ResponseMessage();
        result.setPath(request.getRequestURI());
        result.setStatus(HttpStatus.OK.toString());
        result.setResult("success");
        result.setData(getStationsInfo);

        // Return ResponseEntity
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
