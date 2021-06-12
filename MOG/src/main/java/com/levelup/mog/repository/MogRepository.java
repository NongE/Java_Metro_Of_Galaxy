package com.levelup.mog.repository;

import com.levelup.mog.database.SubwayId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MogRepository extends JpaRepository<SubwayId, String> {
}
