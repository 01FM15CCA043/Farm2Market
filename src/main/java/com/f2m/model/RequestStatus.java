package com.f2m.model;

/**
 * Created by bakarali on 26/2/17.
 */
public class RequestStatus {
    private int addProduces_id;
    private int requestProduces_id;
    private String status;

    public int getAddProduces_id() {
        return addProduces_id;
    }

    public void setAddProduces_id(int addProduces_id) {
        this.addProduces_id = addProduces_id;
    }

    public int getRequestProduces_id() {
        return requestProduces_id;
    }

    public void setRequestProduces_id(int requestProduces_id) {
        this.requestProduces_id = requestProduces_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
