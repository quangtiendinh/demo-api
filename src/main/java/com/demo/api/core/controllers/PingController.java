package com.demo.api.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/ping")
public class PingController {

    @GetMapping
    public String ping() {
        return "Server is running";
    }
}
