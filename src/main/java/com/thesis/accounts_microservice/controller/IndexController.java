package com.thesis.accounts_microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping(path = "/greetings")
    public String root() {
        return "Hello World";
    }
}
