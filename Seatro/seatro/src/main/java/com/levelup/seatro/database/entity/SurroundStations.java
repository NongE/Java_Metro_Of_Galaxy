package com.levelup.seatro.database.entity;

import com.levelup.seatro.database.emb.SurroundStationsEmb;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "surround_stations")
public class SurroundStations {

    @EmbeddedId
    SurroundStationsEmb surroundStationsEmb;

    @Column(name = "surround_station")
    private String surroundStation;

    public SurroundStationsEmb getSurroundStationsEmb() {
        return surroundStationsEmb;
    }

    public String getSurroundStation() {
        return surroundStation;
    }

    @Override
    public String toString() {
        return "SurroundStations{" +
                "surroundStation='" + surroundStation + '\'' +
                '}';
    }
}
