package com.dip.project_multithreading.ThreadSafe_Bank_Transaction;

public class BankSimulation {

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(101, 1000);
        BankAccount account2 = new BankAccount(102, 1500);


        // Simulate concurrent bank transactions using threads
        Thread thread1 = new Thread(new BankTransaction(account1, 200));
        Thread thread2 = new Thread(new BankTransaction(account1, -300));
        Thread thread3 = new Thread(new BankTransaction(account2, 500));


        thread1.start();
        thread2.start();
        thread3.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        // Display final account balances
        System.out.println("Final balance for account " + account1.getAccountNumber() + ": Rs" + account1.getBalance());
        System.out.println("Final balance for account " + account2.getAccountNumber() + ": Rs" + account2.getBalance());
    }

}
