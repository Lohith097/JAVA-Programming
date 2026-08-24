import java.util.Scanner;

abstract class Vehicle {
    private String vehicleNumber;
    private String brand;

    public Vehicle(String vehicleNumber, String brand) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
    }

    abstract void startEngine();

    final void showVehicleIdentity() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Brand         : " + brand);
    }
}

class Car extends Vehicle {
    public Car(String vehicleNumber, String brand) {
        super(vehicleNumber, brand);
    }

    void startEngine() {
        System.out.println("Car engine started with key ignition.");
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, String brand) {
        super(vehicleNumber, brand);
    }

    void startEngine() {
        System.out.println("Bike engine started with self-start button.");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Car Vehicle Number:");
        String carNumber = sc.nextLine();
        System.out.println("Enter Car Brand:");
        String carBrand = sc.nextLine();

        Car car = new Car(carNumber, carBrand);
        car.startEngine();
        car.showVehicleIdentity();

        System.out.println("Enter Bike Vehicle Number:");
        String bikeNumber = sc.nextLine();
        System.out.println("Enter Bike Brand:");
        String bikeBrand = sc.nextLine();

        Bike bike = new Bike(bikeNumber, bikeBrand);
        bike.startEngine();
        bike.showVehicleIdentity();

        sc.close();
    }
}
