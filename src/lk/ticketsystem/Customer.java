package lk.ticketsystem;

import java.util.Scanner;

public class Customer {
    private String name;
    private String contactInfo;
    private int ticketsToPurchase;
    private double totalCost;

    // Constructor
    public Customer() {}

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getTicketsToPurchase() {
        return ticketsToPurchase;
    }

    public void setTicketsToPurchase(int ticketsToPurchase) {
        this.ticketsToPurchase = ticketsToPurchase;
    }

    public double getTotalCost() {
        return totalCost;
    }

    // Method for customer to enter their details and purchase tickets
    public void enterCustomerDetailsAndPurchaseTickets(Vendor vendor) {
        Scanner scanner = new Scanner(System.in);

        // Get customer name
        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        // Get customer contact info
        System.out.print("Enter your contact information: ");
        contactInfo = scanner.nextLine();

        // Display vendor event details
        System.out.println("\nEvent: " + vendor.getEventName());
        System.out.println("Ticket Price: $" + vendor.getTicketPrice());
        System.out.println("Available Tickets: " + vendor.getNoOfTickets());

        // Get the number of tickets the customer wants to purchase
        while (true) {
            System.out.print("Enter the number of tickets you wish to purchase: ");
            try {
                ticketsToPurchase = Integer.parseInt(scanner.nextLine());

                // Check if the requested number of tickets is valid
                if (ticketsToPurchase <= 0) {
                    System.out.println("The number of tickets must be greater than zero.");
                } else if (ticketsToPurchase > vendor.getNoOfTickets()) {
                    System.out.println("Not enough tickets available. Please enter a smaller number.");
                } else {
                    // Calculate the total cost and update the vendor's available tickets
                    totalCost = ticketsToPurchase * vendor.getTicketPrice();
                    vendor.setNoOfTickets(vendor.getNoOfTickets() - ticketsToPurchase); // Update available tickets
                    System.out.println("Purchase successful! Total cost: $" + totalCost);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for the tickets.");
            }
        }
    }

    // Method to display customer purchase information
    public void displayPurchaseInfo() {
        System.out.println("\nCustomer Name: " + name);
        System.out.println("Contact Info: " + contactInfo);
        System.out.println("Tickets Purchased: " + ticketsToPurchase);
        System.out.println("Total Cost: $" + totalCost);
    }
}
