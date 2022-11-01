package creationalPatterns;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class TravelAgency {

    private static TravelAgency instance;
    Map<Vehicle, Integer> vehiclesCounterMap;


    public enum vehicleType {
        PLANE, BUS, TAXI, BOAT
    }

    public static TravelAgency getInstance(){
        if(instance==null){
            instance = new TravelAgency();
        }
        return instance;
    }

    private TravelAgency(){
        vehiclesCounterMap = new HashMap<>();
        vehiclesCounterMap.put(createVehicle(vehicleType.PLANE), 1);
        vehiclesCounterMap.put(createVehicle(vehicleType.BUS), 4);
        vehiclesCounterMap.put(createVehicle(vehicleType.TAXI), 8);
        vehiclesCounterMap.put(createVehicle(vehicleType.BOAT), 3);
    }

    public Vehicle createVehicle(vehicleType type) {
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
        if(vehiclesCounterMap.values().isEmpty()){

        }
        else{

        }
    }
}
