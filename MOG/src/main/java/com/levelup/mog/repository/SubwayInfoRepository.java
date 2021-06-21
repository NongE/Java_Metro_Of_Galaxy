package com.levelup.mog.repository;

import com.levelup.mog.database.SubwayInfo;
import com.levelup.mog.database.emb.SubwayInfoEmb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubwayInfoRepository extends JpaRepository<SubwayInfo, SubwayInfoEmb> {
    SubwayInfo findBySubwayInfoEmbLineNumberAndSubwayInfoEmbStationName(String line, String name);
}