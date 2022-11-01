package startAtGoogle.classesAndInterfaces.exercise2.Farm;

import java.util.Random;

public class Farmer {
    Farm farm = new Farm();
    public void move() {
        Random r = new Random();
        int res = r.nextInt(farm.animals_list.size()) + 1;
        farm.animals_list.get(res).move();
    }

    public Animal requestAnAnimal(){
        Animal a = farm.provideAnimal();
        return a;
    }
}
