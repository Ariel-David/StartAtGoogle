package BehavioralPatterns;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Appliance> appliances = new ArrayList<>();
        appliances.add(new User(123,"ari","934777"));
        appliances.add(new Asset(3,"Dani",4.1));
        appliances.add(new Group(3333,4));

        exportToJSON export_To_JSON = new exportToJSON();
        for (Appliance appliance : appliances) {
           System.out.println(appliance.accept(export_To_JSON));
        }
    }
}
