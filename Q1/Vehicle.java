package Q1;

abstract class Vehicle {
    int vehicleId;
    String vehicleName;
    double price;
    String status; // Available / Sold

    public Vehicle(int vehicleId, String vehicleName, double price, String status) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.price = price;
        this.status = status;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract void display();

    // Prevent duplicate vehicleId
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehicle)) return false;
        Vehicle v = (Vehicle) obj;
        return this.vehicleId == v.vehicleId;
    }

    @Override
    public int hashCode() {
        return vehicleId;
    }
}