package com.levelup.mog.repository;

import com.levelup.mog.database.PredictSubwayUser;
import com.levelup.mog.database.emb.PredictSubwayUserEmb;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PredictSubwayUserRepository extends JpaRepository<PredictSubwayUser, PredictSubwayUserEmb> {
    PredictSubwayUser findByPredictSubwayUserEmbLineNumberAndPredictSubwayUserEmbStationNameAndPredictSubwayUserEmbDayAndPredictSubwayUserEmbTime(String line, String name, String day, Integer time);
}