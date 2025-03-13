package service.implement;

import models.InventoryItem;
import models.ItemCategory;
import repository.InventoryItemRepository;
import service.InventoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
}
