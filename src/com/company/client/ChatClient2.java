package com.company.client;

import java.io.IOException;

public class ChatClient2 {

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.start();

        client.sendMessage("Hello From the Client.");
        client.sendMessage("How are you?");
        client.sendMessage("I'm fine.");
        client.sendMessage("Thank You.");
        client.sendMessage("exit.");

        System.out.println("Client finished execution.\n");
    }
}
