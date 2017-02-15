package com.f2m.dao;

import com.f2m.model.FarmerLogin;
import com.f2m.model.FarmerRegistration;
import com.f2m.model.TraderLogin;
import com.f2m.model.TraderRegistration;

import java.sql.SQLException;

/**
 * Created by bakarali on 19/1/17.
 */
public interface UserDao {
    public void traderDetailsInsert(TraderRegistration registration) throws SQLException, ClassNotFoundException;
    public void farmerDetailsInsert(FarmerRegistration registration) throws SQLException, ClassNotFoundException;
    public int traderLogin(TraderLogin traderLogin) throws SQLException, ClassNotFoundException;
    public int farmerLogin(FarmerLogin farmerLogin) throws SQLException, ClassNotFoundException;

    }
