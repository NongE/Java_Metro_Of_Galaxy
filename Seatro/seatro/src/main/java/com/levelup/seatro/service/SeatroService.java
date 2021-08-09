package com.levelup.seatro.service;

import com.levelup.seatro.database.emb.SubwayStations;
import com.levelup.seatro.database.emb.SubwayStationsEntityEmb;
import com.levelup.seatro.repository.SubwayStationsRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class SeatroService {

    private final SubwayStationsRepository subwayStationsRepository;

    public SeatroService(SubwayStationsRepository subwayStationsRepository) {
        this.subwayStationsRepository = subwayStationsRepository;
    }

    public List<Map<String, String>> findAllSubwayStations() {

        List<Map<String, String>> result = new ArrayList<>();

        // 테이블에 있는 모든 데이터 조회
        List<SubwayStations> stations = subwayStationsRepository.findAll();

        // 리스트를 순회하며 호선을 키, 역사 명을 값으로 하는 Map 형식으로 저장
        stations.forEach(index -> {
            SubwayStationsEntityEmb subwayStationsEntityEmb = index.getSubwayStationsEntityEmb();
            result.add(new HashMap() {
                {
                    put("line_number", subwayStationsEntityEmb.getLineNumber());
                    put("station_name", subwayStationsEntityEmb.getStationName());
                }
            });

        });

//        Collections.sort(result, new Comparator<Map<String, String>> () {
//            @Override
//            public int compare(Map<String, String> o1, Map<String, String> o2) {
//                return o1.get("line_number").compareTo(o2.get("line_number"));
//            }
//        });

        return result;
    }



}
