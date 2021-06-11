package com.levelup.mog.model;

public class SubwayIdDto {
    private String id;
    private String line;
    private String name;

    public String getId() {
        return id;
    }

    public String getLine() {
        return line;
    }

    public String getName() {
        return name;
    }

    public SubwayIdDto(String id, String line, String name) {
        this.id = id;
        this.line = line;
        this.name = name;

    }
}
