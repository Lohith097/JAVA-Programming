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
        System.out.println("Loan No: " + loanNumber);
        System.out.println("Loan Type: " + loanType);
        System.out.println("Loan Amount: ₹" + loanAmount);
    }
}
