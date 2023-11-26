package com.github.bitsamu.network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);

            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter clientOutput = new PrintWriter(socket.getOutputStream(), true);

            // Read from console and send to server
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            // Listen for messages from the server
            Thread serverListenerThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = serverInput.readLine()) != null) {
                        System.out.println("Server: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serverListenerThread.start();

            // Send messages to the server
            String clientMessage;
            while ((clientMessage = consoleInput.readLine()) != null) {
                clientOutput.println(clientMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}