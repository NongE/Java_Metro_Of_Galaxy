package com.levelup.mog.repository;

import com.levelup.mog.database.SubwayIdEmp;
import com.levelup.mog.database.SubwayIdFkEmp;
import com.levelup.mog.database.SubwayInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MogSubwayIntoRepository extends JpaRepository<SubwayInfo, SubwayIdFkEmp> {
    List<SubwayInfo> findBySubwayIdFkEmpLineNumberAndSubwayIdFkEmpStationName(String line, String name);
}