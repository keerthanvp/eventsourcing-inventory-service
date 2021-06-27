package com.vpk.tutorial.inventoryservice.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class PurchaseOrderDTO implements Serializable {

    private Integer orderID;
    private Integer userID;
    private Integer productID;
    private Integer price;
}
