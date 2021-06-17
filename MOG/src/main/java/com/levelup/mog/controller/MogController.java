package com.levelup.mog.controller;

import com.levelup.mog.config.SetProperty;
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
import java.nio.charset.StandardCharsets;
import java.util.List;


@RestController
@RequestMapping(path = "/mog_api")
public class MogController {

    private final MogService mogService;
    private final SetProperty setProperty;
    private final Logger logger = LoggerFactory.getLogger(MogController.class);

    public MogController(MogService mogService, SetProperty setProperty) {
        this.mogService = mogService;
        this.setProperty = setProperty;
    }

    // Get all station names
    @GetMapping(value = "/get_stations")
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
    public ResponseEntity<SubwayUser> get_station_info(
            HttpServletRequest request,
            @RequestBody GetStationInfoRequest getStationInfoRequest
    ) {
        // Call get stations
        logger.info("API Call: get_stations");

        List<String> lines = mogService.getAllStationLines(getStationInfoRequest.getStationName());

        System.out.println(lines);

        String url = setProperty.getUrl();
        String key = setProperty.getKey();
        String TYPE = setProperty.getType();
        String SERVICE = setProperty.getService();
        Integer START_INDEX = 1;
        Integer END_INDEX = 5;
        String USE_MON = getStationInfoRequest.getDate();
        String SUB_STA_NM = getStationInfoRequest.getStationName();


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String LINE_NUM = "1호선";
        ResponseEntity<SubwayUser> su = null;
        for (Integer i = 0; i<lines.size(); i++){
            LINE_NUM = lines.get(i)+"호선";
            UriComponents build = UriComponentsBuilder.fromHttpUrl(url)
                    .path(key+"/"+TYPE+"/"+SERVICE+"/"+START_INDEX+"/"+END_INDEX+"/"+USE_MON+"/"+LINE_NUM+"/"+SUB_STA_NM)
                    .build();
            System.out.println(build.toString());
            su = restTemplate.exchange(build.toString(), HttpMethod.GET, entity, SubwayUser.class);
            System.out.println(su.getBody().getCardSubwayTime().getRow().get(0).getFourRideNum());
        }


        // Put stations list to ResponseMessage
//        ResponseMessage result = new ResponseMessage();
//        result.setPath(request.getRequestURI());
//        result.setStatus(HttpStatus.OK.toString());
//        result.setResult("success");
//        result.setData(getStationsInfo);

        // Return ResponseEntity
        //return new ResponseEntity<>(result, HttpStatus.OK);
        return su;
    }


}
