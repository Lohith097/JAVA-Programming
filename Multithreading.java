import java.util.Scanner;

class TicketBooking {
    String passengerName;
    String bookingStatus;

    public TicketBooking(String passengerName) {
        this.passengerName = passengerName;
        this.bookingStatus = "Pending";
    }

    public void processBooking() {
        if (passengerName == null || passengerName.trim().isEmpty()) {
            bookingStatus = "Failed (Invalid Name)";
        } else {
            bookingStatus = "Confirmed";
        }
        System.out.println("Passenger: " + passengerName +
                           " | Status: " + bookingStatus +
                           " | Thread: " + Thread.currentThread().getName());
    }
}

class BookingThread extends Thread {
    TicketBooking booking;

    public BookingThread(TicketBooking booking, String threadName) {
        super(threadName);
        this.booking = booking;
    }

    @Override
    public void run() {
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        booking.processBooking();
    }
}

class BookingRunnable implements Runnable {
    TicketBooking booking;

    public BookingRunnable(TicketBooking booking) {
        this.booking = booking;
    }

    @Override
    public void run() {
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        booking.processBooking();
    }
}

public class RailwayReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Enter total number of booking requests: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        Thread[] threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Passenger " + (i + 1) + " Name (Type 'null' or leave empty for invalid tests): ");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("null")) name = null;

            TicketBooking tb = new TicketBooking(name);

            if (i % 2 == 0) {
                threads[i] = new BookingThread(tb, "Thread-Class-" + i);
            } else {
                threads[i] = new Thread(new BookingRunnable(tb), "Runnable-Interface-" + i);
            }
        }

        System.out.println("\n--- Concurrent Booking Process Started ---");
       
        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println(t.getName() + " was interrupted.");
            }
        }

        System.out.println("All passenger booking requests have been processed successfully.");
        sc.close();
    }
}
