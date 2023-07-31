package weeck5.practice.messageUseUDP;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {

            String serverIP = "localhost";
            int serverPort = 8080;
            DatagramSocket ds = new DatagramSocket();
            String message = "Hello, server!";
            byte[] sendData = message.getBytes();

            InetAddress serverAddress = InetAddress.getByName(serverIP);
            DatagramPacket sendPacket = new DatagramPacket(sendData,0,sendData.length,serverAddress,serverPort);
            ds.send(sendPacket);
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
            ds.receive(receivePacket);

            String receivedMessage = new String(receivePacket.getData(),0,receiveData.length);
            System.out.println("Received message: " + receivedMessage);
            ds.close();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
