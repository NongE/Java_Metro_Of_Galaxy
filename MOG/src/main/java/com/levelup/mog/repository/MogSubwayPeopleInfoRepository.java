package com.levelup.mog.repository;

import com.levelup.mog.database.emb.SubwayIdFkEmb;
import com.levelup.mog.database.SubwayPeopleInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MogSubwayPeopleInfoRepository extends JpaRepository<SubwayPeopleInfo, SubwayIdFkEmb> {
    SubwayPeopleInfo findBySubwayIdFkEmbLineNumberAndSubwayIdFkEmbStationNameAndDateAndTime(String line, String name, String date, Integer time);
}