package org.example.inventorymanagersystemspring.service.implement;

import org.example.inventorymanagersystemspring.models.ClubMember;
import org.example.inventorymanagersystemspring.models.InventoryItem;
import org.example.inventorymanagersystemspring.models.Transaction;
import org.example.inventorymanagersystemspring.repository.TransactionRepository;
import org.example.inventorymanagersystemspring.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void borrowItem(ClubMember member, InventoryItem item, int days) {
        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(days);
        Transaction transaction = new Transaction(member, item, borrowDate, dueDate, false);
        transactionRepository.addTransaction(transaction);
    }

    @Override
    public boolean deleteTransactionById(Integer id) {
        return transactionRepository.deleteTransactionById(id);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.getAllTransactions();
    }

    @Override
    public boolean returnItem(Integer transactionId) {
        return transactionRepository.getTransactionById(transactionId).map(t -> {
            t.setReturned(true);
            transactionRepository.updateTransactionById(t.getId(), t);
            return true;
        }).orElse(false);
    }

    @Override
    public List<Transaction> getOverdueTransactions() {
        return transactionRepository.getAllTransactions().stream().filter(t -> !t.getReturned()
                && t.getDueDate().isBefore(LocalDate.now())).collect(Collectors.toList());
    }
}
