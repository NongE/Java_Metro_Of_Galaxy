package com.levelup.mog.service;

import com.levelup.mog.database.SubwayId;
import com.levelup.mog.model.SubwayIdDto;
import com.levelup.mog.model.response.GetStationResponse;
import com.levelup.mog.repository.MogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MogService {

    private MogRepository mogRepository;

    public MogService(MogRepository mogRepository) {
        this.mogRepository = mogRepository;
    }

    public Optional<List<GetStationResponse>> getStationNames(String stationName){
        return mogRepository.findByLine(stationName);
    }

}
