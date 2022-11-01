package startAtGoogle.CommonMethods.exercies;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    List<Contact> listOfConts = new ArrayList<>();
    String name;

    public PhoneBook(String name, int size) {
        this.name = name;
        for (int i = 0; i < size; i++) {
            listOfConts.add(new Contact());
        }
    }

    public void print() {
        System.out.println(name.toUpperCase());
        System.out.println("___________________________________");
        for (Contact c:listOfConts) {
            System.out.println(c.name.toString() +"  "+ c.phoneNumber.toString());
        }
    }
}
