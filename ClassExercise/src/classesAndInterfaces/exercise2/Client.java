package startAtGoogle.classesAndInterfaces.exercise2;

import startAtGoogle.classesAndInterfaces.exercise2.Farm.*;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        List<Animal> list = new ArrayList<>();
        Cat c1 = new Cat();
        Cat c2 = new Cat();
        Cow co = new Cow();
        Goat go = new Goat();
        list.add(c1);
        list.add(c2);
        list.add(co);
        list.add(go);
        Farmer f = new Farmer();
        f.move();
        Animal a = f.requestAnAnimal();
    }
}
