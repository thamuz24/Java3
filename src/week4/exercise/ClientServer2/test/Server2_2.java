package week4.exercise.ClientServer2.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2_2 {
    public static void main(String[] args) {
        int serverPort = 1234;
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[2048];
            int readBytes = inputStream.read(bytes);
            String[] numberArray = new String(bytes,0,readBytes).split(",");

            int result = 0;
            for (String number : numberArray) {
                result += Integer.parseInt(number);
            }

            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
