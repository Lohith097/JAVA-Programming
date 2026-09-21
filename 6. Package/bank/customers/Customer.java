package bank.customers;

public class Customer {
    private String customerId;
    private String customerName;
    private String contactNumber;

    public Customer(String customerId, String customerName, String contactNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
    }

    public void displayCustomer() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + customerName);
        System.out.println("Contact: " + contactNumber);
    }
}

