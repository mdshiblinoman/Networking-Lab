import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String message = dis.readUTF();
                System.out.println("Message: " + message);

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Client requested to exit. Closing connection.");
                    break;
                }

                String response = scanner.nextLine();

                String messageToSend = "Server: " + response;
                dos.writeUTF(messageToSend);
                dos.flush();
            } catch (Exception e) {
                System.out.println("Client disconnected.");
                break;
            }
        }

        scanner.close();
        dis.close();
        socket.close();
        serverSocket.close();
    }
}
