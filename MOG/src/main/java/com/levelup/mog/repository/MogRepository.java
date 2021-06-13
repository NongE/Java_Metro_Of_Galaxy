package com.levelup.mog.repository;

import com.levelup.mog.database.SubwayId;
import com.levelup.mog.database.SubwayIdEmp;
import com.levelup.mog.database.SubwayInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MogRepository extends JpaRepository<SubwayId, SubwayIdEmp> {
    List<SubwayId> findBySubwayIdEmpStationName(String name);
}

