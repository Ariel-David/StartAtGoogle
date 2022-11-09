package org.example;

public class User implements Appliance {
    int id;
    String name;
    String password;

    @Override
    public String accept(Visitor visitor) {
       return visitor.visit(this);
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                "name=" + name +
                "password=" + password +
                '}';
    }
}
