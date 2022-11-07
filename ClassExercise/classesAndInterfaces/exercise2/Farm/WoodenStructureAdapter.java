package classesAndInterfaces.exercise2.Farm;

public class WoodenStructureAdapter implements WoodenStructures {
    WoodenHorse woodenHorse;

    public WoodenStructureAdapter(WoodenHorse woodenHorse) {
        this.woodenHorse = woodenHorse;
    }

    @Override
    public void roll() {
        woodenHorse.roll();
    }

    @Override
    public void replicate() {
        woodenHorse.replicate();
    }
}
