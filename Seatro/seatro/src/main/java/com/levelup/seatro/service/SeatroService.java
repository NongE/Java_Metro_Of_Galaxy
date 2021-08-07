package com.levelup.seatro.service;

import com.levelup.seatro.database.emb.SubwayStations;
import com.levelup.seatro.database.emb.SubwayStationsEntityEmb;
import com.levelup.seatro.repository.SubwayStationsRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SeatroService {

    private final SubwayStationsRepository subwayStationsRepository;

    public SeatroService(SubwayStationsRepository subwayStationsRepository) {
        this.subwayStationsRepository = subwayStationsRepository;
    }

    public Map<String, String> findAllSubwayStations() {

        Map<String, String> result = new TreeMap<>();

        List<SubwayStations> stations = subwayStationsRepository.findAll();

        stations.forEach(index -> {
            SubwayStationsEntityEmb subwayStationsEntityEmb = index.getSubwayStationsEntityEmb();
            result.put(subwayStationsEntityEmb.getLineNumber(), subwayStationsEntityEmb.getStationName());

        });

        return result;
    }

}
