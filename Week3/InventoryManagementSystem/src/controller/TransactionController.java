package controller;

import models.Transaction;
import service.TransactionService;

import java.util.List;

public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    public void displayTransactions(){
        List<Transaction> transactions = transactionService.getAllTransactions();
        if(transactions.isEmpty()){
            System.out.println("No transactions available");
        } else {
            transactions.stream().forEach(t -> System.out.println("Transaction with id: " + t.getId() +
                    " Borrowed: " + t.getBorrowedDate() + "Returned: " + t.getReturned()));
        }
    }
    public void returnItem(Integer transactionId){
        boolean returned = transactionService.returnItem(transactionId);
        if(returned){
            System.out.println("Item was returned");
        } else{
            System.out.println("Item was not returned");
        }
    }

    public List<Transaction> getOverdueTransactions(){
        return transactionService.getOverdueTransactions();
    }
}
