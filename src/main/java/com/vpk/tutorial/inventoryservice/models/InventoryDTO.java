package com.vpk.tutorial.inventoryservice.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class InventoryDTO implements Serializable {

    private Integer orderID;
    private Integer productID;
}
