package com.levelup.seatro.repository;

import com.levelup.seatro.database.emb.SubwayStations;
import com.levelup.seatro.database.emb.SubwayStationsEntityEmb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubwayStationsRepository extends JpaRepository<SubwayStations, SubwayStationsEntityEmb> {
}
