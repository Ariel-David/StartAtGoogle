package classesAndInterfaces.exercise2.Farm;

public class Cat extends AnimalExtension implements Animal {
    public Cat() {
        super();
    }
    public Cat(String gender, int id, int weight) {
        super(gender, id, weight);
    }

    @Override
    public Animal mate(Animal partner) {
        if(partner instanceof Cat){
            if(!((Cat) partner).gender.equals(this.gender)) {
                    return new Cat();
            }
        }
        return null;
    }

    @Override
    public void move() {
     System.out.println("I'm Moving!");
    }
}
