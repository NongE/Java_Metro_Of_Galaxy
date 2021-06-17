package com.levelup.mog.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubwayUser {

    @JsonProperty("CardSubwayTime")
    CardSubwayTime cardSubwayTime;

    public CardSubwayTime getCardSubwayTime() {
        return cardSubwayTime;
    }

}