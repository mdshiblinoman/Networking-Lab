import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {

        Socket s2 = new Socket("localhost", 7777);
        DataOutputStream ds2 = new DataOutputStream(s2.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        String message;

        while (true) {
            System.out.print("Enter message: ");
            message = scanner.nextLine();

            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            ds2.writeUTF(message);
            ds2.flush();
        }

        scanner.close();
        ds2.close();
        s2.close();
        System.out.println("Connection closed.");
    }
}
