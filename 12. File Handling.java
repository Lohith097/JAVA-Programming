import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

class LibraryTransaction {
    String bookId;
    String bookName;
    String studentName;
    String issueDate;
    String returnDate;

    LibraryTransaction(String bId, String bName, String sName, String iDate, String rDate) {
        this.bookId = bId;
        this.bookName = bName;
        this.studentName = sName;
        this.issueDate = iDate;
        this.returnDate = rDate;
    }

    void saveToFile() {
        try {
            FileWriter writer = new FileWriter("transactions.txt", true);
            writer.write(bookId + "," + bookName + "," + studentName + "," + issueDate + "," + returnDate + "\n");
            writer.close();
            System.out.println("Transaction recorded successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Record Book Transaction");
            System.out.println("2. View Transaction Records");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bId = sc.nextLine();
                    System.out.print("Enter Book Name: ");
                    String bName = sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String sName = sc.nextLine();
                    System.out.print("Enter Issue Date: ");
                    String iDate = sc.nextLine();
                    System.out.print("Enter Return Date: ");
                    String rDate = sc.nextLine();

                    LibraryTransaction trans = new LibraryTransaction(bId, bName, sName, iDate, rDate);
                    trans.saveToFile();
                    break;
                case 2:
                    try {
                        FileReader fr = new FileReader("transactions.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        boolean hasRecords = false;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                            hasRecords = true;
                        }
                        br.close();
                        if (!hasRecords) System.out.println("No transaction records found.");
                    } catch (IOException e) {
                        System.out.println("No transaction records found.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting Library Management System.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        sc.close();
    }
}
