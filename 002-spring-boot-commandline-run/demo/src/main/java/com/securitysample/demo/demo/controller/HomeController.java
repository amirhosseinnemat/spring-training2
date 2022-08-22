package com.securitysample.demo.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, from command line app.\n on server port" + port;
    }
}
