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
        try {
            HTTPFacade.RequestPUT();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("PUT DONE");

        try {
            HTTPFacade.RequestDELETE();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("DELETE DONE");

        try {
            HTTPFacade.sendPATCH();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("PATCH DONE");
    }

}
