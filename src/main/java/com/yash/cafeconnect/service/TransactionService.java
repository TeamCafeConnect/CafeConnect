package com.yash.cafeconnect.service;

import com.yash.cafeconnect.entity.Transaction;
import java.util.List;

/**
 * Service interface for Transaction entity.
 */
public interface TransactionService {
    // Add a new Transaction
    void addTransaction(Transaction transaction);
    // Get Transaction by Id
    Transaction getTransactionById(int transactionId);
    // Update Transaction details
    void updateTransaction(Transaction transaction);
    // Remove Transaction by Id
    void removeTransaction(int transactionId);
    // Get list of all Transactions
    List<Transaction> getTransactions();
}
