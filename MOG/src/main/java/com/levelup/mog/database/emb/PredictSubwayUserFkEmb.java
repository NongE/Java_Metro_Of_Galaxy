package com.levelup.mog.database.emb;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PredictSubwayUserFkEmb implements Serializable {

    @Column(name = "fk_line_number")
    private String lineNumber;

    @Column(name = "fk_station_name")
    private String stationName;

    @Column(name = "_day")
    private String day;

    @Column(name = "_time")
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
}

