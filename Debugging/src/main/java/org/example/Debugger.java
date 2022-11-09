package org.example;

import java.util.Date;

public class Debugger {
    static Date date = new Date();
    public static void log(Object o){
        System.out.println(o.toString()+"  "+date);
    }
}
