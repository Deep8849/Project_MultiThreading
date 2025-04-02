package com.dip.project_multithreading.ThreadSafe_Bank_Transaction;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class BankAccount {
    private final int accountNumber;
    private int balance;
    private final Lock lock = new ReentrantLock();


    public BankAccount(int accountNumber, int initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }


    public int getAccountNumber() {
        return accountNumber;
    }


    public int getBalance() {
        return balance;
    }


    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println("Deposited $" + amount + " to account " + accountNumber + ". New balance: $" + balance);
        } finally {
            lock.unlock();
        }
    }


    public void withdraw(int amount) {
        lock.lock();
        try {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn $" + amount + " from account " + accountNumber + ". New balance: $" + balance);
            } else {
                System.out.println("Insufficient funds for withdrawal from account " + accountNumber);
            }
        } finally {
            lock.unlock();
        }
    }

}
