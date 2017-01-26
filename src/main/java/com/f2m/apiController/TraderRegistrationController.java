package com.f2m.apiController;

import com.f2m.dao.TraderDao;
import com.f2m.dao.TraderDaoImpl;
import com.f2m.model.TraderRegistration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("/register")
@RestController
@ResponseBody
public class TraderRegistrationController {
    TraderDao traderDao ;
    @RequestMapping(path = "/trader", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TraderRegistration getRegistration(@RequestBody TraderRegistration body) throws SQLException, ClassNotFoundException {
        TraderRegistration registration = new TraderRegistration();
        registration.setName(body.getName());
        registration.setId(body.getId());
        registration.setEmail(body.getEmail());
        registration.setPassword(body.getPassword());
        registration.setPhone_no(body.getPhone_no());
        registration.setCompany(body.getCompany());
        registration.setAddress(body.getAddress());
        registration.setImage_id(body.getImage_id());
        TraderDaoImpl traderDao=new TraderDaoImpl();
        traderDao.traderDetailsInsert(registration);
        return registration;
    }



}
