package creationalPatterns.exercise1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static List<Passenger> passengerList = new ArrayList<>();

    public static void main(String[] args) {
        TravelAgency vehicleFactory = TravelAgency.getInstance();
        randomPassengerList();
        for (int i =0; i<passengerList.size(); i++){
            vehicleFactory.assignVehicle(passengerList.get(i));
        }
    }

    public static void randomPassengerList() {
        for (int i = 0; i < 17; i++) {
            Passenger p = new Passenger(getRandomName(), getRandomVehicles());
            passengerList.add(p);
        }
    }

    public static vehicles getRandomVehicles() {
    int randomNum = ThreadLocalRandom.current().nextInt(vehicles.values().length );
    return vehicles.values()[randomNum];
    }

    public static String getRandomName() {
        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final java.util.Random rand = new java.util.Random();
        final Set<String> identifiers = new HashSet<String>();
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }
}