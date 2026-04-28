import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class client {

    public static void main(String[] args) throws Exception {

        Socket s2 = new Socket("localhost", 7777);
        DataOutputStream ds2 = new DataOutputStream(s2.getOutputStream());

        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = now.format(format);

        // Combine message with date
        String message = "How Are You?? | Date: " + dateTime;

        ds2.writeUTF(message);

        s2.close();
    }
}