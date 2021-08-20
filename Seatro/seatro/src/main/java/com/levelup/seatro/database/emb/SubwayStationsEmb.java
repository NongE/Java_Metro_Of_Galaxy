package com.levelup.seatro.database.emb;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SubwayStationsEmb implements Serializable {

    @Column(name =  "line_number")
    private String lineNumber;

    @Column(name =  "station_name")
    private String stationName;

    public String getLineNumber() {
        return lineNumber;
    }

    public String getStationName() {
        return stationName;
    }
}
