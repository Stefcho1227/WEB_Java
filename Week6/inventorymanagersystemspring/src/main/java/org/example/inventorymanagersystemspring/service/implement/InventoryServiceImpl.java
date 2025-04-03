package org.example.inventorymanagersystemspring.service.implement;

import org.example.inventorymanagersystemspring.models.InventoryItem;
import org.example.inventorymanagersystemspring.models.ItemCategory;
import org.example.inventorymanagersystemspring.repository.InventoryItemRepository;
import org.example.inventorymanagersystemspring.service.InventoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryItemRepository inventoryItemRepository;

    public InventoryServiceImpl(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    @Override
    public List<InventoryItem> getAllItems() {
        return inventoryItemRepository.getAllItems();
    }

    @Override
    public InventoryItem getItemById(int id) {
        return inventoryItemRepository.getItemById(id).orElseThrow();
    }

    @Override
    public void addItem(String name, String description, int quantity, String unit, ItemCategory category,
                        boolean borrowable, String serialNumber) {
        InventoryItem item = new InventoryItem(name, description, quantity, unit, category, borrowable, serialNumber);
        inventoryItemRepository.addItem(item);
    }

    @Override
    public List<InventoryItem> getLowStockItems(int threshold) {
        List<InventoryItem> items = inventoryItemRepository.getAllItems();
        return items.stream().filter(i -> i.getQuantity() < threshold).collect(Collectors.toList());
    }

    @Override
    public boolean updateItem(Integer id, String name, String description, int quantity,
                              ItemCategory category, boolean borrowable, String serialNumber) {
        Optional<InventoryItem> foundItem = inventoryItemRepository.getItemById(id);
        if(foundItem.isPresent()){
            InventoryItem item = foundItem.get();
            item.setName(name);
            item.setDescription(description);
            item.setQuantity(quantity);
            item.setCategory(category);
            item.setBorrowable(borrowable);
            item.setSerialNumber(serialNumber);
            return inventoryItemRepository.updateItem(item);
        }
        return false;
    }

    @Override
    public boolean deleteItemById(Integer id) {
        return inventoryItemRepository.deleteItemById(id);
    }
}
