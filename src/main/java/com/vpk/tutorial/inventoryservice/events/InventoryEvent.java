package com.vpk.tutorial.inventoryservice.events;

import com.vpk.tutorial.inventoryservice.models.InventoryDTO;
import com.vpk.tutorial.inventoryservice.models.InventoryStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class InventoryEvent implements Serializable {

    private static final long SERIAL_VERSION_UID = 101;
    private InventoryDTO inventoryDTO;
    private InventoryStatus inventoryStatus;

}
