package com.levelup.mog.database;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SubwayIdFkEmp implements Serializable {

    @Column(name = "fk_line_number")
    private String lineNumber;

    @Column(name = "fk_station_name")
    private String stationName;

    public String getLineNumber() {
        return lineNumber;
    }

    public String getStationName() {
        return stationName;
    }
}

