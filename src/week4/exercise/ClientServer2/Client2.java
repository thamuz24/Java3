package week4.exercise.ClientServer2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 implements Runnable{
    @Override
    public void run() {
        try {
            String severIP = "127.0.0.1";
            int serverPort = 8080;
            Socket socket = new Socket(severIP,serverPort);

            senToServer(socket);

            takeByServer(socket);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void takeByServer(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        int result = inputStream.read();
        System.out.println("result is: " + result);
    }

    private void senToServer(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        String numberInput = "";
        numberInput += takeNumber("Enter first number: ") + ",";
        numberInput += takeNumber("Enter second number: ");

        outputStream.write(numberInput.getBytes());
    }

    public String takeNumber(String messageToUse) {
        System.out.println(messageToUse);
        Scanner input = new Scanner(System.in);
        return input.next();
    }
}
