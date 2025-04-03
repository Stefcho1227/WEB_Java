package org.example.inventorymanagersystemspring;

import lombok.extern.slf4j.Slf4j;
import org.example.inventorymanagersystemspring.controller.InventoryController;
import org.example.inventorymanagersystemspring.models.InventoryItem;
import org.example.inventorymanagersystemspring.models.ItemCategory;
import org.example.inventorymanagersystemspring.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class InventoryManagerSystemSpringApplication {

    @Autowired
    InventoryService inventoryService;
    @Autowired
    InventoryController inventoryController;
    public static void main(String[] args) {
        SpringApplication.run(InventoryManagerSystemSpringApplication.class, args);
    }
}
