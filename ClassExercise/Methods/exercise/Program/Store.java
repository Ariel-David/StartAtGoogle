package Methods.exercise.Program;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Store {

    public void assignCoupon(User u) {
        Coupon c = new Coupon();
        addCouponToUser(u,c);
    }

    private void addCouponToUser(User u,Coupon c){
        u.listOfCoupon.add(c);
    }

    public void useCouponById(User u, int id) {
        List<Coupon> list = u.listOfCoupon;
        if (list.isEmpty()) {
            System.out.println("No Coupons!");
        } else if (list.size() == 1) {
            System.out.println("Coupon choose by id is used!!");
            list.remove(0);
        } else {
            for (Coupon c : list) {
                if (c.id == id) {
                    System.out.println("Coupon is found and used!");
                    list.remove(c);
                    break;
                } else {
                    System.out.println("Coupon is not found");
                }
            }
        }
    }

    public void useCouponByHighestValue(User u ) {
        List<Coupon> list = u.listOfCoupon;
        if (list.isEmpty()) {
            System.out.println("No Coupons!");
        } else if (list.size() == 1) {
            System.out.println("Coupon with the highest value choose used!!");
            list.remove(0);
        } else {
            Coupon temp = new Coupon();
            int max = Integer.MIN_VALUE;
            for (Coupon c : list) {
                if (c.value > max) {
                    max = c.value;
                    temp = c;
                }
            }
            System.out.println("Coupon with the value: " + temp.value + " used!");
            list.remove(temp);
        }
    }

    public void useCouponBYClosestExpiryDate(User u) {
        List<Coupon> list = u.listOfCoupon;
        if (list.isEmpty()) {
            System.out.println("No Coupons!");
        } else if (list.size() == 1) {
            System.out.println("Coupon with the date: " + list.get(0).expiry_date + " used!");
            list.remove(0);
        } else {
            LocalDate max = list.get(0).expiry_date;
            for (int i = 1; i < list.size(); i++) {
                if (max.compareTo(list.get(i).expiry_date) > 0) {
                    max = list.get(i).expiry_date;
                }
            }
            System.out.println("Coupon with the date: " + max + " used!");
            list.remove(max);
        }
    }

    public void useCouponRandomlySelected(User u) {
        List<Coupon> list = u.listOfCoupon;
        if (list.isEmpty()) {
            System.out.println("No Coupons!");
        }
        else if (list.size() == 1) {
            System.out.println("Coupon choose randomly and is used!!");
            list.remove(0);
        }
        else {
            int randomNum = ThreadLocalRandom.current().nextInt(list.size() - 1);
            list.remove(randomNum);
            System.out.println("Coupon choose randomly and is used!!");
        }
    }
}
