package startAtGoogle.Generics.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    public static <T> void main(String[] args) {

        Callable<Integer> IntegerCallable = new Callable<>() {
            @Override
            public Integer call() throws Exception {
                return ThreadLocalRandom.current().nextInt(10);
            }
        };

        Callable<String> stringCallable = new Callable<>() {
            @Override
            public String call() throws Exception {
                return getFirstName();
            }
        };

        System.out.println(retry(IntegerCallable, 3, 3, 1));
        System.out.println(retry(stringCallable, "Candice", 2, 1));
        System.out.println(retry(stringCallable, "Rosalee", 4));
        System.out.println(retry(stringCallable, "George"));
    }

    public static <T> T retry(Callable<T> action, T expectedResult, int retries, long sleep) {
        T res = (T) action;
        try {
            int counter = 0;
            do{
                res = action.call();
                counter++;
                if(res.equals(expectedResult)) {
                    Thread.sleep(sleep);
                }
            } while (counter < retries && res != expectedResult);
        }catch (Exception e) {
            throw new RuntimeException("Not expected result!", e);
        }
        return res;
    }

    public static <T> T retry(Callable<T> action, T expectedResult, int retries) {
        return retry(action,expectedResult,retries,2);
    }

    public static <T> T retry(Callable<T> action, T expectedResult) {
        return retry(action,expectedResult,5,1);
    }

    static List<String> listOfFirstName = Arrays.asList("Karen",
            "Jolene",
            "Jenna",
            "Bob",
            "Candice",
            "George",
            "Emely",
            "Barry",
            "Rosalee",
            "Sebastian"
    );

    public static String getFirstName() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, listOfFirstName.size() + 1);
        return listOfFirstName.get(randomNum);
    }

}