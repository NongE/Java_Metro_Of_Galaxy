package com.levelup.mog.service;

import com.levelup.mog.config.SetProperty;
import com.levelup.mog.database.PredictSubwayUser;
import com.levelup.mog.database.SubwayInfo;
import com.levelup.mog.model.dto.users.Row;
import com.levelup.mog.model.dto.users.SubwayUser;
import com.levelup.mog.model.response.GetStationInfoResponse;
import com.levelup.mog.repository.PredictSubwayUserRepository;
import com.levelup.mog.repository.SubwayIdRepository;
import com.levelup.mog.repository.SubwayInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MogService {

    private final SubwayIdRepository subwayIdRepository;
    private final SubwayInfoRepository subwayInfoRepository;
    private final PredictSubwayUserRepository predictSubwayUserRepository;
    private final SetProperty setProperty;

    private final Logger logger = LoggerFactory.getLogger(MogService.class);

    public MogService(SubwayIdRepository subwayIdRepository, SubwayInfoRepository subwayInfoRepository, PredictSubwayUserRepository predictSubwayUserRepository, SetProperty setProperty) {
        this.subwayIdRepository = subwayIdRepository;
        this.subwayInfoRepository = subwayInfoRepository;
        this.predictSubwayUserRepository = predictSubwayUserRepository;
        this.setProperty = setProperty;
    }

    // get all station name
    public List<String> getStationNames() {

        List<String> stationNames = new ArrayList<>();

        subwayIdRepository.findAll().forEach(stationIndex -> {
                    stationNames.add(stationIndex.SubwayIdToDto().getSubwayIdEmbDto().getStationName());
                }
        );

        // remove deduplication
        TreeSet<String> deduplicationStationName = new TreeSet<>(stationNames);

        return new ArrayList<>(deduplicationStationName);
    }


    // get all station lines
    public List<String> getAllStationLines(String stationName){

        List<String> stationLines = new ArrayList<>();

        subwayIdRepository.findBySubwayIdEmbStationName(stationName).forEach(subwayId -> {
            stationLines.add(subwayId.SubwayIdToDto().getSubwayIdEmbDto().getLineNumber());
        });
        return stationLines;
    }

    // get station info
    public List<GetStationInfoResponse> getStationInfo(String stationName, String date, String day, int time) {

        List<GetStationInfoResponse> stationInfos = new ArrayList<>();

        // get all lines about user station
        List<String> userStationLines = getAllStationLines(stationName);
        logger.info(userStationLines.toString());

        // set get data from open api
        String url = setProperty.getUrl();
        String key = setProperty.getKey();
        String TYPE = setProperty.getType();
        String SERVICE = setProperty.getService();
        Integer START_INDEX = 1;
        Integer END_INDEX = 5;
        String USE_MON = date;
        String SUB_STA_NM = stationName;
        // String LINE_NUM = "1호선";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        userStationLines.forEach(userStationLine ->{

            // subway users
            Integer user = 0;

            // subway user info from open api
            UriComponents build = UriComponentsBuilder.fromHttpUrl(url)
                    .path(key+"/"+TYPE+"/"+SERVICE+"/"+START_INDEX+"/"+END_INDEX+"/"+USE_MON+"/"+userStationLine+"/"+SUB_STA_NM)
                    .build();

            // json to class
            ResponseEntity<SubwayUser> subwayUsers = restTemplate.exchange(build.toString(), HttpMethod.GET, entity, SubwayUser.class);
            Row userRow = subwayUsers.getBody().getCardSubwayTime().getRow().get(0);
            user = userRow.getFourRideNum() + userRow.getFourAlightNUM();


            // prepare response structure
            GetStationInfoResponse getStationInfoResponse = new GetStationInfoResponse();

            // get subway info
            SubwayInfo stationInfo = subwayInfoRepository.findBySubwayInfoEmbLineNumberAndSubwayInfoEmbStationName(userStationLine, stationName);

            // get predict subway seat
            PredictSubwayUser peopleInfo = predictSubwayUserRepository.findByPredictSubwayUserEmbLineNumberAndPredictSubwayUserEmbStationNameAndPredictSubwayUserEmbDayAndPredictSubwayUserEmbTime(userStationLine, stationName, day, time);

            // set response
            getStationInfoResponse.setLine(userStationLine);
            getStationInfoResponse.setAddress(stationInfo.getAddress());
            getStationInfoResponse.setTelNumber(stationInfo.getTelNumber());
            getStationInfoResponse.setPeople(user);
            getStationInfoResponse.setSeatPredict(peopleInfo.getPredictSeat());

            stationInfos.add(getStationInfoResponse);
        });


        return stationInfos;
    }

}
