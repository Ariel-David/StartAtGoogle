package StructuralPatterns.src.main.java.org.example;

import java.io.IOException;

public class Client {

    public static void main(String[] args) {
        try {
            org.example.HTTPFacade.sendGET();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("GET DONE");
        try {
            org.example.HTTPFacade.sendPOST();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("POST DONE");
        try {
            org.example.HTTPFacade.RequestPUT();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("PUT DONE");

        try {
            org.example.HTTPFacade.RequestDELETE();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("DELETE DONE");

        try {
            org.example.HTTPFacade.sendPATCH();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("PATCH DONE");
    }

}
