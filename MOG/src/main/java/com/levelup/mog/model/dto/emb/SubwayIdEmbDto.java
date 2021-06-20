package com.levelup.mog.model.dto.emb;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

public class SubwayIdEmbDto {

    private String lineNumber;

    private String stationName;

    public String getLineNumber() {
        return lineNumber;
    }

    public String getStationName() {
        return stationName;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}

