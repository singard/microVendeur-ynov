package com.antiamazon.vendeur1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping(value = "/home", produces = "application/json")
    public Map<String, String> get(){
        return Collections.singletonMap("message", "Bonne année");
    }

}
