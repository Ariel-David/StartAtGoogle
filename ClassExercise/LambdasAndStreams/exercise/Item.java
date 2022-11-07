package LambdasAndStreams.exercise;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public  class Item implements Comparable<Item> {
    public  String name;
    public  Type type;

    public  LocalDate expirationDate;
    public  int weight;

    public Item() {
        name = getRandomName();
        type = Type.values()[ThreadLocalRandom.current().nextInt(Type.values().length)];
        expirationDate = (LocalDate.now().minusYears(1).plusDays(ThreadLocalRandom.current().nextInt(365)));
        weight = ThreadLocalRandom.current().nextInt(100);
    }


    public  String getRandomName() {
        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final java.util.Random rand = new java.util.Random();
        final Set<String> identifiers = new HashSet<String>();
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    @Override
    public int compareTo(Item o) {
        int cmp = (expirationDate.getYear() - o.expirationDate.getYear());
        if (cmp == 0) {
            cmp = (expirationDate.getMonth().getValue() - o.expirationDate.getMonth().getValue());
            if (cmp == 0) {
                cmp = (expirationDate.getDayOfMonth() - o.expirationDate.getDayOfMonth());
            }
        }
        return cmp;
    }

    public  Type getType() {
        return type;
    }

    public  LocalDate getExpirationDate() {
        return expirationDate;
    }

    public int getWeight() {
        return weight;
    }

    public void printItem() {
        System.out.println("Name: " + getName() + "    Type: " + getType()
                + "   Expiration Date: " + getExpirationDate() + "    Weight: " + getWeight());
    }

    public String getName() {
        return name;
    }

}
