package com.kodgemisi.webapps.inventory.controller;

import com.kodgemisi.webapps.inventory.domain.User;
import com.kodgemisi.webapps.inventory.service.UserService;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sedat on 26.06.2015.
 */

@Controller
public class HomeController {
    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public ModelAndView getHomePage() {
        Map<String, Object> model = new HashMap<String, Object>();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByUsername(username);
        return new ModelAndView("home", "user", user);
    }
}
