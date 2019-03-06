package com.ozzot.echoserver.service;

import com.ozzot.echoserver.utils.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.*;

import static org.junit.Assert.*;

public class ReaderWriterTest {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    @Before
    public void beforeClass() throws IOException {
        clientSocket = new Socket();
        serverSocket = new ServerSocket(Constants.PORT, Constants.COUNT_CONNECTIONS, InetAddress.getByName(Constants.INET_ADDRESS_NAME));
        clientSocket.connect(new InetSocketAddress(Constants.HOST, Constants.PORT), Constants.TIMEOUT);

        Socket socket = serverSocket.accept();
        printWriter = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), Constants.UNICODE_TYPE), true);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @After
    public void after() throws IOException {
        bufferedReader.close();
        printWriter.close();
        clientSocket.close();
        serverSocket.close();
    }

    @Test
    public void isConnection() {
        assertTrue(serverSocket.isBound());
        assertTrue(clientSocket.isConnected());
    }

    @Test
    public void readAndWriteDataTest() throws IOException {
        String clientRequest = "clientRequest";
        printWriter.println(clientRequest);

        assertEquals(clientRequest, bufferedReader.readLine());

    }

    @Test(expected = UnknownHostException.class)
    public void UnknownHostExceptionTest() throws IOException {
        new ServerSocket(Constants.PORT, Constants.COUNT_CONNECTIONS, InetAddress.getByName("local"));
    }

}