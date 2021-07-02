package com.levelup.mog.model.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.levelup.mog.annotation.DateCheck;
import io.swagger.annotations.ApiModelProperty;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetStationInfoRequest {

    @ApiModelProperty(position = 0, example = "건대입구")
    private String stationName;

    @DateCheck
    @ApiModelProperty(position = 1, example = "202005")
    private String date;

    @ApiModelProperty(position = 2, example = "월")
    private String day;

    @ApiModelProperty(position = 3, example = "13")
    private int time;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
