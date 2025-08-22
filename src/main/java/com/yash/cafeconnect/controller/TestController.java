package com.yash.cafeconnect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "DispatcherServlet is working! Spring MVC is configured correctly.";
    }

    @GetMapping("/public/test")
    @ResponseBody
    public String publicTest() {
        return "Public endpoint working! Security config is correct.";
    }
}