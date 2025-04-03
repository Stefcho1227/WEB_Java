package org.example.inventorymanagersystemspring.controller;

import org.example.inventorymanagersystemspring.models.Transaction;
import org.example.inventorymanagersystemspring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

}
