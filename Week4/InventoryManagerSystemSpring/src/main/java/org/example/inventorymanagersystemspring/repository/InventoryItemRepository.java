package org.example.inventorymanagersystemspring.repository;

import models.InventoryItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InventoryItemRepository {
    private static Map<Integer, InventoryItem> itemTable = new HashMap<>();
    public void addItem(InventoryItem item) {
        if (itemTable.values().stream().anyMatch(i -> i.getSerialNumber().equals(item.getSerialNumber()))){
            throw new IllegalArgumentException(String.format("Serial number %s already in DB", item.getSerialNumber()));
        }
        itemTable.put(item.getId(), item);
    }
    public boolean deleteItemById(Integer id) {
        if (itemTable.values().stream().noneMatch(i -> i.getId() == id)){
            return false;
        }
        else {
            itemTable.remove(id);
            return true;
        }
    }

    public Optional<InventoryItem> getItemById(Integer id) {
        return Optional.ofNullable(itemTable.get(id));
    }
    public List<InventoryItem> getAllItems() {
        return itemTable.values().stream().toList();
    }
    public boolean updateItem(InventoryItem updatedItem){
        if (itemTable.values().stream().noneMatch(i -> i.getId() == updatedItem.getId())){
            return false;
        }
        else {
            itemTable.put(updatedItem.getId(), updatedItem);
            return true;
        }
    }
}
