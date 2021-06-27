package com.vpk.tutorial.inventoryservice.event_handler;

import com.vpk.tutorial.inventoryservice.events.InventoryEvent;
import com.vpk.tutorial.inventoryservice.events.OrderEvent;
import com.vpk.tutorial.inventoryservice.models.InventoryStatus;
import com.vpk.tutorial.inventoryservice.utility.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InventoryEventHandler {

    @Autowired
    private Map<Integer,Integer> inventoryListMap;

    @Autowired
    private InventoryEventPublisher inventoryEventPublisher;

    public void handler(OrderEvent orderEvent){
        Integer productID = orderEvent.getPurchaseOrderDTO().getProductID();
        InventoryEvent inventoryEvent;
        if(inventoryListMap.get(productID)>0){
            reserve(productID);
            inventoryEvent = Helper.inventoryEventBuilder(Helper.inventoryDTOBuilder(orderEvent), InventoryStatus.RESERVED);
        }else{
            inventoryEvent = Helper.inventoryEventBuilder(Helper.inventoryDTOBuilder(orderEvent), InventoryStatus.REJECTED);
        }
        inventoryEventPublisher.publish(inventoryEvent);
    }

    public void reserve(Integer productID){
        int count = inventoryListMap.get(productID);
        inventoryListMap.replace(productID, count-1);
    }

}
