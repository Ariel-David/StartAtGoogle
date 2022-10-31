public class Passenger {
    public String name;

    public vehicle favoriteVehicle;

    public enum vehicle {
        PLANE, BUS, TAXI, BOAT
    }

    public Passenger(String name, vehicle vehicle) {
        this.name = name;
        this.favoriteVehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public vehicle getFavoriteVehicle() {
        return favoriteVehicle;
    }
}
