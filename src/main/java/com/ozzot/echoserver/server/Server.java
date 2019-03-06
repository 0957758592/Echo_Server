package com.ozzot.echoserver.server;

import com.ozzot.echoserver.utils.Checker;
import com.ozzot.echoserver.utils.Constants;
import com.ozzot.echoserver.service.ReaderWriter;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        InetAddress address = InetAddress.getByName(Constants.INET_ADDRESS_NAME);
        Checker.isNotNull(address);

        try (ServerSocket serverSocket = new ServerSocket(Constants.PORT, Constants.COUNT_CONNECTIONS, address)) {

            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");

            Socket socket = serverSocket.accept();
            System.out.println("Client accepted: " + socket);

            ReaderWriter.readAndWriteData(socket, false);

        }

    }
}
