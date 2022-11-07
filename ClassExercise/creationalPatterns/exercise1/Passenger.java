package creationalPatterns.exercise1;

public class Passenger {
    public String name;

    public vehicles favoriteVehicle;


    public Passenger(String name, vehicles vehicle) {
        this.name = name;
        this.favoriteVehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public vehicles getFavoriteVehicle() {
        return favoriteVehicle;
    }
}
