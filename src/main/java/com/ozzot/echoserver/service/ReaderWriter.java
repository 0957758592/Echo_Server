package com.ozzot.echoserver.service;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ReaderWriter {

    public static void readAndWriteData(Socket socket, boolean client) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);) {

            Scanner sc = new Scanner(System.in);

            while (true) {

                String line = client ? sc.nextLine() : reader.readLine();
                writer.println(line);

                String requesResponse = client ? "response from server: " + reader.readLine() : "request from client: " + line;

                System.out.println(requesResponse);

                if (line.equals("@")) {
                    System.out.println("Exit");
                    break;
                }
            }
        }

    }

}
