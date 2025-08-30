package exp1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class RPCClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            dos.writeInt(num1);
            dos.writeInt(num2);
            dos.flush();

            int sum = dis.readInt();
            System.out.println("Sum received from server: " + sum);

            socket.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
