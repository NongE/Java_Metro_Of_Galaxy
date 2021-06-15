package com.levelup.mog.service;

import com.levelup.mog.controller.MogController;
import com.levelup.mog.database.SubwayInfo;
import com.levelup.mog.database.SubwayPeopleInfo;
import com.levelup.mog.model.response.GetStationInfoResponse;
import com.levelup.mog.repository.MogRepository;
import com.levelup.mog.repository.MogSubwayInfoRepository;
import com.levelup.mog.repository.MogSubwayPeopleInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MogService {

    private final MogRepository mogRepository;
    private final MogSubwayInfoRepository mogSubwayInfoRepository;
    private final MogSubwayPeopleInfoRepository mogSubwayPeopleInfoRepository;

    private final Logger logger = LoggerFactory.getLogger(MogController.class);

    public MogService(MogRepository mogRepository, MogSubwayInfoRepository mogSubwayInfoRepository, MogSubwayPeopleInfoRepository mogSubwayPeopleInfoRepository) {
        this.mogRepository = mogRepository;
        this.mogSubwayInfoRepository = mogSubwayInfoRepository;
        this.mogSubwayPeopleInfoRepository = mogSubwayPeopleInfoRepository;
    }

    public List<String> getStationNames() {

        List<String> stationNames = new ArrayList<>();

        mogRepository.findAll().forEach(stationIndex -> {
                    stationNames.add(stationIndex.SubwayIdToDto().getStationName());
                }
        );

        TreeSet<String> deduplicationStationName = new TreeSet<>(stationNames);

        return new ArrayList<>(deduplicationStationName);
    }


    public List<GetStationInfoResponse> getStationInfo(String stationName, String date, int time) {

        List<GetStationInfoResponse> stationInfos = new ArrayList<>();


        mogRepository.findBySubwayIdEmbStationName(stationName).forEach(subwayId ->{

            GetStationInfoResponse getStationInfoResponse = new GetStationInfoResponse();

            String lineNumber = subwayId.SubwayIdToDto().getLineNumber();
            SubwayInfo stationInfo = mogSubwayInfoRepository.findBySubwayIdFkEmbLineNumberAndSubwayIdFkEmbStationName(lineNumber, stationName);
            SubwayPeopleInfo peopleInfo = mogSubwayPeopleInfoRepository.findBySubwayIdFkEmbLineNumberAndSubwayIdFkEmbStationNameAndDateAndTime(lineNumber, stationName, date, time);

            getStationInfoResponse.setLine(lineNumber);
            getStationInfoResponse.setAddress(stationInfo.getAddress());
            getStationInfoResponse.setTelNumber(stationInfo.getTelNumber());
            getStationInfoResponse.setPeople(peopleInfo.getPeople());
            getStationInfoResponse.setSeatPredict(Arrays.asList(false, false, true, false, false, true, false));

            stationInfos.add(getStationInfoResponse);
        });

        return stationInfos;
    }

}
