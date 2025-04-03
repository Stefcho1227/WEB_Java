package org.example.inventorymanagersystemspring.mapper;

import org.example.inventorymanagersystemspring.dto.InventoryItemDto;
import org.example.inventorymanagersystemspring.models.InventoryItem;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InventoryItemMapper {
    public InventoryItemMapper() {
    }
    public InventoryItem fromDto(InventoryItemDto dto){
        InventoryItem item = new InventoryItem();
        item.setBorrowable(dto.getBorrowable());
        item.setCategory(dto.getCategory());
        item.setDescription(dto.getDescription());
        item.setName(dto.getName());
        item.setQuantity(dto.getQuantity());
        item.setSerialNumber(dto.getSerialNumber());
        item.setMeasurements(dto.getMeasurements());
        item.setDate(LocalDate.now());
        return item;
    }
}
