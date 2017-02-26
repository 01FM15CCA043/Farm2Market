package com.f2m.dao;

import com.f2m.model.*;
import net.minidev.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by bakarali on 19/1/17.
 */
public interface ProduceDao {
    public ArrayList<JSONObject> getProduces() throws SQLException, ClassNotFoundException;
    public void requestProducesInsert(RequestProduces requestProduces) throws SQLException, ClassNotFoundException;
    public void sampleRequestProducesInsert(SampleRequestProduces sampleRequestProduces) throws SQLException, ClassNotFoundException;
    public void insertProduces(AddProduce addProduce) throws SQLException, ClassNotFoundException;
    public ArrayList<JSONObject> getUploadedbeatProduces() throws SQLException, ClassNotFoundException;
    public ArrayList<JSONObject> getRequestedProduces() throws SQLException, ClassNotFoundException;
    public void requestStatusUpdate(RequestStatus requestStatus) throws SQLException, ClassNotFoundException;
    public void sampleRequestStatusUpdate(RequestStatus requestStatus) throws SQLException, ClassNotFoundException;

    }
