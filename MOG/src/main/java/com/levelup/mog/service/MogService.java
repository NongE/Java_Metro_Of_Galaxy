package com.levelup.mog.service;

import com.levelup.mog.config.SetProperty;
import com.levelup.mog.database.PredictSubwayUser;
import com.levelup.mog.database.SubwayInfo;
import com.levelup.mog.model.dto.users.Row;
import com.levelup.mog.model.dto.users.SubwayUser;
import com.levelup.mog.model.response.GetStationInfoResponse;
import com.levelup.mog.repository.MogPredictSubwayUserRepository;
import com.levelup.mog.repository.MogRepository;
import com.levelup.mog.repository.MogSubwayInfoRepository;
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

    private final MogRepository mogRepository;
    private final MogSubwayInfoRepository mogSubwayInfoRepository;
    private final MogPredictSubwayUserRepository mogPredictSubwayUserRepository;
    private final SetProperty setProperty;

    private final Logger logger = LoggerFactory.getLogger(MogService.class);

    public MogService(MogRepository mogRepository, MogSubwayInfoRepository mogSubwayInfoRepository, MogPredictSubwayUserRepository mogPredictSubwayUserRepository, SetProperty setProperty) {
        this.mogRepository = mogRepository;
        this.mogSubwayInfoRepository = mogSubwayInfoRepository;
        this.mogPredictSubwayUserRepository = mogPredictSubwayUserRepository;
        this.setProperty = setProperty;
    }

    public List<String> getStationNames() {

        List<String> stationNames = new ArrayList<>();

        mogRepository.findAll().forEach(stationIndex -> {
                    stationNames.add(stationIndex.SubwayIdToDto().getSubwayIdEmbDto().getStationName());
                }
        );
        TreeSet<String> deduplicationStationName = new TreeSet<>(stationNames);

        return new ArrayList<>(deduplicationStationName);
    }


    public List<String> getAllStationLines(String stationName){

        List<String> stationLines = new ArrayList<>();
        mogRepository.findBySubwayIdEmbStationName(stationName).forEach(subwayId -> {
            stationLines.add(subwayId.SubwayIdToDto().getSubwayIdEmbDto().getLineNumber());
        });
        return stationLines;
    }

    public List<GetStationInfoResponse> getStationInfo(String stationName, String date, String day, int time) {

        List<GetStationInfoResponse> stationInfos = new ArrayList<>();

        // get all lines about user station
        List<String> userStationLines = getAllStationLines(stationName);

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
            logger.info(user.toString());


            // prepare response structure
            GetStationInfoResponse getStationInfoResponse = new GetStationInfoResponse();

            // get subway info
            SubwayInfo stationInfo = mogSubwayInfoRepository.findBySubwayInfoEmbLineNumberAndSubwayInfoEmbStationName(userStationLine, stationName);

            // get predict subway seat
            PredictSubwayUser peopleInfo = mogPredictSubwayUserRepository.findByPredictSubwayUserEmbLineNumberAndPredictSubwayUserEmbStationNameAndPredictSubwayUserEmbDayAndPredictSubwayUserEmbTime(userStationLine, stationName, day, time);

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
