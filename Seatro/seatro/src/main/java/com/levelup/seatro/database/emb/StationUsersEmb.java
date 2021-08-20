package com.levelup.seatro.database.emb;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StationUsersEmb implements Serializable {
    @Column(name =  "line_number")
    private String lineNumber;

    @Column(name =  "station_name")
    private String stationName;

    @Column(name =  "direction")
    private String direction;

    @Column(name =  "check_in_time")
    private Integer checkInTime;

    public String getLineNumber() {
        return lineNumber;
    }

    public String getStationName() {
        return stationName;
    }

    public String getDirection() {
        return direction;
    }

    public Integer getCheckInTime() {
        return checkInTime;
    }
}