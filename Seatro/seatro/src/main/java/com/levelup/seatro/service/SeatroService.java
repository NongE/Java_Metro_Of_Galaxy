package com.levelup.seatro.service;

import com.levelup.seatro.database.entity.StationDetailUsers;
import com.levelup.seatro.database.entity.StationUsers;
import com.levelup.seatro.database.entity.SubwayStations;
import com.levelup.seatro.database.emb.SubwayStationsEmb;
import com.levelup.seatro.repository.StationDetailUsersRepository;
import com.levelup.seatro.repository.StationUsersRepository;
import com.levelup.seatro.repository.SubwayStationsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public class SeatroService {

    private final SubwayStationsRepository subwayStationsRepository;
    private final StationUsersRepository stationUsersRepository;
    private final StationDetailUsersRepository stationDetailUsersRepository;

    public SeatroService(SubwayStationsRepository subwayStationsRepository, StationUsersRepository stationUsersRepository, StationDetailUsersRepository stationDetailUsersRepository) {
        this.subwayStationsRepository = subwayStationsRepository;
        this.stationUsersRepository = stationUsersRepository;
        this.stationDetailUsersRepository = stationDetailUsersRepository;
    }

    public List<Map<String, String>> findAllSubwayStations() {

        List<Map<String, String>> result = new ArrayList<>();

        // 테이블에 있는 모든 데이터 조회
        try {
            List<SubwayStations> stations = subwayStationsRepository.findAll();

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
            // 테이블 조회 중 오류 발생 시 임의의 값을 넣어 반환
            result.clear();
            result.add(new HashMap() {
                {
                    put("line_number", "1호선");
                    put("station_name", "시청역");
                }
            });
        }

        return result;
    }

    public StationUsers findPopularStation(){
        // 현재 시간 구하기
        LocalTime currentTime = LocalTime.now();

        // 이용객 수를 기준으로 내림차순 정렬, 이후 가장 많은 역사를 반환
        return stationUsersRepository.findByStationUsersEmbCheckInTimeOrderByPeopleDesc(currentTime.getHour()).get(0);

    }

    public List<Map<String, String>> getStationInfo(String lineNumber, String stationName, int checkInTime){
        List<StationDetailUsers> test = stationDetailUsersRepository.findByStationUsersEmbLineNumberAndStationUsersEmbStationNameAndStationUsersEmbCheckInTime(lineNumber, stationName, checkInTime);

        List<Map<String, String>> result = new ArrayList<>();

        test.forEach( index -> {
            Map<String, String> stationInfo = new HashMap<>();
            stationInfo.put("direction", index.getStationUsersEmb().getDirection());
            stationInfo.put("cabin_1", index.getCabin1().toString());
            stationInfo.put("cabin_2", index.getCabin2().toString());
            stationInfo.put("cabin_3", index.getCabin3().toString());
            stationInfo.put("cabin_4", index.getCabin4().toString());
            stationInfo.put("cabin_5", index.getCabin5().toString());
            stationInfo.put("cabin_6", index.getCabin6().toString());
            stationInfo.put("cabin_7", index.getCabin7().toString());
            stationInfo.put("cabin_8", index.getCabin8().toString());

            result.add(stationInfo);
        });

        return result;

    }


}
