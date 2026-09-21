import bank.customers.Customer;
import bank.loans.Loan;
import bank.accounts.Account;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("C101", "Rahul", "9876543210");
        c1.displayCustomer();
        System.out.println("-------------------------");

        Loan l1 = new Loan("L201", "Home Loan", 500000.0);
        l1.displayLoanDetails();
        System.out.println("-------------------------");

        Account a1 = new Account("A301", "Savings", 20000.0);
        a1.displayBalance();
        
        a1.deposit(10000.0);
        a1.displayBalance();
        
        a1.withdraw(5000.0);
        a1.displayBalance();
        
        a1.withdraw(80000.0);
    }
}
