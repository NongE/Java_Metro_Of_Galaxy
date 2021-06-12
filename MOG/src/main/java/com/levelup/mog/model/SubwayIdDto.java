package com.levelup.mog.model;

public class SubwayIdDto {

    private String lineNumber;
    private String stationName;

    public SubwayIdDto(String lineNumber, String stationName) {
        this.lineNumber = lineNumber;
        this.stationName = stationName;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
