package com.dip.project_multithreading.ThreadSafe_Bank_Transaction;

public class BankTransaction implements Runnable {

    private final BankAccount account;
    private final int transactionAmount;


    public BankTransaction(BankAccount account, int transactionAmount) {
        this.account = account;
        this.transactionAmount = transactionAmount;
    }


    @Override
    public void run() {
        // Simulate a bank transaction (deposit or withdrawal)
        if (transactionAmount >= 0) {
            account.deposit(transactionAmount);
        } else {
            account.withdraw(Math.abs(transactionAmount));
        }
    }

}
