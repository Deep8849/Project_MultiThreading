package com.dip.project_multithreading.TicketBookingSystem;

public class OnlineReservationSystem {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem(50);

        // Simulate multiple users trying to reserve seats concurrently
        Thread user1 = new Thread(() -> reservationSystem.reserveSeats("User1", 5));
        Thread user2 = new Thread(() -> reservationSystem.reserveSeats("User2", 10));
        Thread user3 = new Thread(() -> reservationSystem.reserveSeats("User3", 8));

        user1.start();
        user2.start();
        user3.start();

        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Remaining available seats: " + reservationSystem.getAvailableSeats());
    }
}

