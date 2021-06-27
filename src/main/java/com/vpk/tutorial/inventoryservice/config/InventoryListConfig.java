package com.vpk.tutorial.inventoryservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class InventoryListConfig {

    @Bean
    public Map<Integer, Integer> inventoryList(){
        Map<Integer,Integer> inventoryListMap = new HashMap<>();
        inventoryListMap.put(1,15);
        inventoryListMap.put(2,10);
        inventoryListMap.put(3,5);
        inventoryListMap.put(4,20);
        inventoryListMap.put(5,0);
        inventoryListMap.put(6,2);
        inventoryListMap.put(7,5);
        inventoryListMap.put(8,0);
        inventoryListMap.put(9,10);
        inventoryListMap.put(10,5);
        return inventoryListMap;
    }
}
