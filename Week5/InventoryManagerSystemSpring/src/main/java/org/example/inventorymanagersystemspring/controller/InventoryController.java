package org.example.inventorymanagersystemspring.controller;

import org.example.inventorymanagersystemspring.models.InventoryItem;
import org.example.inventorymanagersystemspring.models.ItemCategory;
import org.example.inventorymanagersystemspring.service.InventoryService;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    public void displayAllItems(){
        List<InventoryItem> items = inventoryService.getAllItems();
        if(items.isEmpty()){
            System.out.println("No items available");
        } else {
            items.stream().forEach(i -> System.out.println("Item: " + i.getName() + " Quantity: " + i.getQuantity()));
        }
    }
    public List<InventoryItem> getLowStockItems(int threshold){
        return inventoryService.getLowStockItems(threshold);
    }
    public void updateItem(Integer id, String name, String description, int quantity,
                           ItemCategory category, boolean borrowable, String serialNumber) {
        boolean done = inventoryService.updateItem(id, name, description, quantity, category, borrowable, serialNumber);
        if(done){
            System.out.println("Updated item successfully");
        } else {
            System.out.println("Item not found");
        }
    }
}
