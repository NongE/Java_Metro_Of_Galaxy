package com.levelup.mog.repository;

import com.levelup.mog.database.PredictSubwayUser;
import com.levelup.mog.database.emb.PredictSubwayUserFkEmb;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MogPredictSubwayUserRepository extends JpaRepository<PredictSubwayUser, PredictSubwayUserFkEmb> {
    PredictSubwayUser findByPredictSubwayUserFkEmbLineNumberAndPredictSubwayUserFkEmbStationNameAndPredictSubwayUserFkEmbDayAndPredictSubwayUserFkEmbTime(String line, String name, String day, Integer time);
}