package com.kodgemisi.webapps.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sedat on 26.06.2015.
 */

@Controller
public class HomeController {
    @RequestMapping("/")
    public String getHomePage() {
        return "home";
    }
}
