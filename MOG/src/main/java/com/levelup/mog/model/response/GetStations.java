package com.levelup.mog.model.response;

public class GetStations {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GetStations(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
