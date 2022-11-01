package creationalPatterns.exercise1;

public class Boat implements Vehicle {
    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName());
    }

    @Override
    public vehicles getName() {
        return vehicles.BOAT;
    }
}
