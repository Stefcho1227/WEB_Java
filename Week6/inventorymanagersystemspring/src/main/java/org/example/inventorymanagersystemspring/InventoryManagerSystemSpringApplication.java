package org.example.inventorymanagersystemspring;

import lombok.extern.slf4j.Slf4j;
import org.example.inventorymanagersystemspring.controller.InventoryController;
import org.example.inventorymanagersystemspring.models.InventoryItem;
import org.example.inventorymanagersystemspring.models.ItemCategory;
import org.example.inventorymanagersystemspring.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class InventoryManagerSystemSpringApplication implements CommandLineRunner {

    @Autowired
    InventoryService inventoryService;
    @Autowired
    InventoryController inventoryController;
    public static void main(String[] args){
        SpringApplication.run(InventoryManagerSystemSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("🚀 Application started successfully!");
        ItemCategory itemCategory1 = new ItemCategory("Vehicles", "Very important car part");
        ItemCategory itemCategory2 = new ItemCategory("Accessories", "In case the old battery should be changed");
        // Add Inventory Items
        inventoryService.addItem("RC Car", "High-speed remote control car", 5, "pcs", itemCategory1, true, "S1233");
        inventoryService.addItem("Battery Pack", "Rechargeable battery", 8, "pcs", itemCategory2, false, "S1231");
    }
}
