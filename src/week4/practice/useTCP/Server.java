package week4.practice.useTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    public static void main(String[] args) throws IOException {

    }

    @Override
    public void run() {
        try {
            int serverPort = 8080;
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server is running and waiting for connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            InputStream reader = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = reader.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message from client: " + message);

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
