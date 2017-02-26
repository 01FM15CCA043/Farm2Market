package com.f2m;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class Appenrty {
    @RequestMapping("/greeting")
    public String index() {
        return "index";
    }

}

