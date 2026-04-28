import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(7777);
        System.out.println("Waiting for client...");

        Socket s1 = ss.accept();
        System.out.println("Client connected!");

        DataInputStream ds1 = new DataInputStream(s1.getInputStream());
        String msg = ds1.readUTF();

        System.out.println("Received Message: " + msg);

        s1.close();
        ss.close();
    }
}