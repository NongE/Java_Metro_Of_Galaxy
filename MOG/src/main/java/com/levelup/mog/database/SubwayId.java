package com.levelup.mog.database;

import com.levelup.mog.database.emb.SubwayIdEmb;
import com.levelup.mog.model.dto.SubwayIdDto;
import com.levelup.mog.model.dto.SubwayInfoDto;
import com.levelup.mog.model.dto.emb.SubwayIdEmbDto;

import javax.persistence.*;

@Entity
@Table(name = "subway_id")
public class SubwayId {
    @EmbeddedId
    private SubwayIdEmb subwayIdEmb;

    public SubwayIdDto SubwayIdToDto(){

        SubwayIdDto idDto = new SubwayIdDto();
        SubwayIdEmbDto idEmbDto = new SubwayIdEmbDto();

        idEmbDto.setLineNumber(subwayIdEmb.getLineNumber());
        idEmbDto.setStationName(subwayIdEmb.getStationName());

        idDto.setSubwayIdEmbDto(idEmbDto);

        return idDto;

    }

    public SubwayIdEmb getSubwayIdEmb() {
        return subwayIdEmb;
    }
}

