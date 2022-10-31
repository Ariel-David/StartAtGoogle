package startAtGoogle.JavaBasic.exercise;

import java.util.ArrayList;

public class Loops_Exercise {

    public static class loops {
        public static void numDev(ArrayList<Integer> arr, int num) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) % num == 0) {
                    System.out.println("Using For Loop: " + arr.get(i));
                }
            }

            System.out.println();

            for (Integer index : arr) {
                if (arr.get(index) % num == 0) {
                    System.out.println("Using For-Each Loop: " + arr.get(index));
                }
            }

            System.out.println();

            int i = 0;
            while (i < arr.size()) {
                if (arr.get(i) % num == 0) {
                    System.out.println("Using While Loop: " + arr.get(i));
                }
                i++;
            }
        }
    }

}
