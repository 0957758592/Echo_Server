package com.ozzot.echoserver.service;

import com.ozzot.echoserver.utils.Constants;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ReaderWriter {

    public static void readAndWriteData(Socket socket, boolean client) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), Constants.UNICODE_TYPE));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), Constants.UNICODE_TYPE), true)) {

            Scanner sc = new Scanner(System.in);

            while (true) {

                String line = client ? sc.nextLine() : reader.readLine();
                writer.println(line);

                String requestResponse = client ? "response from server: " + reader.readLine() : "request from client: " + line;

                System.out.println(requestResponse);

                if (line.equals("@")) {
                    System.out.println("Exit");
                    break;
                }
            }
        }

    }

}
