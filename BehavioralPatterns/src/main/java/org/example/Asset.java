package org.example;

import org.example.Visitor;

public class Asset implements Appliance{

    int serial_number;
    String owner;
    double rating;

    @Override
    public String  accept(Visitor visitor) {
       return visitor.visit(this);
    }

    public Asset(int serial_number, String owner, double rating) {
        this.serial_number = serial_number;
        this.owner = owner;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Assent{" +
                "serial number=" + serial_number +
                "owner=" + owner +
                "rating=" + rating +
                '}';
    }
}
