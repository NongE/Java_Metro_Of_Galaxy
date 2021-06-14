package com.levelup.mog.repository;

import com.levelup.mog.database.emb.SubwayIdFkEmb;
import com.levelup.mog.database.SubwayInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MogSubwayInfoRepository extends JpaRepository<SubwayInfo, SubwayIdFkEmb> {
    SubwayInfo findBySubwayIdFkEmbLineNumberAndSubwayIdFkEmbStationName(String line, String name);
}