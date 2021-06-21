package com.levelup.mog.database;

import com.levelup.mog.database.emb.PredictSubwayUserEmb;
import com.levelup.mog.model.dto.PredictSubwayUserDto;
import com.levelup.mog.model.dto.emb.PredictSubwayUserEmbDto;

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

        PredictSubwayUserDto predictSubwayUserDto = new PredictSubwayUserDto();
        PredictSubwayUserEmbDto predictSubwayUserEmbDto = new PredictSubwayUserEmbDto();

        predictSubwayUserEmbDto.setLineNumber(predictSubwayUserEmb.getLineNumber());
        predictSubwayUserEmbDto.setStationName(predictSubwayUserEmb.getStationName());
        predictSubwayUserEmbDto.setDay(predictSubwayUserEmb.getDay());
        predictSubwayUserEmbDto.setTime(predictSubwayUserEmb.getTime());

        predictSubwayUserDto.setPredictSubwayUserFkEmbDto(predictSubwayUserEmbDto);
        predictSubwayUserDto.setPredictSeat(predictSeat);

        return predictSubwayUserDto;

    }


    public PredictSubwayUserEmb getPredictSubwayUserFkEmb() {
        return predictSubwayUserEmb;
    }

    public Integer getPredictSeat() {
        return predictSeat;
    }
}
