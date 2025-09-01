package com.yash.cafeconnect.serviceImpl;

import com.yash.cafeconnect.entity.Transaction;
import com.yash.cafeconnect.dao.TransactionDao;
import com.yash.cafeconnect.daoImpl.TransactionDaoImpl;
import com.yash.cafeconnect.service.TransactionService;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private TransactionDao transactionDao = new TransactionDaoImpl();
    public void addTransaction(Transaction transaction) {
        if(transactionDao.getTransaction(transaction.getTransactionId()) != null){
            throw new IllegalStateException("Transaction with this Id already exists");
        }
        transactionDao.saveTransaction(transaction);
    }
    public Transaction getTransactionById(int transactionId) {
        return transactionDao.getTransaction(transactionId);
    }
    public void updateTransaction(Transaction transaction) {
        if(transactionDao.getTransaction(transaction.getTransactionId()) == null){
            throw new IllegalStateException("Transaction with this Id does not exist");
        }
        transactionDao.updateTransaction(transaction);
    }
    public void removeTransaction(int transactionId) {
        if(transactionDao.getTransaction(transactionId) == null){
            throw new IllegalStateException("Transaction with this Id does not exist");
        }
        transactionDao.deleteTransaction(transactionId);
    }
    public List<Transaction> getTransactions() {
        return transactionDao.getTransactions();
    }
}
