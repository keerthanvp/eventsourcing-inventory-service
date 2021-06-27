package com.vpk.tutorial.inventoryservice.utility;

import com.vpk.tutorial.inventoryservice.events.InventoryEvent;
import com.vpk.tutorial.inventoryservice.events.OrderEvent;
import com.vpk.tutorial.inventoryservice.models.InventoryDTO;
import com.vpk.tutorial.inventoryservice.models.InventoryStatus;

public class Helper {

    public static InventoryDTO inventoryDTOBuilder(OrderEvent orderEvent){
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setOrderID(orderEvent.getPurchaseOrderDTO().getOrderID());
        inventoryDTO.setProductID(orderEvent.getPurchaseOrderDTO().getProductID());
        return inventoryDTO;
    }

    public static InventoryEvent inventoryEventBuilder(InventoryDTO inventoryDTO, InventoryStatus inventoryStatus){
        InventoryEvent inventoryEvent = new InventoryEvent();
        inventoryEvent.setInventoryDTO(inventoryDTO);
        inventoryEvent.setInventoryStatus(inventoryStatus);
        return inventoryEvent;
    }
}
