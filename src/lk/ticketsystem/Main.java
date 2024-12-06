package lk.ticketsystem;

public class Main {
    public static void main(String[] args) {
        // Test data for the vendor
        Vendor vendor = new Vendor();
        vendor.enterTicketInformation(); // Vendor enters event and ticket information
        vendor.displayTicketInformation(); // Display vendor details

        // Create a customer and let them enter their details and purchase tickets
        Customer customer = new Customer();
        customer.enterCustomerDetailsAndPurchaseTickets(vendor); // Customer purchases tickets
        customer.displayPurchaseInfo(); // Display customer purchase details
    }
}
