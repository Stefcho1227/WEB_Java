package org.example.inventorymanagersystemspring.models;

import java.time.LocalDate;

public class InventoryItem {
    private static int idIncrement = 1;
    private int id;
    private String name;
    private String description;
    private int quantity;
    private String serialNumber;
    private String measurements;
    private ItemCategory category;
    private Boolean borrowable;
    private LocalDate date;

    public InventoryItem() {
        id = idIncrement++;
    }

    public InventoryItem(String name, String description, int quantity, String measurements,
                         ItemCategory category, Boolean borrowable, String serialNumber) {
        id = idIncrement++;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.serialNumber =  serialNumber;
        this.measurements = measurements;
        this.category = category;
        this.borrowable = borrowable;
        date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMeasurements() {
        return measurements;
    }

    public void setMeasurements(String measurements) {
        this.measurements = measurements;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public Boolean getBorrowable() {
        return borrowable;
    }

    public void setBorrowable(Boolean borrowable) {
        this.borrowable = borrowable;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("InventoryItem name='" + name +
                ", description='" + description +
                ", quantity=" + quantity +
                ", serialNumber='" + serialNumber +
                ", measurements='" + measurements +
                ", category name =" + category.getName() +
                ", borrowable=" + borrowable +
                ", date=" + date);
    }
}
