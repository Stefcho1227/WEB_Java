package org.example.inventorymanagersystemspring.service;

import org.example.inventorymanagersystemspring.models.InventoryItem;
import org.example.inventorymanagersystemspring.models.ItemCategory;

import java.util.List;
public interface InventoryService {
    List<InventoryItem> getAllItems();
    void addItem(String name, String description, int quantity, String unit, ItemCategory category,
                 boolean borrowable, String serialNumber);
    List<InventoryItem> getLowStockItems(int threshold);
    boolean updateItem(Integer id, String name, String description, int quantity,
                              ItemCategory category, boolean borrowable, String serialNumber);
    boolean deleteItemById(Integer id);
}