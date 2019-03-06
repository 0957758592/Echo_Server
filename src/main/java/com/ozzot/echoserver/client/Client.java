package com.ozzot.echoserver.client;

import com.ozzot.echoserver.utils.Constants;
import com.ozzot.echoserver.service.ReaderWriter;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(Constants.HOST, Constants.PORT), Constants.TIMEOUT);

            ReaderWriter.readAndWriteData(socket, true);

        }
    }

}
