package Q1;

import java.util.*;

public class MainApp {
    static HashSet<Vehicle> vehicles = new HashSet<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add 2.Remove 3.Update Price 4.Sell 5.Purchase");
            System.out.println("6.Display All 7.By Type 8.By Price Range 9.Sort 10.Search 11.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: addVehicle(); break;
                case 2: removeVehicle(); break;
                case 3: updatePrice(); break;
                case 4: changeStatus("Sold"); break;
                case 5: changeStatus("Available"); break;
                case 6: displayAll(); break;
                case 7: displayByType(); break;
                case 8: displayByPriceRange(); break;
                case 9: sortByPrice(); break;
                case 10: searchByName(); break;
                case 11: System.exit(0);
            }
        }
    }

    static void addVehicle() {
        System.out.println("1. Electric 2. Petrol");
        int type = sc.nextInt();

        System.out.print("Enter ID, Name, Price: ");
        int id = sc.nextInt();
        String name = sc.next();
        double price = sc.nextDouble();

        if (type == 1) {
            System.out.print("Battery & Charging Time: ");
            double b = sc.nextDouble();
            double c = sc.nextDouble();
            vehicles.add(new ElectricVehicle(id, name, price, "Available", b, c));
        } else {
            System.out.print("Fuel Type & Mileage: ");
            String fuel = sc.next();
            double m = sc.nextDouble();
            vehicles.add(new PetrolVehicle(id, name, price, "Available", fuel, m));
        }
    }

    static void removeVehicle() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        vehicles.removeIf(v -> v.getVehicleId() == id);
    }

    static void updatePrice() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        for (Vehicle v : vehicles) {
            if (v.getVehicleId() == id) {
                System.out.print("New Price: ");
                v.setPrice(sc.nextDouble());
            }
        }
    }

    static void changeStatus(String status) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        for (Vehicle v : vehicles) {
            if (v.getVehicleId() == id) {
                v.setStatus(status);
            }
        }
    }

    static void displayAll() {
        for (Vehicle v : vehicles) {
            v.display();
        }
    }

    static void displayByType() {
        System.out.println("1.Electric 2.Petrol");
        int type = sc.nextInt();

        for (Vehicle v : vehicles) {
            if (type == 1 && v instanceof ElectricVehicle)
                v.display();
            else if (type == 2 && v instanceof PetrolVehicle)
                v.display();
        }
    }

    static void displayByPriceRange() {
        System.out.print("Enter min and max price: ");
        double min = sc.nextDouble();
        double max = sc.nextDouble();

        for (Vehicle v : vehicles) {
            if (v.getPrice() >= min && v.getPrice() <= max)
                v.display();
        }
    }

    static void sortByPrice() {
        List<Vehicle> list = new ArrayList<>(vehicles);
        list.sort(Comparator.comparingDouble(Vehicle::getPrice));

        for (Vehicle v : list)
            v.display();
    }

    static void searchByName() {
        System.out.print("Enter name: ");
        String name = sc.next();

        for (Vehicle v : vehicles) {
            if (v.getVehicleName().equalsIgnoreCase(name))
                v.display();
        }
    }
}