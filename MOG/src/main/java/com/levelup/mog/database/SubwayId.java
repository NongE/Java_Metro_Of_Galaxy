package com.levelup.mog.database;

import com.levelup.mog.database.emb.SubwayIdEmb;
import com.levelup.mog.model.dto.SubwayIdDto;

import javax.persistence.*;

@Entity
@Table(name = "subway_id")
public class SubwayId {
    @EmbeddedId
    private SubwayIdEmb subwayIdEmb;

    public SubwayIdDto SubwayIdToDto(){

        SubwayIdDto convertDto = new SubwayIdDto(subwayIdEmb.getLineNumber(), subwayIdEmb.getStationName());

        return convertDto;
    }
}

