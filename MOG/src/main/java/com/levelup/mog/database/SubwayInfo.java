package com.levelup.mog.database;

import com.levelup.mog.database.emb.SubwayInfoEmb;
import com.levelup.mog.model.dto.SubwayInfoDto;
import com.levelup.mog.model.dto.emb.SubwayInfoEmbDto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subway_info")
public class SubwayInfo {

    @EmbeddedId
    private SubwayInfoEmb subwayInfoEmb;

    @Column(name = "tel_number")
    private String telNumber;

    @Column(name = "address")
    private String address;

    public SubwayInfoDto SubwayInfoToDto(){

        SubwayInfoDto infoDto = new SubwayInfoDto();
        SubwayInfoEmbDto infoEmbDto = new SubwayInfoEmbDto();

        infoEmbDto.setLineNumber(subwayInfoEmb.getLineNumber());
        infoEmbDto.setStationName(subwayInfoEmb.getStationName());

        infoDto.setSubwayInfoEmbDto(infoEmbDto);
        infoDto.setTelNumber(getTelNumber());
        infoDto.setAddress(getAddress());

        return infoDto;
    }

    public SubwayInfoEmb getSubwayInfoEmb() {
        return subwayInfoEmb;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getAddress() {
        return address;
    }
}
