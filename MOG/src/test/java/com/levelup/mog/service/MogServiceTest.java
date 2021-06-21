package com.levelup.mog.service;

import com.levelup.mog.database.PredictSubwayUser;
import com.levelup.mog.database.SubwayId;
import com.levelup.mog.database.SubwayInfo;
import com.levelup.mog.repository.PredictSubwayUserRepository;
import com.levelup.mog.repository.SubwayIdRepository;
import com.levelup.mog.repository.SubwayInfoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MogServiceTest {

    @Autowired
    SubwayIdRepository subwayIdRepository;
    @Autowired
    SubwayInfoRepository subwayInfoRepository;
    @Autowired
    PredictSubwayUserRepository predictSubwayUserRepository;

    @Test
    @DisplayName("전체 역사를 가져옵니다.")
    void getStationNamesTest() {
        //given
        List<String> stationNames = new ArrayList<>();
        subwayIdRepository.findAll().forEach(stationIndex -> {
                    stationNames.add(stationIndex.SubwayIdToDto().getSubwayIdEmbDto().getStationName());
                }
        );

        //when
        TreeSet<String> deduplicationStationName = new TreeSet<>(stationNames);

        //then
        assertThat(deduplicationStationName.size() == 10);
    }

    @Test
    @DisplayName("특정 역사의 모든 호선을 가져옵니다.")
    void getAllStationLinesTest() {
        //given
        List<String> getLines1 = new ArrayList<>();
        List<String> getLines2 = new ArrayList<>();
        List<String> getLines3 = new ArrayList<>();

        // have 2 lines over
        List<SubwayId> exampleLines1 = subwayIdRepository.findBySubwayIdEmbStationName("건대입구");
        // have 1 line
        List<SubwayId> exampleLines2 = subwayIdRepository.findBySubwayIdEmbStationName("어린이대공원");
        // not have
        List<SubwayId> exampleLines3 = subwayIdRepository.findBySubwayIdEmbStationName("Temp");

        //when
        exampleLines1.forEach(subwayId -> {
            getLines1.add(subwayId.SubwayIdToDto().getSubwayIdEmbDto().getLineNumber());
        });
        exampleLines2.forEach(subwayId -> {
            getLines2.add(subwayId.SubwayIdToDto().getSubwayIdEmbDto().getLineNumber());
        });
        exampleLines3.forEach(subwayId -> {
            getLines3.add(subwayId.SubwayIdToDto().getSubwayIdEmbDto().getLineNumber());
        });

        //then
        assertThat(getLines1.containsAll(new ArrayList<String>(Arrays.asList("2호선", "7호선"))));
        assertThat(getLines2.containsAll(new ArrayList<String>(Arrays.asList("7호선"))));
        assertThat(getLines3.size() == 0);

    }

    @Test
    @DisplayName("OpenAPI로 가져오는 정보를 제외하고 특정 역사의 모든 정보를 가져옵니다.")
    void getStationInfo(){

        //given
        String userStationLine = "5호선";
        String stationName = "군자(능동)";
        String day = "월";
        Integer time = 1;


        // when
        SubwayInfo stationInfo = subwayInfoRepository.findBySubwayInfoEmbLineNumberAndSubwayInfoEmbStationName(userStationLine, stationName);
        PredictSubwayUser peopleInfo = predictSubwayUserRepository.findByPredictSubwayUserEmbLineNumberAndPredictSubwayUserEmbStationNameAndPredictSubwayUserEmbDayAndPredictSubwayUserEmbTime(userStationLine, stationName, day, time);

        //then
        Assertions.assertThat(stationInfo.SubwayInfoToDto().getSubwayInfoEmbDto().getLineNumber()).isEqualTo("5호선");
        Assertions.assertThat(stationInfo.SubwayInfoToDto().getSubwayInfoEmbDto().getStationName()).isEqualTo("군자(능동)");

        Assertions.assertThat(stationInfo.SubwayInfoToDto().getAddress()).isEqualTo("서울 5호선 군자(능동)");
        Assertions.assertThat(stationInfo.SubwayInfoToDto().getTelNumber()).isEqualTo("55-0000-0001");

        Assertions.assertThat(peopleInfo.PredictSubwayUserToDto().getPredictSubwayUserFkEmbDto().getLineNumber()).isEqualTo("5호선");
        Assertions.assertThat(peopleInfo.PredictSubwayUserToDto().getPredictSubwayUserFkEmbDto().getStationName()).isEqualTo("군자(능동)");

        Assertions.assertThat(peopleInfo.PredictSubwayUserToDto().getPredictSubwayUserFkEmbDto().getDay()).isEqualTo("월");
        Assertions.assertThat(peopleInfo.PredictSubwayUserToDto().getPredictSubwayUserFkEmbDto().getTime()).isEqualTo(1);

        Assertions.assertThat(peopleInfo.PredictSubwayUserToDto().getPredictSeat()).isEqualTo(0);
    }
}