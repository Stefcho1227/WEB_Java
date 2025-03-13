package models;

import java.sql.Timestamp;

public class Transaction {
    private static int idIncrement = 1;
    private int id;
    private ClubMember member;
    private InventoryItem item;
    private Timestamp borrowedDate;
    private Timestamp dueDate;
    private Boolean returned;

    public Transaction(ClubMember member, InventoryItem item, Timestamp borrowedDate,
                       Timestamp dueDate, Boolean returned) {
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

    public Timestamp getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Timestamp borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
