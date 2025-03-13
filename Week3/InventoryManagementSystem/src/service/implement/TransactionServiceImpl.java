package service.implement;

import models.ClubMember;
import models.InventoryItem;
import models.Transaction;
import repository.TransactionRepository;
import service.TransactionService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
