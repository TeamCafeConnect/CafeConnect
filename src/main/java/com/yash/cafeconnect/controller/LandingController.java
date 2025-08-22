package com.yash.cafeconnect.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/public")
public class LandingController {

    private static final Logger logger = LoggerFactory.getLogger(LandingController.class);

    @GetMapping("/landing")
    public String homePage() {
        System.out.println("Landing");
        logger.info("Landing page requested");
        return "Landing";
    }
}