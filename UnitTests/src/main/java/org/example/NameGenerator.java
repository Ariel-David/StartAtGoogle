package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NameGenerator {

    public List<String> females;
    public List<String> males;


    static final String AB = "abcdefghijklmnopqrstuvwxyz";

    public NameGenerator( ) {
        females = new ArrayList<>();
        males = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            females.add(randomString(5));
        }
        for (int i = 0; i <20 ; i++) {
            males.add(randomString(4));
        }
    }

    String randomString(int len){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }


}
