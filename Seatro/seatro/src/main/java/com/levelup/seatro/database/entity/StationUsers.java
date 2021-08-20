package com.levelup.seatro.database.entity;


import com.levelup.seatro.database.emb.StationUsersEmb;
import com.levelup.seatro.database.emb.SubwayStationsEmb;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "station_users")
public class StationUsers {

    @EmbeddedId
    private StationUsersEmb stationUsersEmb;

    private Integer people;

    public StationUsersEmb getStationUsersEmb() {
        return stationUsersEmb;
    }

    public Integer getPeople() {
        return people;
    }
}
