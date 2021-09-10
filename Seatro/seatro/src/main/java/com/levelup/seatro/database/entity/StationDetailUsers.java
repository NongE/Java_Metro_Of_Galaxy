package com.levelup.seatro.database.entity;

import com.levelup.seatro.database.emb.StationUsersEmb;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "station_detail_users")
public class StationDetailUsers {

    @EmbeddedId
    private StationUsersEmb stationUsersEmb;

    @Column(name =  "cabin_1")
    private Integer cabin1;

    @Column(name =  "cabin_2")
    private Integer cabin2;

    @Column(name =  "cabin_3")
    private Integer cabin3;

    @Column(name =  "cabin_4")
    private Integer cabin4;

    @Column(name =  "cabin_5")
    private Integer cabin5;

    @Column(name =  "cabin_6")
    private Integer cabin6;

    @Column(name =  "cabin_7")
    private Integer cabin7;

    @Column(name =  "cabin_8")
    private Integer cabin8;


    public StationUsersEmb getStationUsersEmb() {
        return stationUsersEmb;
    }

    public Integer getCabin1() {
        return cabin1;
    }

    public Integer getCabin2() {
        return cabin2;
    }

    public Integer getCabin3() {
        return cabin3;
    }

    public Integer getCabin4() {
        return cabin4;
    }

    public Integer getCabin5() {
        return cabin5;
    }

    public Integer getCabin6() {
        return cabin6;
    }

    public Integer getCabin7() {
        return cabin7;
    }

    public Integer getCabin8() {
        return cabin8;
    }

    public List<Integer> getAllCabin(){

        List<Integer> result = new ArrayList<>();
        result.add(getCabin1());
        result.add(getCabin2());
        result.add(getCabin3());
        result.add(getCabin4());
        result.add(getCabin5());
        result.add(getCabin6());
        result.add(getCabin7());
        result.add(getCabin8());

        return result;

    }
}
