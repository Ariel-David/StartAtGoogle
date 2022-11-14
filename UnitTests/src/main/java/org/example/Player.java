package org.example;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    public String Name;
    public int Grade;
    public Gender gender;
    public static List<String> Positions;

    public int JNumber;
    public String playerPos;

    public static NameGenerator name_generator;

    public Player() {

    }

    public static Player createPlayer(Gender gender) {
        Player p = new Player();
        Positions = new ArrayList<>(Arrays.asList("Goal Keeper", "Defender", "Midfielder", "Attacker"));
        name_generator =  new NameGenerator();
        p.setName(name_generator.randomString(4));
        p.gender = gender;
        p.Grade = random_Grade();
        return p;
    }

    public static int random_Grade() {
        final int max = 100;
        Random generator = new Random();
        int res = generator.nextInt(max) + 1;
        return res;
    }

    public Gender randomGender(){
        int randomNum = ThreadLocalRandom.current().nextInt(gender.values().length);
        return gender.values()[randomNum];
    }

    public void setName(String name) {
        Name = name;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public void setJNumber(int JNumber) {
        this.JNumber = JNumber;
    }

    public void setPlayerPos(String playerPos) {
        this.playerPos = playerPos;
    }

    public String getName() {
        return Name;
    }

    public int getGrade() {
        return Grade;
    }

    public String getPlayerPos() {
        return playerPos;
    }
}
