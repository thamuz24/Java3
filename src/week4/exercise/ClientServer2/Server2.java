package week4.exercise.ClientServer2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 implements Runnable{
    public static void main(String[] args) {
        Server2 server = new Server2();
        Client2 client = new Client2();

        Thread thread1 = new Thread(server);
        Thread thread2 = new Thread(client);


        thread1.start();
        thread2.start();
    }
    @Override
    public void run() {
        try{
            int serverPort = 8080;
            ServerSocket serverSocket = new ServerSocket(serverPort);
            Socket socket = serverSocket.accept();

            takeByClient(socket);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int takeByClient(Socket socket) throws IOException {
        InputStream reader = socket.getInputStream();

        byte[] buffer = new byte[1024];
        int bytesRead = reader.read(buffer);
        String[] numberArray = (new String(buffer,0,bytesRead)).split(",");
        int result = 0;
        for (String number : numberArray) {
            result += Integer.parseInt(number);
        }
        returnToClient(socket,result);
        return result;
    }

    public static void returnToClient(Socket socket, int results) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(results);
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
