package com.levelup.mog.service;

import com.levelup.mog.database.SubwayId;
import com.levelup.mog.model.SubwayIdDto;
import com.levelup.mog.repository.MogRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class MogService {

    private final MogRepository mogRepository;

    public MogService(MogRepository mogRepository) {
        this.mogRepository = mogRepository;
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

}
