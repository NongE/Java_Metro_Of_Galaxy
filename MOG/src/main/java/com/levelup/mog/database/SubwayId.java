package com.levelup.mog.database;

import com.levelup.mog.model.SubwayIdDto;

import javax.persistence.*;

@Entity
@Table(name = "subway_id")
public class SubwayId {
    @EmbeddedId
    private SubwayIdEmp subwayIdEmp;

    public SubwayIdDto SubwayIdToDto(){

        SubwayIdDto convertDto = new SubwayIdDto(subwayIdEmp.getLineNumber(), subwayIdEmp.getStationName());

        return convertDto;
    }
}

