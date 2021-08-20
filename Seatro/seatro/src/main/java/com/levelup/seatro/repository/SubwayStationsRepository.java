package com.levelup.seatro.repository;

import com.levelup.seatro.database.entity.SubwayStations;
import com.levelup.seatro.database.emb.SubwayStationsEmb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubwayStationsRepository extends JpaRepository<SubwayStations, SubwayStationsEmb> {
}
