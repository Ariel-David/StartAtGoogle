package creationalPatterns;

public class Main {
    public static void main(String[] args) {
        TravelAgency vehicleFactory = TravelAgency.getInstance();
        Vehicle vehicle1 = vehicleFactory.createVehicle(TravelAgency.vehicleType.PLANE);
        Vehicle vehicle2 = vehicleFactory.createVehicle(TravelAgency.vehicleType.BOAT);
        Passenger p = new Passenger("Dani", Passenger.vehicle.PLANE);
    }
}