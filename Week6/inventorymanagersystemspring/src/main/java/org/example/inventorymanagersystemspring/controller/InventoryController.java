package org.example.inventorymanagersystemspring.controller;

import org.example.inventorymanagersystemspring.dto.InventoryItemDto;
import org.example.inventorymanagersystemspring.mapper.InventoryItemMapper;
import org.example.inventorymanagersystemspring.models.InventoryItem;
import org.example.inventorymanagersystemspring.models.ItemCategory;
import org.example.inventorymanagersystemspring.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/inventory/items")
public class InventoryController {
    private final InventoryService inventoryService;
    private final InventoryItemMapper inventoryItemMapper;

    @Autowired
    public InventoryController(InventoryService inventoryService, InventoryItemMapper inventoryItemMapper) {
        this.inventoryService = inventoryService;
        this.inventoryItemMapper = inventoryItemMapper;
    }
    @GetMapping
    ResponseEntity<List<InventoryItem>> getItems(){
        return ResponseEntity.ok(inventoryService.getAllItems());
    }
    @GetMapping("/{id}")
    ResponseEntity<InventoryItem> getItemById(@PathVariable int id){
        return ResponseEntity.ok(inventoryService.getItemById(id));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> deleteItemById(@PathVariable int id){
        return ResponseEntity.ok(inventoryService.deleteItemById(id));
    }
    @PostMapping
    ResponseEntity<InventoryItem> createItem(@RequestBody InventoryItemDto dto){
        InventoryItem item = inventoryItemMapper.fromDto(dto);
        inventoryService.addItem(item.getName(), item.getDescription(), item.getQuantity(),
                item.getMeasurements(), item.getCategory(), item.getBorrowable(), item.getSerialNumber());
        return ResponseEntity.ok(item);
    }
    @PutMapping("/{id}")
    ResponseEntity<Boolean> updateItem(@PathVariable int id, @RequestBody InventoryItemDto dto){
        return ResponseEntity.ok(inventoryService.updateItem(id, dto.getName(), dto.getDescription(), dto.getQuantity(), dto.getCategory(),
                dto.getBorrowable(), dto.getSerialNumber()));
    }
}
