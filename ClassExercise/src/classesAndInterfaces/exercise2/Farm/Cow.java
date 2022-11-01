package startAtGoogle.classesAndInterfaces.exercise2.Farm;

public class Cow extends AnimalExtension implements Animal {

    public Cow(){
        super();
    }

    @Override
    public Animal mate(Animal partner) {
        if (partner instanceof Cow) {
            if (!((Cow) partner).gender.equals(this.gender)) {
                return new Cow();
            }
        }
        return null;
    }

    @Override
    public void move() {
        System.out.println("I'm Moving!");
    }
}
