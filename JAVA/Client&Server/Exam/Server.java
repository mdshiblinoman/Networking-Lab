import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        DataInputStream dis = new DataInputStream(socket.getInputStream());

        while (true) {
            try {
                String message = dis.readUTF();
                System.out.println("Message: " + message);
            } catch (Exception e) {
                System.out.println("Client disconnected.");
                break;
            }
        }

        dis.close();
        socket.close();
        serverSocket.close();
    }
}
