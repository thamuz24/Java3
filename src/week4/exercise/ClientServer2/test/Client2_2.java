package week4.exercise.ClientServer2.test;

import week4.practice.useTCP.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2_2 {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int serverPort = 1234;
        Socket socket = new Socket(serverIP, serverPort);

        Scanner scanner = new Scanner(System.in);
        String number = "";
        System.out.println("nhap so dau tien: ");
        number  += scanner.next() + ",";
        System.out.println("nhap so thu hai: ");
        number += scanner.next();

        System.out.println(number);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(number.getBytes());

        socket.close();
    }
}
