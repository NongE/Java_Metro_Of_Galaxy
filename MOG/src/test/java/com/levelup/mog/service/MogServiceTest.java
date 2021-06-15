package com.levelup.mog.service;

import com.levelup.mog.repository.MogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MogServiceTest {

    @Autowired
    MogRepository mogRepository;


    @Test
    void getStationNames() {
        //given
        List<String> stationNames = new ArrayList<>();

        //when
        mogRepository.findAll().forEach(stationIndex -> {
                    stationNames.add(stationIndex.SubwayIdToDto().getStationName());
                }
        );
        TreeSet<String> deduplicationStationName = new TreeSet<>(stationNames);

        //then
        List<String> compareList = new ArrayList<>() {
            {
                add("군자");
                add("어린이대공원");
                add("건대입구");
                add("뚝섬 유원지");
                add("청담");
                add("강남구청");
                add("학동");
                add("논현");
                add("반포");
                add("고속버스터미널");
            }

        };

        assertThat(deduplicationStationName.containsAll(compareList));
    }

    @Test
    void getStationInfo() {
    }
}