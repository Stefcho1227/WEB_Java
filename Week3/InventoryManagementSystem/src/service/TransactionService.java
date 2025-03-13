package service;

import models.ClubMember;
import models.InventoryItem;
import models.Transaction;

import java.util.List;

public interface TransactionService {
    void borrowItem(ClubMember member, InventoryItem item, int days);
    List<Transaction> getAllTransactions();
    boolean returnItem(Integer transactionId);
    List<Transaction> getOverdueTransactions();
}