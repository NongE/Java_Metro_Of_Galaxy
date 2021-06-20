package com.levelup.mog.model.dto.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CardSubwayTime {

    @JsonProperty("list_total_count")
    private Integer listTotalCount;

    @JsonProperty("RESULT")
    private Result result;

    private List<Row> row;

    public Integer getList_total_count() {
        return listTotalCount;
    }

    public Result getRESULT() {
        return result;
    }

    public List<Row> getRow() {
        return row;
    }
}