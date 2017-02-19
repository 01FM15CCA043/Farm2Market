package com.f2m.dao;//package com.f2m.dao;


import com.f2m.config.MvcConfiguration;
import com.f2m.model.RequestProduces;
import com.f2m.model.SampleRequestProduces;
import net.minidev.json.JSONObject;


import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class ProduceDaoImpl implements ProduceDao {
    public ProduceDaoImpl(){

    }

    @Override
    public ArrayList<JSONObject> getProduces() throws SQLException, ClassNotFoundException {
        Connection conn= null;
        PreparedStatement ps = null;
        DataSource ds;
        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();
//select f.name,f.phone_no,f.address,p.produces,p.unit,a.stock,a.min_price from FarmerDetails f,ProducesInfo p,addProduces a where f.id=p.id and p.id=a.id and f.id=a.id
        String sql = "select f.name,f.phone_no,f.address,p.produces,p.unit,a.stock,a.min_price from FarmerDetails f,ProducesInfo p,addProduces a where f.id=p.id and p.id=a.id and f.id=a.id";
        //String sql1 = "select * from addProduces";
        ps=conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        ArrayList<JSONObject> jsonArray=new ArrayList<JSONObject>();

        while (rs.next()){
            JSONObject Obj = new JSONObject();
            Obj.put("name",rs.getString("name").trim());
            Obj.put("phone_no",rs.getString("phone_no").trim());
            Obj.put("address",rs.getString("address").trim());
            Obj.put("produces",rs.getString("produces").trim());
            Obj.put("stock",rs.getString("stock").trim());
            Obj.put("unit",rs.getString("unit").trim());
            Obj.put("min_price",rs.getString("min_price").trim());
            jsonArray.add(Obj);
        }
        return jsonArray;
    }



    @Override
    public void requestProducesInsert(RequestProduces requestProduces) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        DataSource ds;

        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();

        String mediasql = "INSERT INTO requestProduces (id, trader_id, addProduces_id, status,beat_price,date)"
                + " VALUES (?, ?, ?, ?,?,?)";
        ps=conn.prepareStatement(mediasql);

        ps.setInt(1, requestProduces.getId());
        ps.setInt(2, requestProduces.getTraderId());
        ps.setInt(3, requestProduces.getAddProducesId());
        ps.setString(4, requestProduces.getStatus());
        ps.setDouble(5, requestProduces.getBeatPrice());
        ps.setDate(6, requestProduces.getDate());
        ps.executeUpdate();

    }

    @Override
    public void sampleRequestProducesInsert(SampleRequestProduces sampleRequestProducesrequestProduces) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        DataSource ds;

        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();

        String mediasql = "INSERT INTO sampleRequest (id, trader_id, addProduces_id, status,date)"
                + " VALUES (?, ?, ?, ?,?)";
        ps=conn.prepareStatement(mediasql);

        ps.setInt(1, sampleRequestProducesrequestProduces.getId());
        ps.setInt(2, sampleRequestProducesrequestProduces.getTraderId());
        ps.setInt(3, sampleRequestProducesrequestProduces.getAddProducesId());
        ps.setString(4, sampleRequestProducesrequestProduces.getStatus());
        ps.setDate(5, sampleRequestProducesrequestProduces.getDate());
        ps.executeUpdate();
    }

    public static int getRequestProducesId() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        DataSource ds;

        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();

        String sql = "SELECT count(id) FROM requestProduces";
        ps=conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        int i=0 ;
        if(rs.next())
            i = rs.getInt(1);
        return i;
    }

    public static int getSampleRquestProducesId() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        DataSource ds;

        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();

        String sql = "SELECT count(id) FROM sampleRequest";
        ps=conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        int i=0 ;
        if(rs.next())
            i = rs.getInt(1);
        return i;
    }
}