package creationalPatterns.exercise1;

public class Bus implements Vehicle {
    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName());

    }

    @Override
    public vehicles getName() {
        return vehicles.BUS;
    }
}
