package com.f2m.model;
import java.sql.Date;
/**
 * Created by bakarali on 30/1/17.
 */
public class Produces {
    private int id;
    private int produces_info_id;
    private int farmer_id;
    private int stock;
    private int produces_image_id;
    private double min_price;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduces_info_id() {
        return produces_info_id;
    }

    public void setProduces_info_id(int produces_info_id) {
        this.produces_info_id = produces_info_id;
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

    public int getProduces_image_id() {
        return produces_image_id;
    }

    public void setProduces_image_id(int produces_image_id) {
        this.produces_image_id = produces_image_id;
    }

    public double getMin_price() {
        return min_price;
    }

    public void setMin_price(double min_price) {
        this.min_price = min_price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
