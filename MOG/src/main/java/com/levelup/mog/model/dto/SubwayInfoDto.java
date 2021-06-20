package com.levelup.mog.model.dto;

import com.levelup.mog.model.dto.emb.SubwayInfoEmbDto;

public class SubwayInfoDto {

    private SubwayInfoEmbDto subwayInfoEmbDto;

    private String telNumber;

    private String address;

    public SubwayInfoEmbDto getSubwayInfoEmbDto() {
        return subwayInfoEmbDto;
    }

    public void setSubwayInfoEmbDto(SubwayInfoEmbDto subwayInfoEmbDto) {
        this.subwayInfoEmbDto = subwayInfoEmbDto;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
