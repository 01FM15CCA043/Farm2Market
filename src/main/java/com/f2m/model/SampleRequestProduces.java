package com.f2m.model;

import java.sql.Date;

/**
 * Created by bakarali on 17/2/17.
 */
public class SampleRequestProduces {
    private int id;
    private int traderId;
    private int addProducesId;
    private String status;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTraderId() {
        return traderId;
    }

    public void setTraderId(int traderId) {
        this.traderId = traderId;
    }

    public int getAddProducesId() {
        return addProducesId;
    }

    public void setAddProducesId(int addProducesId) {
        this.addProducesId = addProducesId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
