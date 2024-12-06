package lk.ticketsystem;

import java.util.Scanner;

public class Vendor {
    private String eventName;
    private int noOfTickets;
    private double ticketPrice;

    // Maximum ticket capacity
    private static final int MAX_TICKETS = 1500;

    // Constructor
    public Vendor() {}

    // Getters and Setters
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        if (noOfTickets >= 0 && noOfTickets <= MAX_TICKETS) {
            this.noOfTickets = noOfTickets;
        } else if (noOfTickets > MAX_TICKETS) {
            System.out.println("Number of tickets cannot exceed " + MAX_TICKETS + ".");
        } else {
            System.out.println("Number of tickets cannot be negative.");
        }
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        if (ticketPrice >= 0) {
            this.ticketPrice = ticketPrice;
        } else {
            System.out.println("Ticket price cannot be negative.");
        }
    }

    // Method to enter event details
    public void enterTicketInformation() {
        Scanner scanner = new Scanner(System.in);

        // Prompt vendor for event name
        System.out.print("Enter event name: ");
        eventName = scanner.nextLine();

        // Prompt vendor for number of tickets and validate input
        while (true) {
            System.out.print("Enter number of tickets (max " + MAX_TICKETS + "): ");
            try {
                noOfTickets = Integer.parseInt(scanner.nextLine());
                if (noOfTickets < 0) {
                    System.out.println("Number of tickets cannot be negative. Please try again.");
                } else if (noOfTickets > MAX_TICKETS) {
                    System.out.println("Number of tickets cannot exceed " + MAX_TICKETS + ". Please try again.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Prompt vendor for ticket price
        while (true) {
            System.out.print("Enter ticket price: ");
            try {
                ticketPrice = Double.parseDouble(scanner.nextLine());
                if (ticketPrice < 0) {
                    System.out.println("Ticket price cannot be negative. Please try again.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid price.");
            }
        }
    }

    // Method to display event and ticket information
    public void displayTicketInformation() {
        System.out.println("\nEvent: " + eventName);
        System.out.println("Number of Tickets: " + noOfTickets);
        System.out.println("Ticket Price: $" + ticketPrice);
    }
}


/*
package lk.ticketingsystem;

public class Vendor {
    private String eventName;
    private int totalTicketsAvailable;
    private double ticketPrice;

    // Maximum ticket capacity
    private static final int MAX_TICKETS = 1500;

    // Lock object for synchronization
    private final Object lock = new Object();

    // Constructor
    public Vendor(String eventName, int totalTicketsAvailable, double ticketPrice) {
        this.eventName = eventName;
        this.totalTicketsAvailable = totalTicketsAvailable;
        this.ticketPrice = ticketPrice;
    }

    // Producer: Adds tickets
    public void produceTickets(int ticketsToAdd) {
        synchronized (lock) {
            while (totalTicketsAvailable + ticketsToAdd > MAX_TICKETS) {
                try {
                    System.out.println("Producer waiting: cannot add tickets. Capacity exceeded.");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            totalTicketsAvailable += ticketsToAdd;
            System.out.println("Producer added " + ticketsToAdd + " tickets. Total available: " + totalTicketsAvailable);
            lock.notifyAll(); // Notify consumers
        }
    }

    // Consumer: Purchases tickets
    public void consumeTicket() {
        synchronized (lock) {
            while (totalTicketsAvailable == 0) {
                try {
                    System.out.println("Consumer waiting: tickets sold out.");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            totalTicketsAvailable--;
            System.out.println("Consumer purchased a ticket. Remaining tickets: " + totalTicketsAvailable);
            lock.notifyAll(); // Notify producers
        }
    }

    // Display event details
    public void displayEventDetails() {
        synchronized (lock) {
            System.out.println("Event: " + eventName);
            System.out.println("Ticket Price: $" + ticketPrice);
            System.out.println("Tickets Available: " + totalTicketsAvailable);
        }
    }

    // Start producer and consumer threads
    public void startVendorOperations() {
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                produceTickets(5);
                try {
                    Thread.sleep(500); // Simulate delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                consumeTicket();
                try {
                    Thread.sleep(700); // Simulate delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Consumer");

        producer.start();
        consumer.start();
    }
}
*/

