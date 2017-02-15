package com.f2m.dao;//package com.f2m.dao;
import com.f2m.config.MvcConfiguration;
import com.f2m.model.FarmerLogin;
import com.f2m.model.FarmerRegistration;
import com.f2m.model.TraderLogin;
import com.f2m.model.TraderRegistration;
//import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    public UserDaoImpl(){}
    @Override
    public void traderDetailsInsert(TraderRegistration registration) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement ps = null;
        DataSource ds;
//        Class.forName("com.mysql.jdbc.Driver");
//        conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/farm2market?autoReconnect=true&useSSL=false","root","aqra");


        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();


        String mediasql = "INSERT INTO mediaDetails (id, type, image_url, date)"
                + " VALUES (?, ?, ?, ?)";
        ps=conn.prepareStatement(mediasql);

        ps.setInt(1, registration.getMediaId());
        ps.setString(2, registration.getType());
        ps.setString(3, registration.getImageUrl());
        ps.setDate(4, registration.getDate());
        ps.executeUpdate();
         conn = null;
         ps = null;
         ds=null;
//        Class.forName("com.mysql.jdbc.Driver");
//        conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/farm2market?autoReconnect=true&useSSL=false","root","aqra");


        config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();

        String sql = "INSERT INTO TraderDetails (id, name, email, password, phone_no, company,address,image_id)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        ps=conn.prepareStatement(sql);

        ps.setInt(1, registration.getId());
        ps.setString(2, registration.getName());
        ps.setString(3, registration.getEmail());
        ps.setString(4, registration.getPassword());
        ps.setString(5, registration.getPhone_no());
        ps.setString(6, registration.getCompany());
        ps.setString(7, registration.getAddress());
        ps.setInt(8, registration.getMediaId());

        ps.executeUpdate();
        ps = null;

        }



    @Override
    public void farmerDetailsInsert(FarmerRegistration registration) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        DataSource ds;

        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();

        String mediasql = "INSERT INTO mediaDetails (id, type, image_url, date)"
                + " VALUES (?, ?, ?, ?)";
        ps=conn.prepareStatement(mediasql);

        ps.setInt(1, registration.getMediaId());
        ps.setString(2, registration.getType());
        ps.setString(3, registration.getImageUrl());
        ps.setDate(4, registration.getDate());
        ps.executeUpdate();

        String farmersql = "INSERT INTO FarmerDetails (id, name, Phone_no, password, address,image_id)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        ps=conn.prepareStatement(farmersql);

        ps.setInt(1, registration.getFarmerid());
        ps.setString(2, registration.getName());
        ps.setString(3, registration.getPhoneNo());
        ps.setString(4, registration.getPassword());
        ps.setString(5, registration.getAddress());
        ps.setInt(6, registration.getMediaId());

        ps.executeUpdate();

    }

    public int traderLogin(TraderLogin traderLogin) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        DataSource ds;



        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();
        String sql = "SELECT id FROM TraderDetails WHERE email = '"+traderLogin.getEmail()+"' and password = '"+traderLogin.getPassword()+"'";
        ps=conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        int i=0 ;
        if(rs.next())
            i = rs.getInt(1);
        return i;


    }

    @Override
    public int farmerLogin(FarmerLogin farmerLogin) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        DataSource ds;

        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();
        String sql = "SELECT id FROM FarmerDetails WHERE phone_no = '"+farmerLogin.getPhone_no()+"' and password = '"+farmerLogin.getPassword()+"'";
        ps=conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        int i=0 ;
        if(rs.next())
            i = rs.getInt(1);
        return i;
    }


    public static int getTraderid() throws SQLException {
            Connection conn = null;
            PreparedStatement ps = null;
            DataSource ds;

            MvcConfiguration config=new MvcConfiguration();
            ds=config.getDataSource();
            conn=ds.getConnection();
//
            String sql = "SELECT count(id) FROM TraderDetails";
            ps=conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            int i=0 ;
            if(rs.next())
                i = rs.getInt(1);
            return i;
        }

    public static int getFarmerid() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        DataSource ds;

        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();

        String sql = "SELECT count(id) FROM FarmerDetails";
        ps=conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        int i=0 ;
        if(rs.next())
            i = rs.getInt(1);
        return i;
    }

    public static int getMediaId() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        DataSource ds;

        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();

        String sql = "SELECT count(id) FROM mediaDetails";
        ps=conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        int i=0 ;
        if(rs.next())
            i = rs.getInt(1);
        return i;
    }






}