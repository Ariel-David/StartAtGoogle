package creationalPatterns;

public class Taxi implements Vehicle{
    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName());
    }

    @Override
    public vehicles getName() {
        return vehicles.TAXI;
    }
}
