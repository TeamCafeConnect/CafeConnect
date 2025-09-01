package com.yash.cafeconnect.dao;

import com.yash.cafeconnect.entity.Transaction;
import java.util.List;

/**
 * The TransactionDao interface defines the standard operations to be performed on Transaction entity.
 */
public interface TransactionDao {
    // Saves a new Transaction
    void saveTransaction(Transaction transaction);

    /**
     * Retrieves Transaction based on transactionId.
     * @param transactionId
     * @return Transaction object
     */
    Transaction getTransaction(int transactionId);

    // Update Transaction (matched by Id)
    void updateTransaction(Transaction transaction);

    // Delete Transaction by Id
    void deleteTransaction(int transactionId);

    List<Transaction> getTransactions();
}

