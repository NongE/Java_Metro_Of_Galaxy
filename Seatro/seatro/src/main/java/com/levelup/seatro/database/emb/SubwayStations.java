package com.levelup.seatro.database.emb;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subway_stations")
public class SubwayStations {
    @EmbeddedId
    private SubwayStationsEntityEmb subwayStationsEntityEmb;

}
