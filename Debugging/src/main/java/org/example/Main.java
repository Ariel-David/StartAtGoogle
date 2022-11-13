package org.example;

import com.oracle.tools.packager.Log;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

            long r, sum = 0, temp;
            long n = 12345678987654321L;

            Debugger.log("start here");

            temp = n;
            while (n > 0) {
                r = n % 10;
                sum = (sum * 10) + r;
                n = n / 10;
            }
            if (temp == sum) {
                System.out.println("palindrome number ");
            } else {
                System.out.println("not palindrome");
            }
            Debugger.log("The next check is: stackTraces1()");
            Debugger.log("Finish debugging program");
    }
    public static void func(long n) {
        long r = n;
        long sum =0;;
        while (n > 0) {
            r = n % 10;
            Debugger.log(r);
            sum = (sum * 10) + r;
            Debugger.log(sum);
            n = n / 10;
           Debugger.log(n);
        }
    }
}