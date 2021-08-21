package com.levelup.seatro.repository;

import com.levelup.seatro.database.emb.StationUsersEmb;
import com.levelup.seatro.database.entity.StationDetailUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationDetailUsersRepository extends JpaRepository<StationDetailUsers, StationUsersEmb> {
    List<StationDetailUsers> findByStationUsersEmbLineNumberAndStationUsersEmbStationNameAndStationUsersEmbCheckInTime(String lineNumber, String stationName, Integer checkInTime);
}
