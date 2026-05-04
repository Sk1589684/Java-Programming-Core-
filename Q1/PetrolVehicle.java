package Q1;

class PetrolVehicle extends Vehicle {
    String fuelType;
    double mileage;

    public PetrolVehicle(int id, String name, double price, String status,
                         String fuelType, double mileage) {
        super(id, name, price, status);
        this.fuelType = fuelType;
        this.mileage = mileage;
    }

    @Override
    public void display() {
        System.out.println("Petrol Vehicle -> ID: " + vehicleId +
                ", Name: " + vehicleName +
                ", Price: " + price +
                ", Status: " + status +
                ", Fuel: " + fuelType +
                ", Mileage: " + mileage);
    }
}