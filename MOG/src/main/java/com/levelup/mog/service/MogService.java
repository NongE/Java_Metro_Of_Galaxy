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
import java.util.*;

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
        int START_INDEX = 1;
        int END_INDEX = 5;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // loop and get data
        userStationLines.forEach(userStationLine ->{

            // subway users
            int user = 0;

            // subway user info from open api
            UriComponents build = UriComponentsBuilder.fromHttpUrl(url)
                    .path(key+"/"+TYPE+"/"+SERVICE+"/"+START_INDEX+"/"+END_INDEX+"/"+ date +"/"+userStationLine+"/"+ stationName)
                    .build();

            // json to class
            ResponseEntity<SubwayUser> subwayUsers = restTemplate.exchange(build.toString(), HttpMethod.GET, entity, SubwayUser.class);
            Row userRow = subwayUsers.getBody().getCardSubwayTime().getRow().get(0);

            // get subway user at time
            user = getSubwayUsers(userStationLine, time, userRow);

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

    // mapping int to data
    // get users at time
    private Integer getSubwayUsers(String line, Integer userTime, Row userRow) {

        // mapping user time to data
        Map<Integer, Integer> subwayTime = new HashMap<Integer, Integer>(){
            {
                put(4, userRow.getFourAlightNUM() + userRow.getFourRideNum());
                put(5, userRow.getFiveAlightNUM() + userRow.getFiveRideNum());
                put(6, userRow.getSixAlightNUM() + userRow.getSixRideNum());
                put(7, userRow.getSevenAlightNUM() + userRow.getSevenRideNum());
                put(8, userRow.getEightAlightNUM() + userRow.getEightRideNum());
                put(9, userRow.getNineAlightNUM() + userRow.getNineRideNum());
                put(10, userRow.getTenAlightNUM() + userRow.getTenRideNum());
                put(11, userRow.getElevenAlightNUM() + userRow.getElevenRideNum());
                put(12, userRow.getTwelveAlightNUM() + userRow.getTwelveRideNum());
                put(13, userRow.getThirteenAlightNUM() + userRow.getThirteenRideNum());
                put(14, userRow.getFourteenAlightNUM() + userRow.getFourteenRideNum());
                put(15, userRow.getFifteenAlightNUM() + userRow.getFifteenRideNum());
                put(16, userRow.getSixteenAlightNUM() + userRow.getSixteenRideNum());
                put(17, userRow.getSeventeenAlightNUM() + userRow.getSeventeenRideNum());
                put(18, userRow.getEighteenAlightNUM() + userRow.getEighteenRideNum());
                put(19, userRow.getNineteenAlightNUM() + userRow.getNineteenRideNum());
                put(20, userRow.getTwentyAlightNUM() + userRow.getTwentyRideNum());
                put(21, userRow.getTwentyOneAlightNUM() + userRow.getTwentyOneRideNum());
                put(22, userRow.getTwentyTwoAlightNUM() + userRow.getTwentyTwoRideNum());
                put(23, userRow.getTwentyThreeAlightNUM() + userRow.getTwentyThreeRideNum());
                put(0, userRow.getMidnightAlightNUM() + userRow.getMidnightRideNum());
                put(1, userRow.getOneAlightNUM() + userRow.getOneRideNum());
                put(2, userRow.getTwoAlightNUM() + userRow.getTwoRideNum());
                put(3, userRow.getThreeAlightNUM() + userRow.getThreeRideNum());
            }

        };

        Map<String, Integer> subwayCabinCount = new HashMap<>(){
            {
                put("1호선", 10);
                put("2호선", 5);
                put("3호선", 10);
                put("4호선", 10);
                put("5호선", 8);
                put("6호선", 8);
                put("7호선", 8);
            }
        };

        // return data at time
        return subwayTime.get(userTime)/subwayCabinCount.get(line)/2;
    }

}
