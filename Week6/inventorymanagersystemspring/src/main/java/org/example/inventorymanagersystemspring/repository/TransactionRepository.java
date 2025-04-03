package org.example.inventorymanagersystemspring.repository;

import org.example.inventorymanagersystemspring.models.Transaction;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public class TransactionRepository {
    private static Map<Integer, Transaction> itemTable = new HashMap<>();
    public void addTransaction(Transaction transaction) {
        itemTable.put(transaction.getId(), transaction);
    }
    public boolean deleteTransactionById(Integer id) {
        if (itemTable.values().stream().noneMatch(i -> i.getId() == id)){
            return false;
        }
        else {
            itemTable.remove(id);
            return true;
        }
    }

    public Optional<Transaction> getTransactionById(Integer id) {
        return Optional.ofNullable(itemTable.get(id));
    }
    public List<Transaction> getAllTransactions() {
        return itemTable.values().stream().toList();
    }
    public Transaction updateTransactionById(Integer id, Transaction updatedTransaction){
        if (itemTable.values().stream().noneMatch(i -> i.getId() == id)){
            throw new IllegalArgumentException(String.format("Transaction with id %s not found in DB", id));
        }
        return itemTable.put(id, updatedTransaction);
    }
}
