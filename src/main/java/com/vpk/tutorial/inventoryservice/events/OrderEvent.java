package com.vpk.tutorial.inventoryservice.events;

import com.vpk.tutorial.inventoryservice.models.OrderStatus;
import com.vpk.tutorial.inventoryservice.models.PurchaseOrderDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderEvent implements Serializable {

    private static final long SERIAL_VERSION_UID = 101;
    private PurchaseOrderDTO purchaseOrderDTO;
    private OrderStatus orderStatus;
}
