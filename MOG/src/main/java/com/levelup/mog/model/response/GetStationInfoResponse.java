package com.levelup.mog.model.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.ArrayList;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetStationInfoResponse {
    private String line = null;
    private String telNumber = null;
    private String address = null;
    private Integer people = null;
    private List<Boolean> seatPredict = new ArrayList<>();

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public List<Boolean> getSeatPredict() {
        return seatPredict;
    }

    public void setSeatPredict(List<Boolean> seatPredict) {
        this.seatPredict = seatPredict;
    }

}
