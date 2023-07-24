package week4.practice;

import java.io.IOException;
import java.net.InetAddress;

public class NetWorkingUseInetAddress {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("www.example.com");
        String ipAddress = inetAddress.getHostName();
        System.out.println("IP Address " + ipAddress);

        String hostName = inetAddress.getHostName();
        System.out.println("Host name " + hostName);

        boolean reachable  = inetAddress.isReachable(10000);
        System.out.println("Reachable " + reachable);
    }
}
