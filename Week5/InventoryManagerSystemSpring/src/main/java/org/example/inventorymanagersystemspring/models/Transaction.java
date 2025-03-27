package org.example.inventorymanagersystemspring.models;

import java.time.LocalDate;

public class Transaction {
    private static int idIncrement = 1;
    private int id;
    private ClubMember member;
    private InventoryItem item;
    private LocalDate borrowedDate;
    private LocalDate dueDate;
    private Boolean returned;

    public Transaction(ClubMember member, InventoryItem item, LocalDate borrowedDate,
                       LocalDate dueDate, Boolean returned) {
        id = idIncrement++;
        this.member = member;
        this.item = item;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.returned = returned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClubMember getMember() {
        return member;
    }

    public void setMember(ClubMember member) {
        this.member = member;
    }

    public InventoryItem getItem() {
        return item;
    }

    public void setItem(InventoryItem item) {
        this.item = item;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
