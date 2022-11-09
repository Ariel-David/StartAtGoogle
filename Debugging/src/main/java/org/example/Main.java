package org.example;

import com.oracle.tools.packager.Log;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Debugger.log("start");
        long n = 1234567988;
        func(n);

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