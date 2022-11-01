package startAtGoogle.Methods.exercise;

import startAtGoogle.Methods.exercise.Program.Store;
import startAtGoogle.Methods.exercise.Program.User;

import java.util.*;

public class Main {
    public static <T> void main(String[] args) throws Exception {

        Store s = new Store();
        User u = new User();

        for (int i = 0; i < 10; i++) {
            s.assignCoupon(u);
        }

        u.printName();
        u.printListOfCoupon();

        s.useCouponByHighestValue(u);
        s.useCouponBYClosestExpiryDate(u);
        s.useCouponById(u, 789789);
        s.useCouponRandomlySelected(u);
    }
}
