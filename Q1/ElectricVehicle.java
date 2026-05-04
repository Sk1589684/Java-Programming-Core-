package Q1;

class ElectricVehicle extends Vehicle {
    double batteryCapacity;
    double chargingTime;

    public ElectricVehicle(int id, String name, double price, String status,
                           double batteryCapacity, double chargingTime) {
        super(id, name, price, status);
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }

    @Override
    public void display() {
        System.out.println("Electric Vehicle -> ID: " + vehicleId +
                ", Name: " + vehicleName +
                ", Price: " + price +
                ", Status: " + status +
                ", Battery: " + batteryCapacity +
                ", ChargingTime: " + chargingTime);
    }
}