package com.levelup.mog.service;

import com.levelup.mog.controller.MogController;
import com.levelup.mog.repository.MogRepository;
import com.levelup.mog.repository.MogSubwayIntoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MogService {

    private final MogRepository mogRepository;
    private final MogSubwayIntoRepository mogSubwayIntoRepository;


    private final Logger logger = LoggerFactory.getLogger(MogController.class);

    public MogService(MogRepository mogRepository, MogSubwayIntoRepository mogSubwayIntoRepository) {
        this.mogRepository = mogRepository;
        this.mogSubwayIntoRepository = mogSubwayIntoRepository;
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


    public List<String> getStationInfo(String stationName, String date, int time) {

        List<String> stationLines = new ArrayList<>();

        mogRepository.findBySubwayIdEmpStationName("건대입구").forEach(stationIndex -> {
            stationLines.add(stationIndex.SubwayIdToDto().getLineNumber());
        });

        System.out.println(stationLines);
        System.out.println(mogSubwayIntoRepository.findBySubwayIdFkEmpLineNumberAndSubwayIdFkEmpStationName("7", "건대입구").get(0).getAddress());
        System.out.println(mogSubwayIntoRepository.findBySubwayIdFkEmpLineNumberAndSubwayIdFkEmpStationName("7", "건대입구").get(0).getTelNumber());




        return new ArrayList<>();
    }

}
