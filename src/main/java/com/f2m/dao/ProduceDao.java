package com.f2m.dao;

import com.f2m.model.FarmerRegistration;
import com.f2m.model.RequestProduces;
import com.f2m.model.SampleRequestProduces;
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
    public void sampleRequestProducesInsert(SampleRequestProduces sampleRequestProducesrequestProduces) throws SQLException, ClassNotFoundException;
}
