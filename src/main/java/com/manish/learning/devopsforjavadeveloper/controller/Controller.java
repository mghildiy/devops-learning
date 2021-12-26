package com.manish.learning.devopsforjavadeveloper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Controller {

    @GetMapping("/v1/greet")
    public String helloDocker() {
        return "Hello Docker";
    }
}
