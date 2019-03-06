package com.ozzot.echoserver.utils;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ReaderWriter {

    public static void readAndWriteData(Socket socket, boolean client) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

        while (true) {

            String line;
            if (client) {
                Scanner sc = new Scanner(System.in);
                line = sc.nextLine();
                writer.println(line);
                System.out.println("response from server: " + reader.readLine());

            } else {

                line = reader.readLine();
                writer.println(line);
                System.out.println("request from client: " + line);
            }

            if (line.equals("@")) {
                System.out.println("Exit");
                break;
            }
        }

    }

}
