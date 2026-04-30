import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {

        Socket s2 = new Socket("localhost", 7777);
        DataOutputStream ds2 = new DataOutputStream(s2.getOutputStream());
        DataInputStream dis = new DataInputStream(s2.getInputStream());
        Scanner scanner = new Scanner(System.in);

        String message;

        while (true) {
            System.out.print("Enter message: ");
            message = scanner.nextLine();
            ds2.writeUTF(message);
            ds2.flush();

            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            String msg = dis.readUTF();
            System.out.println("Received from server: " + msg);
        }

        scanner.close();
        ds2.close();
        s2.close();
        System.out.println("Connection closed.");
    }

}
