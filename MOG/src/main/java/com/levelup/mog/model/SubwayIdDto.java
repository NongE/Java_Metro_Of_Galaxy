package com.levelup.mog.model;

public class SubwayIdDto {
    private String line;
    private String name;

    public String getLine() {
        return line;
    }

    public String getName() {
        return name;
    }

    public SubwayIdDto(String line, String name) {
        this.line = line;
        this.name = name;
    }
}
