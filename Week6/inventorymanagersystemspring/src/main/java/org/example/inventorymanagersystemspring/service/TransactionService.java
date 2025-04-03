package org.example.inventorymanagersystemspring.service;

import org.example.inventorymanagersystemspring.models.ClubMember;
import org.example.inventorymanagersystemspring.models.InventoryItem;
import org.example.inventorymanagersystemspring.models.Transaction;

import java.util.List;

public interface TransactionService {
    void borrowItem(ClubMember member, InventoryItem item, int days);
    boolean deleteTransactionById(Integer id);
    List<Transaction> getAllTransactions();
    boolean returnItem(Integer transactionId);
    List<Transaction> getOverdueTransactions();
}