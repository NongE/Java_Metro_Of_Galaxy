package com.levelup.seatro.database.entity;

import com.levelup.seatro.database.emb.SubwayStationsEmb;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subway_stations")
public class SubwayStations {

    // PK를 Embeddable 형식으로 선언
    @EmbeddedId
    private SubwayStationsEmb subwayStationsEmb;

    public SubwayStationsEmb getSubwayStationsEntityEmb() {
        return subwayStationsEmb;
    }
}
