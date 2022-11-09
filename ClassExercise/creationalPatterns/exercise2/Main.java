package creationalPatterns.exercise2;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Date d = new Date();
        JobPosition mosheCohen = new JobPosition.Builder(d,"title",true).build();
    }
}
