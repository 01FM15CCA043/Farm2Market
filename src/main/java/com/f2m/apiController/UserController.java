package com.f2m.apiController;

import com.f2m.dao.UserDaoImpl;
import com.f2m.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

import static com.f2m.dao.UserDaoImpl.getFarmerid;
import static com.f2m.dao.UserDaoImpl.getMediaId;
import static com.f2m.dao.UserDaoImpl.getTraderid;


@RestController
@ResponseBody
public class UserController {
    @RequestMapping(path = "/register/trader", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRegistration(@RequestBody TraderRegistration body) throws SQLException, ClassNotFoundException {
        TraderRegistration registration = new TraderRegistration();
        int traderId = getTraderid();
        if (body.getPassword().equals(body.getCnfpassword())) {
            registration.setName(body.getName());
            registration.setId(traderId+1);
            registration.setEmail(body.getEmail());
            registration.setPassword(body.getPassword());
            registration.setPhone_no(body.getPhone_no());
            registration.setCompany(body.getCompany());
            registration.setAddress(body.getAddress());

            registration.setMediaId(getMediaId()+1);
            registration.setType(body.getType());
            registration.setImageUrl(body.getImageUrl());
            registration.setDate(body.getDate());

            UserDaoImpl traderDao = new UserDaoImpl();
            traderDao.traderDetailsInsert(registration);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(HttpStatus.OK, "Trader Details added"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, "Password not match"));

        }


    }

    @RequestMapping(path = "/register/farmer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRegistration(@RequestBody FarmerRegistration body) throws SQLException, ClassNotFoundException {
        FarmerRegistration registration = new FarmerRegistration();

        if (body.getPassword().equals(body.getCnfpassword())) {
            registration.setFarmerid(getFarmerid()+1);
            registration.setName(body.getName());
            registration.setPhone_no(body.getPhone_no());
            registration.setPassword(body.getPassword());
            registration.setAddress(body.getAddress());

            registration.setMediaId(getMediaId()+1);
            registration.setType(body.getType());
            registration.setImageUrl(body.getImageUrl());
            registration.setDate(body.getDate());


            UserDaoImpl farmerDao = new UserDaoImpl();
            farmerDao.farmerDetailsInsert(registration);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(HttpStatus.OK, "Farmer Details added"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, "Password not match"));

        }
    }

    @RequestMapping(path = "/signin/trader", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getlogintrader(@RequestBody TraderLogin body) throws SQLException, ClassNotFoundException{

        TraderLogin traderLogin = new TraderLogin();
        traderLogin.setEmail(body.getEmail());
        traderLogin.setPassword(body.getPassword());
        UserDaoImpl traderDao = new UserDaoImpl();
        int i = traderDao.traderLogin(traderLogin);
        System.out.print(i);
        if(i!=0){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(HttpStatus.OK, "successfully logged"));

        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid Credentials"));

        }
    }
    @RequestMapping(path = "/signin/farmer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getloginfarmer(@RequestBody FarmerLogin body) throws SQLException, ClassNotFoundException{

        FarmerLogin farmerLogin = new FarmerLogin();
        farmerLogin.setPhone_no(body.getPhone_no());
        farmerLogin.setPassword(body.getPassword());
        UserDaoImpl farmerDao = new UserDaoImpl();
        int i = farmerDao.farmerLogin(farmerLogin);
        System.out.print(i);
        if(i!=0){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel(HttpStatus.OK, "successfully logged"));

        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid Credentials"));

        }
    }
}

