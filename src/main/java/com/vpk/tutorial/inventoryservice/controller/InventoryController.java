package com.vpk.tutorial.inventoryservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping
    public ResponseEntity<String> create(){
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

}
