package com.levelup.mog.database;

import com.levelup.mog.model.SubwayIdDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SubwayId")
public class SubwayId {
    @Id
    private String id;
    private String line;
    private String name;

    public String getId() {
        return id;
    }

    public String getLine() {
        return line;
    }

    public String getName() {
        return name;
    }

    public SubwayIdDto SubwayIdToDTO(){
        SubwayIdDto dto = new SubwayIdDto(id, line, name);
        return dto;
    }


}

