package com.levelup.mog.repository;

import com.levelup.mog.database.SubwayId;
import com.levelup.mog.database.emb.SubwayIdEmb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SubwayIdRepository extends JpaRepository<SubwayId, SubwayIdEmb> {
    List<SubwayId> findBySubwayIdEmbStationName(String name);
}

