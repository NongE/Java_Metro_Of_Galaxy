package com.levelup.mog.repository;

import com.levelup.mog.database.SubwayId;
import com.levelup.mog.model.response.GetStationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MogRepository extends JpaRepository<SubwayId, String> {
    Optional<List<GetStationResponse>> findByLine(String name);
}
