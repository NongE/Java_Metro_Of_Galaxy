package com.levelup.seatro.database.emb;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SubwayStationsEntityEmb {

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
