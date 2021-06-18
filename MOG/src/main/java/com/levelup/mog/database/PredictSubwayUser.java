package com.levelup.mog.database;

import com.levelup.mog.database.emb.PredictSubwayUserFkEmb;
import com.levelup.mog.database.emb.SubwayIdFkEmb;
import com.levelup.mog.model.dto.SubwayIdDto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "predict_subway_user")
public class PredictSubwayUser {

    @EmbeddedId
    private PredictSubwayUserFkEmb predictSubwayUserFkEmb;

    @Column(name = "predict_seat")
    private Integer predictSeat;

    public SubwayIdDto SubwayIdToDto(){
        return new SubwayIdDto(predictSubwayUserFkEmb.getLineNumber(), predictSubwayUserFkEmb.getStationName());
    }

    public PredictSubwayUserFkEmb getPredictSubwayUserFkEmb() {
        return predictSubwayUserFkEmb;
    }

    public Integer getPredictSeat() {
        return predictSeat;
    }
}
