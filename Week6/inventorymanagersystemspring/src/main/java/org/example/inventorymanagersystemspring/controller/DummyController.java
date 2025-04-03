package org.example.inventorymanagersystemspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class DummyController {
    @GetMapping("/hello-world/{symbol}")
    public String getHello(@PathVariable String symbol){
        return "Hello World " + symbol;
    }
}
