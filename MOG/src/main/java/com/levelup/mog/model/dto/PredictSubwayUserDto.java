package com.levelup.mog.model.dto;

import com.levelup.mog.model.dto.emb.PredictSubwayUserEmbDto;

public class PredictSubwayUserDto {

    private PredictSubwayUserEmbDto predictSubwayUserEmbDto;

    private Integer predictSeat;

    public PredictSubwayUserEmbDto getPredictSubwayUserFkEmbDto() {
        return predictSubwayUserEmbDto;
    }

    public void setPredictSubwayUserFkEmbDto(PredictSubwayUserEmbDto predictSubwayUserEmbDto) {
        this.predictSubwayUserEmbDto = predictSubwayUserEmbDto;
    }

    public Integer getPredictSeat() {
        return predictSeat;
    }

    public void setPredictSeat(Integer predictSeat) {
        this.predictSeat = predictSeat;
    }
}
