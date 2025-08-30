package exp1;

import java.io.*;
import java.net.*;

public class RPCServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress());

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                int num1 = dis.readInt();
                int num2 = dis.readInt();

                int sum = num1 + num2;

                dos.writeInt(sum);
                dos.flush();

                System.out.println("Addition request: " + num1 + " + " + num2 + " = " + sum);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}