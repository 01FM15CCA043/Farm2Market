package com.f2m;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by bakarali on 11/3/17.
 */
@Controller
public class AppEntry {
    @RequestMapping("/register")
    public String register(Map<String, java.lang.Object> model) {
        return "register";
    }
}