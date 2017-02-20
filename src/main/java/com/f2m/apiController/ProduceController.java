package com.f2m.apiController;

import com.f2m.dao.ProduceDao;
import com.f2m.dao.ProduceDaoImpl;
import com.f2m.dao.UserDaoImpl;
import com.f2m.model.RequestProduces;
import com.f2m.model.ResponseModel;
import com.f2m.model.SampleRequestProduces;
import com.f2m.model.TraderRegistration;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.f2m.dao.ProduceDaoImpl.getRequestProducesId;
import static com.f2m.dao.ProduceDaoImpl.getSampleRquestProducesId;
import static com.f2m.dao.UserDaoImpl.getMediaId;
import static com.f2m.dao.UserDaoImpl.getTraderid;

/**
 * Created by bakarali on 29/1/17.
 */
@RequestMapping("produces")
@RestController
@ResponseBody
public class ProduceController {
    @RequestMapping(path="/list",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<JSONObject> listProduce() throws SQLException,ClassNotFoundException{
        ProduceDaoImpl produceDao = new ProduceDaoImpl();
        ArrayList<JSONObject> obj;

        obj  = produceDao.getProduces();
        return obj;
    }
    @RequestMapping(path="/uploadedlist",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<JSONObject> uploadedListProduce() throws SQLException,ClassNotFoundException{
        ProduceDaoImpl produceDao = new ProduceDaoImpl();
        ArrayList<JSONObject> obj;

        obj  = produceDao.getUploadedProduces();
        return obj;
    }
    @RequestMapping(path="/request",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity RequestProduce(@RequestBody RequestProduces body) throws SQLException,ClassNotFoundException{
        RequestProduces requestProduces = new RequestProduces();
        int RequestProducesId = getRequestProducesId();
        requestProduces.setId(RequestProducesId+1);
        requestProduces.setTraderId(body.getTraderId());
        requestProduces.setAddProducesId(body.getAddProducesId());
        requestProduces.setBeatPrice(body.getBeatPrice());
        requestProduces.setStatus(body.getStatus());
        requestProduces.setDate(body.getDate());
        ProduceDaoImpl produceDao = new ProduceDaoImpl();
        produceDao.requestProducesInsert(requestProduces);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(HttpStatus.OK, "request done"));

        // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, "Password not match"));




    }
    @RequestMapping(path="/samplerequest",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sampleRequestProduce(@RequestBody SampleRequestProduces body) throws SQLException,ClassNotFoundException{
        SampleRequestProduces requestProduces = new SampleRequestProduces();
        int RequestProducesId = getSampleRquestProducesId();
        requestProduces.setId(RequestProducesId+1);
        requestProduces.setTraderId(body.getTraderId());
        requestProduces.setAddProducesId(body.getAddProducesId());
        requestProduces.setStatus(body.getStatus());
        requestProduces.setDate(body.getDate());
        ProduceDaoImpl produceDao = new ProduceDaoImpl();
        produceDao.sampleRequestProducesInsert(requestProduces);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(HttpStatus.OK, " Sample request done"));

        // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, "Password not match"));




    }

}
