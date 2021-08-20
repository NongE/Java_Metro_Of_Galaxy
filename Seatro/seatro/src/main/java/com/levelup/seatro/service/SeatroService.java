package com.levelup.seatro.service;

import com.levelup.seatro.database.entity.StationUsers;
import com.levelup.seatro.database.entity.SubwayStations;
import com.levelup.seatro.database.emb.SubwayStationsEmb;
import com.levelup.seatro.repository.StationUsersRepository;
import com.levelup.seatro.repository.SubwayStationsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class SeatroService {

    private final SubwayStationsRepository subwayStationsRepository;
    private final StationUsersRepository stationUsersRepository;

    public SeatroService(SubwayStationsRepository subwayStationsRepository, StationUsersRepository stationUsersRepository) {
        this.subwayStationsRepository = subwayStationsRepository;
        this.stationUsersRepository = stationUsersRepository;
    }

    public List<Map<String, String>> findAllSubwayStations() {

        List<Map<String, String>> result = new ArrayList<>();

        List<SubwayStations> stations = new ArrayList<>();

        // 테이블에 있는 모든 데이터 조회
        try {
            stations = subwayStationsRepository.findAll();

            stations.forEach(index -> {
                SubwayStationsEmb subwayStationsEmb = index.getSubwayStationsEntityEmb();
                result.add(new HashMap() {
                    {
                        put("line_number", subwayStationsEmb.getLineNumber());
                        put("station_name", subwayStationsEmb.getStationName());
                    }
                });

            });
        } catch (Exception e) {
            result.clear();
            result.add(new HashMap() {
                {
                    put("line_number", "1호선");
                    put("station_name", "시청역");
                }
            });
        }




        // 리스트를 순회하며 호선을 키, 역사 명을 값으로 하는 Map 형식으로 저장


//        Collections.sort(result, new Comparator<Map<String, String>> () {
//            @Override
//            public int compare(Map<String, String> o1, Map<String, String> o2) {
//                return o1.get("line_number").compareTo(o2.get("line_number"));
//            }
//        });

        return result;
    }

    public StationUsers findPopularStation(){
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime.getHour());
        return stationUsersRepository.findByStationUsersEmbCheckInTimeOrderByPeopleDesc(currentTime.getHour()).get(0);

    }


}
