package com.company.client;

import java.io.*;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) throws IOException{
        Client client = new Client();
        client.start();

        //accept the user input using command line
        String message;
        boolean bool=true;
        Scanner scanner = new Scanner(System.in);

        while(bool) {

            System.out.print("Enter message : ");
            message = scanner.nextLine();
            client.sendMessage(message);

            if(message.equals("exit.")){
                bool=false;
            }
        }
        System.out.println("Client finished execution.\n");
    }
}
