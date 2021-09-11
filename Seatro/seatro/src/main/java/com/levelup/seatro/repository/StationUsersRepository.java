package com.levelup.seatro.repository;

import com.levelup.seatro.database.emb.StationUsersEmb;
import com.levelup.seatro.database.entity.StationUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.OrderBy;
import java.util.List;
import java.util.Optional;

public interface StationUsersRepository extends JpaRepository<StationUsers, StationUsersEmb> {

    List<StationUsers> findByStationUsersEmbCheckInTimeOrderByPeopleDesc(Integer time);

}
