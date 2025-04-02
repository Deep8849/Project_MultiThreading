package com.dip.project_multithreading.TicketBookingSystem;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReservationSystem {
    private int availableSeats;
    private final Lock lock = new ReentrantLock();

    public ReservationSystem(int totalSeats) {
        this.availableSeats = totalSeats;
    }

    public void reserveSeats(String user, int numSeats) {
        lock.lock();
        try {
            if (numSeats > 0 && numSeats <= availableSeats) {
                // Simulate the reservation process
                System.out.println(user + " is reserving " + numSeats + " seats.");

                // Update available seats
                availableSeats -= numSeats;

                // Simulate the ticket issuance
                System.out.println(user + " reserved seats successfully.");
            } else {
                System.out.println(user + " could not reserve seats. Not enough available seats.");
            }
        } finally {
            lock.unlock();
        }
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}


