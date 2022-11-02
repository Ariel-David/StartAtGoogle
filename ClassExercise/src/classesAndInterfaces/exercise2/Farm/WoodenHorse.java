package classesAndInterfaces.exercise2.Farm;

public class WoodenHorse implements WoodenStructures{
    @Override
    public void roll() {
        System.out.println("rolling");
    }

    @Override
    public void replicate() {
        System.out.println("replicating");
    }
}
