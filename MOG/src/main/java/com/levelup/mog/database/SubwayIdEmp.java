package com.levelup.mog.database;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class SubwayIdEmp implements Serializable {

    @Column(name = "line_number")
    private String lineNumber;

    @Column(name = "station_name")
    private String stationName;

    public String getLineNumber() {
        return lineNumber;
    }

    public String getStationName() {
        return stationName;
    }
}

