package startAtGoogle.classesAndInterfaces;

public class City {
    private final String name;
    private final String country;
    private int population;

    public City(String name, String country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public static City getTelaviv() {
        return telaviv;
    }

    private static City telaviv;

    public static final City TEL_AVIV() {
       if(telaviv == null){
           telaviv = new City("Tel Aviv" , "Israel" , 435855);
       }
       return telaviv;

    }
}
