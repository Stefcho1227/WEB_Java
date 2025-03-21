package org.example.inventorymanagersystemspring;

import lombok.extern.java.Log;
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
    public static void main(String[] args) {
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

        try {
            inventoryService.addItem("Battery Pack Duplicate Serial Number", "Rechargeable battery", 10, "pcs", itemCategory2, true,"S1231");
        } catch (IllegalArgumentException ex) {
            log.info(String.valueOf(ex));
        }

        log.info("---------------------------------------");
        log.info("✅ Inventory items added successfully!");
        log.info("---------------------------------------");

        // Display All Items
        log.info("📌 Displaying all inventory items:");
        inventoryController.displayAllItems();
        log.info("---------------------------------------");

        log.info("🔄 Updating 'RC Car' quantity to 8...");
        inventoryController.updateItem(1, "RC Car", "High-speed remote control car", 12, itemCategory1, true, "S1233");

        log.info("---------------------------------------");
        log.info("📌 Displaying updated inventory items:");
        inventoryController.displayAllItems();

        log.info("---------------------------------------");
        log.info("📌 Displaying all low stock items:");
        int threshold = 10;
        List<InventoryItem> lowCost = inventoryController.getLowStockItems(threshold);
        lowCost.stream().forEach(System.out::println);
        log.info("---------------------------------------");
    }
}
