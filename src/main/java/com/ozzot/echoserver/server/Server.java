package com.ozzot.echoserver.server;

import com.ozzot.echoserver.utils.Constants;
import com.ozzot.echoserver.utils.ReaderWriter;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(Constants.PORT, 1, InetAddress.getByName("localhost"))) {

            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");

            Socket socket = serverSocket.accept();
            System.out.println("Client accepted: " + socket);

            ReaderWriter.readAndWriteData(socket, false);

        }

    }
}
