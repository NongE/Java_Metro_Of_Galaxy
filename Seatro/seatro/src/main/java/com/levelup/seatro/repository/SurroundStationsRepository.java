package com.levelup.seatro.repository;

import com.levelup.seatro.database.emb.SurroundStationsEmb;
import com.levelup.seatro.database.entity.SurroundStations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurroundStationsRepository extends JpaRepository<SurroundStations, SurroundStationsEmb> {
}
