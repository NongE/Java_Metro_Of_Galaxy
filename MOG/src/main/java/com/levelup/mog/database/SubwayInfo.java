package com.levelup.mog.database;

import com.levelup.mog.model.SubwayIdDto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subway_info")
public class SubwayInfo {

    @EmbeddedId
    private SubwayIdFkEmp subwayIdFkEmp;

    @Column(name = "tel_number")
    private String telNumber;

    @Column(name = "address")
    private String address;

    public SubwayIdDto SubwayIdToDto(){
        return new SubwayIdDto(subwayIdFkEmp.getLineNumber(), subwayIdFkEmp.getStationName());
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getAddress() {
        return address;
    }
}
