package app.entity;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class User {
    private static int idCounter = 10000;
    private final int id;
    private String email;
    private String name;
    private String password;
    static Faker faker = new Faker();

    public User(String email, String name, String password) {
        this.id = idCounter++;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public User(int id ,String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    static String getRandomName(){return faker.name().firstName();};
    static String getRandomEmail(){return(faker.name().firstName()+ ThreadLocalRandom.current().nextInt(100, 299 + 1)+"@gmail.com");}
    static Integer getRandomId(){return (ThreadLocalRandom.current().nextInt(100000000, 999999999));}

    static String getRandomPassword(){return (faker.name().lastName() + ThreadLocalRandom.current().nextInt(10000, 99999));}

    public static User newRandomUser()
    {
        return new User(getRandomId(),getRandomEmail(),getRandomName(),getRandomPassword());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
