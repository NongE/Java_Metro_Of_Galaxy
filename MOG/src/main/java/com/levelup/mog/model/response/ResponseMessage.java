package com.levelup.mog.model.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResponseMessage {

    String path = null;
    String status = null;
    String result = null;
    List<?> data = null;

    public void setPath(String path) {
        this.path = path;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public String getStatus() {
        return status;
    }

    public String getResult() {
        return result;
    }

    public List<?> getData() {
        return data;
    }

}
