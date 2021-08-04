package com.levelup.seatro.model;

public class ResponseMessage {

    // Request path
    String path = null;

    // Request result
    String status = null;

    // Response data
    Object data = null;

    public void setPath(String path) {
        this.path = path;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public String getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }
}
