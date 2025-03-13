package service;

import models.InventoryItem;
import models.ItemCategory;

import java.util.List;

public interface InventoryService {
    List<InventoryItem> getAllItems();
    void addItem(String name, String description, int quantity, String unit, ItemCategory category,
                 boolean borrowable, String serialNumber);
    List<InventoryItem> getLowStockItems(int threshold);
    public boolean updateItem(InventoryItem updatedItem);
}