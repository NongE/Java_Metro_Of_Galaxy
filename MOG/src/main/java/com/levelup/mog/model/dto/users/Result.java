package com.levelup.mog.model.dto.users;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("CODE")
    private String code;
    @JsonProperty("MESSAGE")
    private String message;

    public String getCODE() {
        return code;
    }

    public String getMESSAGE() {
        return message;
    }
}
