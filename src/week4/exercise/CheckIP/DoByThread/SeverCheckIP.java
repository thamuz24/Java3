package week4.exercise.CheckIP.DoByThread;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;

public class SeverCheckIP implements Runnable {
    public static void main(String[] args) {
        SeverCheckIP severCheckIP = new SeverCheckIP();
        Use use = new Use();

        Thread thread1 = new Thread(severCheckIP);
        Thread thread2 = new Thread(use);

        thread1.start();
        thread2.start();
    }
    @Override
    public void run() {
        try {
            int severPort = 8080;
            ServerSocket serverSocket = new ServerSocket(severPort);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            int characters;
            String check0_225 = "([1-9]|[1-9][1-9]|1[0-9][0-9]|2[1-4][0-9]|25[0-5])";
            String IP = "";

//            while ((characters = inputStream.read()) == -1) {
//                IP += Character.toString(characters);
//                System.out.println("hi");
//            }

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String message = new String(buffer, 0, bytesRead);

            if (Pattern.matches(check0_225 + "\\." + check0_225 + "\\." + check0_225, message)) {
                System.out.println("IP is true!");
            } else {
                System.out.println("IP is false!");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
