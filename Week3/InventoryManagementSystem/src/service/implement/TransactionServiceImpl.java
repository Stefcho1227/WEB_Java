package service.implement;

import models.ClubMember;
import models.InventoryItem;
import models.Transaction;
import service.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    @Override
    public void borrowItem(ClubMember member, InventoryItem item, int days) {

    }

    @Override
    public List<Transaction> getAllTransactions() {
        return null;
    }

    @Override
    public boolean returnItem(Integer transactionId) {
        return false;
    }

    @Override
    public List<Transaction> getOverdueTransactions() {
        return null;
    }
}
