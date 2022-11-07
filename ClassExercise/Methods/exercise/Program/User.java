package startAtGoogle.Methods.exercise.Program;

import java.util.ArrayList;
import java.util.List;

public class User {
    Name name;
    List<Coupon> listOfCoupon = new ArrayList<>();

    public User(){
        name = new Name();
    }

    public void printListOfCoupon(){
        for (int i = 0; i < listOfCoupon.size(); i++) {
            System.out.println("id: "+listOfCoupon.get(i).id+" date: "+listOfCoupon.get(i).expiry_date+" value: "+listOfCoupon.get(i).value);
        }
    }

    public void printName(){
        System.out.print("User Name: ");
        name.printFullName();
    }
}
