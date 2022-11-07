package classesAndInterfaces.exercise2.Farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Farm {
    List<Animal> animals_list = new ArrayList<>();

    public Farm() {
       for (int i=0; i<10; i++){
           Cat c = new Cat();
           animals_list.add(c);
       }
        for (int i=0; i<10; i++){
           Goat g = new Goat();
            animals_list.add(g);
        }
        for (int i=0; i<10; i++){
            Cow co = new Cow();
            animals_list.add(co);
        }
    }

    public void acquire() {
        animals_list.add(generateRandomAnimal());
    }

    public Animal mate(Animal animal) {
        if (animals_list.contains(animal)) {
            if (animal instanceof Cat) {
                Cat c = new Cat();
                return c;
            } else if (animal instanceof Cow) {
                Cow co = new Cow();
                return co;
            } else if (animal instanceof Goat) {
                Goat g = new Goat();
                return g;
            }
        }
        return null;
    }

    public Animal provideAnimal(){
        Animal a = generateRandomAnimal();
        if (a instanceof Cat) {
            System.out.println("Cat is provided");
        }
        else if(a instanceof Cow){
            System.out.println("Cow is provided");
        }
        else {
            System.out.println("Goat is provided");
        }
        return a;
    }

    public Animal generateRandomAnimal() {
        List<Animal> ans = new ArrayList<>();
        ans.add(new Cat());
        ans.add(new Cow());
        ans.add(new Goat());

        Random r = new Random();
        int res = r.nextInt(ans.size()) + 1;
        return ans.get(res);
    }
}
