package week4.exercise.CheckIP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Use implements Runnable {
    @Override
    public void run() {
        String severIP = "127.0.0.1";
        int severPort = 8080;
        try {
            Socket socket = new Socket(severIP,severPort);
            Scanner input = new Scanner(System.in);
            String IPInput = input.next();
            OutputStream outputStream = socket.getOutputStream();

            outputStream.write(IPInput.getBytes());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
