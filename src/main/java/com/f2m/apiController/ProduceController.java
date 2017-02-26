package com.f2m.apiController;

import com.f2m.dao.ProduceDaoImpl;
import com.f2m.model.*;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

import static com.f2m.dao.ProduceDaoImpl.getRequestProducesId;
import static com.f2m.dao.ProduceDaoImpl.getSampleRquestProducesId;

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

        obj  = produceDao.getUploadedbeatProduces();
        return obj;
    }
    @RequestMapping(path="/requestedlist",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<JSONObject> requesterListProduce() throws SQLException,ClassNotFoundException{
        ProduceDaoImpl produceDao = new ProduceDaoImpl();
        ArrayList<JSONObject> obj;

        obj  = produceDao.getRequestedProduces();
        return obj;
    }
    @RequestMapping(path="/requeststatus",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity requeststatus(@RequestBody RequestStatus body) throws SQLException,ClassNotFoundException{
        RequestStatus requestStatus = new RequestStatus();
        requestStatus.setAddProduces_id(body.getAddProduces_id());
        requestStatus.setRequestProduces_id(body.getRequestProduces_id());
        requestStatus.setStatus(body.getStatus());
        ProduceDaoImpl produceDao = new ProduceDaoImpl();
        produceDao.requestStatusUpdate(requestStatus);
        if(body.getStatus().equals("Approved")) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(HttpStatus.OK, "Request Approved"));
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(HttpStatus.OK, "Request Decline"));

        }
        // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, "Password not match"));
    }
    @RequestMapping(path="/samplerequeststatus",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity samplerequeststatus(@RequestBody RequestStatus body) throws SQLException,ClassNotFoundException{
        RequestStatus requestStatus = new RequestStatus();
        requestStatus.setAddProduces_id(body.getAddProduces_id());
        requestStatus.setRequestProduces_id(body.getRequestProduces_id());
        requestStatus.setStatus(body.getStatus());
        ProduceDaoImpl produceDao = new ProduceDaoImpl();
        produceDao.sampleRequestStatusUpdate(requestStatus);

        if(body.getStatus().equals("Approved")) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(HttpStatus.OK, "sample request Approved"));
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(HttpStatus.OK, "sample request Decline"));

        }

        // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, "Password not match"));
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

    @RequestMapping(path="/addproduces",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addproduces(@RequestBody AddProduce bodyAddProduce) throws SQLException,ClassNotFoundException{
        ProduceInfo produceInfo = new ProduceInfo();
        AddProduce addProduce = new AddProduce();
        ProducesImage producesImage = new ProducesImage();

        addProduce.setProduceInfoid(bodyAddProduce.getProduceInfoid());
        addProduce.setProduces(bodyAddProduce.getProduces());
        addProduce.setDescription(bodyAddProduce.getDescription());
        addProduce.setUnit(bodyAddProduce.getUnit());
        addProduce.setProduceInfodate(bodyAddProduce.getProduceInfodate());

        addProduce.setAddProduceid(bodyAddProduce.getAddProduceid());
        addProduce.setFarmer_id(bodyAddProduce.getFarmer_id());
        addProduce.setStock(bodyAddProduce.getStock());
        addProduce.setMin_price(bodyAddProduce.getMin_price());
        addProduce.setAddProducedate(bodyAddProduce.getAddProducedate());

        addProduce.setProducesImageid(bodyAddProduce.getProducesImageid());
        addProduce.setImage_url(bodyAddProduce.getImage_url());
        addProduce.setProducesImagedate(bodyAddProduce.getProducesImagedate());

        ProduceDaoImpl produceDao = new ProduceDaoImpl();
        produceDao.insertProduces(addProduce);


        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(HttpStatus.OK, " produce added successfully "));

        // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, "Password not match"));




    }

}
