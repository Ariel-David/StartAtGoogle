package classesAndInterfaces.exercise2.Farm;

public class Goat extends AnimalExtension implements Animal {
    public Goat() {
        super();
    }

    public Goat(String gender, int id, int weight) {
        super(gender, id, weight);
    }

    @Override
    public Animal mate(Animal partner) {
        if(partner instanceof Goat){
            if(!((Goat) partner).gender.equals(this.gender)) {
                    return new Goat();
            }
        }
        return null;
    }

    @Override
    public void move() {
        System.out.println("I'm Moving!");
    }
}
