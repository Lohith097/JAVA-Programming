// bank/customers/Customer.java
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
        System.out.println("\n--- Customer Details ---");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + customerName);
        System.out.println("Contact: " + contactNumber);
    }
}

// bank/loans/Loan.java
package bank.loans;

public class Loan {
    private String loanNumber;
    private String loanType;
    private double loanAmount;

    public Loan(String loanNumber, String loanType, double loanAmount) {
        this.loanNumber = loanNumber;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
    }

    public void displayLoanDetails() {
        System.out.println("\n--- Loan Details ---");
        System.out.println("Loan No: " + loanNumber);
        System.out.println("Loan Type: " + loanType);
        System.out.println("Loan Amount: ₹" + loanAmount);
    }
}

// bank/accounts/Account.java
package bank.accounts;

public class Account {
    private String accountNumber;
    private String accountType;
    private double balance;

    public Account(String accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: ₹" + amount);
        } else {
            System.out.println("Error: Invalid deposit amount (Cannot be negative).");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Error: Insufficient Balance!");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("Successfully withdrawn: ₹" + amount);
        } else {
            System.out.println("Error: Invalid withdrawal amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Account [" + accountNumber + " | " + accountType + "] Balance: ₹" + balance);
    }
}

// Main.java
import bank.customers.Customer;
import bank.loans.Loan;
import bank.accounts.Account;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.print("\n1: Customer | 2: Loan | 3: Account Ops | 0: Exit -> ");
            choice = sc.nextInt();
            
            if (choice == 0) {
                System.out.println("Exiting Banking System...");
                break;
            }

            switch (choice) {
                case 1: // Tests TC1
                    System.out.print("Enter ID, Name, Contact (separated by space): ");
                    Customer c = new Customer(sc.next(), sc.next(), sc.next());
                    c.displayCustomer();
                    break;

                case 2:
                    System.out.print("Enter Loan No, Type , Amount: ");
                    Loan l = new Loan(sc.next(), sc.next(), sc.nextDouble());
                    l.displayLoanDetails();
                    break;

                case 3:
                    System.out.print("Enter Acc No, Type, Init Balance: ");
                    Account acc = new Account(sc.next(), sc.next(), sc.nextDouble());
                    acc.displayBalance();
                    
                    System.out.print("Amount to Deposit : ");
                    acc.deposit(sc.nextDouble());
                    
                    System.out.print("Amount to Withdraw : ");
                    acc.withdraw(sc.nextDouble());
                    
                    System.out.println("\n--- Final Status ---");
                    acc.displayBalance();
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
        sc.close();
    }
}
