package com.levelup.mog.database;

import com.levelup.mog.database.emb.PredictSubwayUserEmb;
import com.levelup.mog.model.dto.PredictSubwayUserDto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "predict_subway_user")
public class PredictSubwayUser {

    @EmbeddedId
    private PredictSubwayUserEmb predictSubwayUserEmb;

    @Column(name = "predict_seat")
    private Integer predictSeat;


    public PredictSubwayUserDto PredictSubwayUserToDto(){

        PredictSubwayUserDto predictDto = new PredictSubwayUserDto();
        predictDto.getPredictSubwayUserFkEmbDto().setLineNumber(predictSubwayUserEmb.getLineNumber());
        predictDto.getPredictSubwayUserFkEmbDto().setStationName(predictSubwayUserEmb.getStationName());
        predictDto.getPredictSubwayUserFkEmbDto().setDay(predictSubwayUserEmb.getDay());
        predictDto.getPredictSubwayUserFkEmbDto().setTime(predictSubwayUserEmb.getTime());

        return predictDto;

    }


    public PredictSubwayUserEmb getPredictSubwayUserFkEmb() {
        return predictSubwayUserEmb;
    }

    public Integer getPredictSeat() {
        return predictSeat;
    }
}
