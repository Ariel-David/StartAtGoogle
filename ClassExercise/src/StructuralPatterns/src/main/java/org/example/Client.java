package org.example;

import java.io.IOException;

public class Client {

    public static void main(String[] args) {
        try {
            HTTPFacade.sendGET();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("GET DONE");
        try {
            HTTPFacade.sendPOST();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("POST DONE");
    }

}
