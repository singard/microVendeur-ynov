package com.antiamazon.vendeur1.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.antiamazon.vendeur1.Table.NewVendeur;

import java.util.Collections;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping(value = "/home", produces = "application/json")
    public Map<String, String> get(){
        return Collections.singletonMap("message", "Bonne année");
    }
    
    @PostMapping(value = "/fill", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getVendeur(@RequestBody NewVendeur newVendeur){
    	return newVendeur.toString();
    }

}
