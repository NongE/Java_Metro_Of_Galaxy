package com.levelup.seatro.database.emb;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SurroundStationsEmb implements Serializable {

    @Column(name =  "line_number")
    private String lineNumber;

    @Column(name =  "station_name")
    private String stationName;

    @Column(name =  "direction")
    private Integer direction;

    public String getLineNumber() {
        return lineNumber;
    }

    public String getStationName() {
        return stationName;
    }

    public Integer getDirection() {
        return direction;
    }

}

