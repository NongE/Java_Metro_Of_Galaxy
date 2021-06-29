package com.levelup.mog.model.dto;

import com.levelup.mog.model.dto.emb.PredictSubwayUserEmbDto;

public class PredictSubwayUserDto {

    private PredictSubwayUserEmbDto predictSubwayUserEmbDto;

    private Boolean predictSeat;

    public PredictSubwayUserEmbDto getPredictSubwayUserFkEmbDto() {
        return predictSubwayUserEmbDto;
    }

    public void setPredictSubwayUserFkEmbDto(PredictSubwayUserEmbDto predictSubwayUserEmbDto) {
        this.predictSubwayUserEmbDto = predictSubwayUserEmbDto;
    }

    public Boolean getPredictSeat() {
        return predictSeat;
    }

    public void setPredictSeat(Boolean predictSeat) {
        this.predictSeat = predictSeat;
    }
}
