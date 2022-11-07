package creationalPatterns.exercise1;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TravelAgency {

    private static TravelAgency instance;
    List<vehicles> vehiclesCounterList;
    Map<Vehicle, Passenger> vehiclesByPassengerMap;


    public static TravelAgency getInstance() {
        if (instance == null) {
            instance = new TravelAgency();
        }
        return instance;
    }

    private TravelAgency() {
        vehiclesCounterList = new ArrayList<>();
        vehiclesByPassengerMap = new HashMap<>();

        vehiclesCounterList.add(vehicles.PLANE);

        for (int i = 0; i < 4; i++) {
            vehiclesCounterList.add(vehicles.BUS);
        }
        for (int i = 0; i < 8; i++) {
            vehiclesCounterList.add(vehicles.TAXI);
        }
        for (int i = 0; i < 3; i++) {
            vehiclesCounterList.add(vehicles.BOAT);
        }
    }

    public Vehicle createVehicle(vehicles type) {
        switch (type) {
            case PLANE:
                return new Plane();
            case BUS:
                return new Bus();
            case TAXI:
                return new Taxi();
            case BOAT:
                return new Boat();
            default:
                throw new IllegalArgumentException(String.format("Vehicle type not supported: %s", type));
        }
    }

    public void assignVehicle(Passenger p) {
        if (vehiclesCounterList.isEmpty()) {
            for (Vehicle v : vehiclesByPassengerMap.keySet()) {
                    v.transport(vehiclesByPassengerMap.get(v));
            }
            vehiclesCounterList.clear();
        }
        else if (vehiclesCounterList.contains(p.favoriteVehicle)) {
            Vehicle v = createVehicle(p.favoriteVehicle);
            vehiclesByPassengerMap.put(v, p);
            vehiclesCounterList.remove(p.favoriteVehicle);
        }
        else {
            int randomNum = ThreadLocalRandom.current().nextInt(vehiclesCounterList.size());
            Vehicle v = createVehicle(vehiclesCounterList.get(randomNum));
            vehiclesByPassengerMap.put(v, p);
            vehiclesCounterList.remove(v.getName());
        }
    }

}
