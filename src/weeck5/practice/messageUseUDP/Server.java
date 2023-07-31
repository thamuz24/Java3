package weeck5.practice.messageUseUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {
        try {
            String serverPort = "127.0.0.1";
            int port = 8080;

            DatagramSocket ds = new DatagramSocket(8080);
            System.out.println("Server run....");

            byte[] receiveData =  new byte[1024];

            DatagramPacket dp = new DatagramPacket(receiveData,receiveData.length);

            ds.receive(dp);

            InetAddress clientAddress = dp.getAddress();
            int clientPort = dp.getPort();

            String message = new String(dp.getData(),0, dp.getLength());
            System.out.println("Received from data: " + message);

            String responseMessage = "Hello, client!";
            byte[] sentData = responseMessage.getBytes();

            DatagramPacket sentPacket = new DatagramPacket(sentData,sentData.length);
            sentPacket.setAddress(clientAddress);
            sentPacket.setPort(clientPort);
            ds.send(sentPacket);
            ds.close();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
