import controller.InventoryController;
import models.InventoryItem;
import models.ItemCategory;
import repository.InventoryItemRepository;
import service.InventoryService;
import service.implement.InventoryServiceImpl;
import service.implement.TransactionServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InventoryItemRepository itemRepository = new InventoryItemRepository();
        InventoryServiceImpl inventoryService = new InventoryServiceImpl(itemRepository);
        InventoryController inventoryController = new InventoryController(inventoryService);
        ItemCategory itemCategory1 = new ItemCategory("Vehicles", "Very important car part");
        ItemCategory itemCategory2 = new ItemCategory("Accessories", "In case the old battery should be changed");

        inventoryService.addItem("RC Car", "High-speed remote control car", 5, "pcs", itemCategory1, true, "S1233");
        inventoryService.addItem("Battery Pack", "Rechargeable battery", 8, "pcs", itemCategory2, false, "S1231");
        try {
            inventoryService.addItem("Battery Pack Duplicate Serial Number", "Rechargeable battery", 10, "pcs", itemCategory2, true,"S1231");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
        inventoryController.displayItems();
        inventoryController.updateItem(1, "RC Car", "High-speed remote control car", 8, itemCategory1, true, "S1233");
        int threshold = 10;
        List<InventoryItem> lowCost = inventoryController.getLowStockItems(threshold);
        lowCost.forEach(System.out::println);

    }
}
