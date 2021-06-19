package com.levelup.mog.service;

import com.levelup.mog.database.SubwayId;
import com.levelup.mog.repository.MogRepository;
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
    MogRepository mogRepository;

    @Test
    void getStationNamesTest() {
        //given
        List<String> stationNames = new ArrayList<>();
        mogRepository.findAll().forEach(stationIndex -> {
                    stationNames.add(stationIndex.SubwayIdToDto().getStationName());
                }
        );

        //when
        TreeSet<String> deduplicationStationName = new TreeSet<>(stationNames);

        //then
        assertThat(deduplicationStationName.size() == 10);
    }

    @Test
    void getAllStationLinesTest() {
        //given
        List<String> getLines1 = new ArrayList<>();
        List<String> getLines2 = new ArrayList<>();
        List<String> getLines3 = new ArrayList<>();

        // have 2 lines over
        List<SubwayId> exampleLines1 = mogRepository.findBySubwayIdEmbStationName("건대입구");
        // have 1 line
        List<SubwayId> exampleLines2 = mogRepository.findBySubwayIdEmbStationName("어린이대공원");
        // not have
        List<SubwayId> exampleLines3 = mogRepository.findBySubwayIdEmbStationName("Temp");

        //when
        exampleLines1.forEach(subwayId -> {
            getLines1.add(subwayId.SubwayIdToDto().getLineNumber());
        });
        exampleLines2.forEach(subwayId -> {
            getLines2.add(subwayId.SubwayIdToDto().getLineNumber());
        });
        exampleLines3.forEach(subwayId -> {
            getLines3.add(subwayId.SubwayIdToDto().getLineNumber());
        });

        //then
        assertThat(getLines1.containsAll(new ArrayList<String>(Arrays.asList("2호선", "7호선"))));
        assertThat(getLines2.containsAll(new ArrayList<String>(Arrays.asList("7호선"))));
        assertThat(getLines3.size() == 0);

    }

    @Test
    void getStationInfo(){

    }
}