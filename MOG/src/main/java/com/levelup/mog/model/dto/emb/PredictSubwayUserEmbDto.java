package com.levelup.mog.model.dto.emb;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PredictSubwayUserEmbDto implements Serializable {

    private String lineNumber;

    private String stationName;

    private String day;

    private Integer time;

    public String getLineNumber() {
        return lineNumber;
    }

    public String getStationName() {
        return stationName;
    }

    public String getDay() {
        return day;
    }

    public Integer getTime() {
        return time;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}

