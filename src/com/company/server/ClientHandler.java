package com.company.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket client;
    public ClientHandler(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);//wait for 30 seconds before executing rest of the code

            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream dataOutputStream = new DataOutputStream(this.client.getOutputStream());

            //Continuous reading data from client
            String inputData;
            while((inputData = bufferedReader.readLine()) != null){

                System.out.println("Client says:" + inputData);

                switch (inputData){
                    case "Hello From the Client.":
                        dataOutputStream.writeBytes("Hello from the server.\n");
                        break;
                    case "How are you?":
                        dataOutputStream.writeBytes("I'm fine. how are you?\n");
                        break;
                    case "I'm fine.":
                        dataOutputStream.writeBytes("Okay good to know.\n");
                        break;
                    case "Thank You.":
                        dataOutputStream.writeBytes("You are welcome.\n");
                        break;
                    default:
                        dataOutputStream.writeBytes("I didn't understand that. \n");
                }
                if(inputData.equals("exit.")){
                    break;
                }
            }
            this.client.close();

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }


    }

}
