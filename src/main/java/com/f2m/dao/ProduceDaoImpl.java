package com.f2m.dao;//package com.f2m.dao;


import com.f2m.config.MvcConfiguration;
import com.f2m.model.*;
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
        String sql = "select a.id,f.name,f.Phone_no,pi.produces,unit,p.image_url,a.stock,a.min_price,m.image_url from addProduces a,FarmerDetails f,mediaDetails m,ProducesInfo pi,ProducesImage p where f.id=a.farmer_id and m.id=f.image_id and pi.id=a.produces_info_id and a.id=p.id";
        //String sql1 = "select * from addProduces";
        ps=conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        ArrayList<JSONObject> jsonArray=new ArrayList<JSONObject>();

        while (rs.next()){
            JSONObject Obj = new JSONObject();
            Obj.put("id",rs.getString("id").trim());
            Obj.put("name",rs.getString("name").trim());
            Obj.put("phone_no",rs.getString("phone_no").trim());
            Obj.put("produces",rs.getString("produces").trim());
            Obj.put("stock",rs.getString("stock").trim());
            Obj.put("unit",rs.getString("unit").trim());
            Obj.put("min_price",rs.getString("min_price").trim());
            Obj.put("image_url",rs.getString("image_url").trim());

            jsonArray.add(Obj);
        }
        return jsonArray;
    }


    @Override
    public ArrayList<JSONObject> getRequestedProduces() throws SQLException, ClassNotFoundException {
        Connection conn= null;
        PreparedStatement ps = null;
        DataSource ds;
        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();
        String sql = "select r.id,produces,status,beat_price,r.date,stock,min_price,image_url from requestProduces r,addProduces a,ProducesImage pi,ProducesInfo p where a.id=r.addProduces_id and pi.id=a.id and a.id=p.id";
        ps=conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        ArrayList<JSONObject> jsonArray=new ArrayList<JSONObject>();
        while (rs.next()){
            JSONObject Obj = new JSONObject();
            Obj.put("id",rs.getString("id").trim());
            Obj.put("produces",rs.getString("produces").trim());
            Obj.put("stock",rs.getString("stock").trim());
            Obj.put("min_price",rs.getString("min_price").trim());
            Obj.put("image_url",rs.getString("image_url").trim());
            Obj.put("beat_price",rs.getString("beat_price").trim());
            Obj.put("status",rs.getString("status").trim());
            Obj.put("date",rs.getString("date").trim());

            jsonArray.add(Obj);
        }
        return jsonArray;
    }

    @Override
    public void requestStatusUpdate(RequestStatus requestStatus) throws SQLException, ClassNotFoundException {
        Connection conn= null;
        PreparedStatement ps = null;
        DataSource ds;
        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();
        String query = "update requestProduces set status = ? where id = ? and addProduces_id= ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, requestStatus.getStatus());
        preparedStmt.setInt   (2, requestStatus.getRequestProduces_id());
        preparedStmt.setInt(3,requestStatus.getAddProduces_id() );
        preparedStmt.executeUpdate();

    }

    @Override
    public void sampleRequestStatusUpdate(RequestStatus requestStatus) throws SQLException, ClassNotFoundException {
        Connection conn= null;
        PreparedStatement ps = null;
        DataSource ds;
        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();
        String query = "update sampleRequest set status = ? where id = ? and addProduces_id= ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, requestStatus.getStatus());
        preparedStmt.setInt   (2, requestStatus.getRequestProduces_id());
        preparedStmt.setInt(3,requestStatus.getAddProduces_id() );
        preparedStmt.executeUpdate();
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
    public void sampleRequestProducesInsert(SampleRequestProduces sampleRequestProduces) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        DataSource ds;

        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();

        String mediasql = "INSERT INTO sampleRequest (id, trader_id, addProduces_id, status,date)"
                + " VALUES (?, ?, ?, ?,?)";
        ps=conn.prepareStatement(mediasql);

        ps.setInt(1, sampleRequestProduces.getId());
        ps.setInt(2, sampleRequestProduces.getTraderId());
        ps.setInt(3, sampleRequestProduces.getAddProducesId());
        ps.setString(4, sampleRequestProduces.getStatus());
        ps.setDate(5, sampleRequestProduces.getDate());
        ps.executeUpdate();
    }

    @Override
    public void insertProduces(AddProduce addProduce) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        PreparedStatement ps = null;
        DataSource ds;

        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();

        String produceInfosql ="INSERT INTO ProducesInfo (id, produces, description, unit,date)"
                + " VALUES (?, ?, ?, ?,?)";
        ps=conn.prepareStatement(produceInfosql);

        ps.setInt(1,addProduce.getProduceInfoid());
        ps.setString(2,addProduce.getProduces());
        ps.setString(3,addProduce.getDescription());
        ps.setString(4,addProduce.getUnit());
        ps.setDate(5,addProduce.getProduceInfodate());
        ps.executeUpdate();

        String addProducesql ="INSERT INTO addProduces (id, produces_info_id, farmer_id, stock,min_price,date)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        ps=conn.prepareStatement(addProducesql);

        ps.setInt(1,addProduce.getAddProduceid());
        ps.setInt(2,addProduce.getProduceInfoid());
        ps.setInt(3,addProduce.getFarmer_id());
        ps.setInt(4,addProduce.getStock());
        ps.setDouble(5,addProduce.getMin_price());
        ps.setDate(6,addProduce.getAddProducedate());
        ps.executeUpdate();

        String producesImagesql = "INSERT INTO ProducesImage (id, add_produces_id, image_url, date)"
                + " VALUES (?, ?, ?, ?)";
        ps=conn.prepareStatement(producesImagesql);

        ps.setInt(1,addProduce.getProducesImageid());
        ps.setInt(2,addProduce.getAddProduceid());
        ps.setString(3,addProduce.getImage_url());
        ps.setDate(4,addProduce.getProducesImagedate());
        ps.executeUpdate();

    }

    @Override
    public ArrayList<JSONObject> getUploadedbeatProduces() throws SQLException, ClassNotFoundException {
        Connection conn= null;
        PreparedStatement ps = null;
        DataSource ds;
        MvcConfiguration config=new MvcConfiguration();
        ds=config.getDataSource();
        conn=ds.getConnection();
//select f.name,f.phone_no,f.address,p.produces,p.unit,a.stock,a.min_price from FarmerDetails f,ProducesInfo p,addProduces a where f.id=p.id and p.id=a.id and f.id=a.id
        String sql = "select a.farmer_id,a.id,status,beat_price,r.date,image_url,min_price,produces,stock,unit from requestProduces r,addProduces a,ProducesInfo p,ProducesImage pi where farmer_id=1 and r.id=a.id and a.id=p.id and pi.id=a.id ";
        //String sql1 = "select * from addProduces";
        ps=conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        ArrayList<JSONObject> jsonArray=new ArrayList<JSONObject>();

        while (rs.next()){
            JSONObject Obj = new JSONObject();

            Obj.put("id",rs.getString("id").trim());
            Obj.put("farmer_id",rs.getString("farmer_id").trim());
            Obj.put("produces",rs.getString("produces").trim());
            Obj.put("stock",rs.getString("stock").trim());
            Obj.put("unit",rs.getString("unit").trim());
            Obj.put("min_price",rs.getString("min_price").trim());
            Obj.put("image_url",rs.getString("image_url").trim());
            Obj.put("beat_price",rs.getString("beat_price").trim());
            Obj.put("date",rs.getString("date").trim());


            jsonArray.add(Obj);
        }
        return jsonArray;
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