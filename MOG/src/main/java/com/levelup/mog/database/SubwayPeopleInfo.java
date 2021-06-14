package com.levelup.mog.database;

import com.levelup.mog.database.emb.SubwayIdFkEmb;
import com.levelup.mog.model.dto.SubwayIdDto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subway_people_info")
public class SubwayPeopleInfo {

    @EmbeddedId
    private SubwayIdFkEmb subwayIdFkEmb;

    @Column(name = "_date")
    private String date;

    @Column(name = "_time")
    private Integer time;

    @Column(name = "_people")
    private Integer people;

    public SubwayIdDto SubwayIdToDto(){
        return new SubwayIdDto(subwayIdFkEmb.getLineNumber(), subwayIdFkEmb.getStationName());
    }

    public String getDate() {
        return date;
    }

    public Integer getTime() {
        return time;
    }

    public Integer getPeople() {
        return people;
    }
}
