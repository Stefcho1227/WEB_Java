package service.implement;

import models.InventoryItem;
import models.ItemCategory;
import repository.InventoryItemRepository;
import service.InventoryService;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
    public boolean updateItem(InventoryItem updatedItem) {
        return false;
    }
}
