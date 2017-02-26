package com.f2m.model;

import java.sql.Date;

/**
 * Created by bakarali on 24/2/17.
 */
public class AddProduce {

    private int addProduceid;
    private int farmer_id;
    private int stock;
    private double min_price    ;
    private Date addProducedate;


    public int getAddProduceid() {
        return addProduceid;
    }

    public void setAddProduceid(int addProduceid) {
        this.addProduceid = addProduceid;
    }

    public int getFarmer_id() {
        return farmer_id;
    }

    public void setFarmer_id(int farmer_id) {
        this.farmer_id = farmer_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getMin_price() {
        return min_price;
    }

    public void setMin_price(double min_price) {
        this.min_price = min_price;
    }

    public Date getAddProducedate() {
        return addProducedate;
    }

    public void setAddProducedate(Date addProducedate) {
        this.addProducedate = addProducedate;
    }


    private int produceInfoid;
    private String produces;
    private String description;
    private String unit;
    private Date produceInfodate;

    public int getProduceInfoid() {
        return produceInfoid;
    }

    public void setProduceInfoid(int produceInfoid) {
        this.produceInfoid = produceInfoid;
    }

    public String getProduces() {
        return produces;
    }

    public void setProduces(String produces) {
        this.produces = produces;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getProduceInfodate() {
        return produceInfodate;
    }

    public void setProduceInfodate(Date produceInfodate) {
        this.produceInfodate = produceInfodate;
    }

    private int producesImageid;
    private String image_url;
    private Date producesImagedate;

    public int getProducesImageid() {
        return producesImageid;
    }

    public void setProducesImageid(int producesImageid) {
        this.producesImageid = producesImageid;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Date getProducesImagedate() {
        return producesImagedate;
    }

    public void setProducesImagedate(Date producesImagedate) {
        this.producesImagedate = producesImagedate;
    }
}
