import java.io.*;
import javax.net.ssl.*;
import java.util.Base64;

public class BCCEmail {

    public static void main(String[] args) throws Exception {

        String fromEmail = "s2210776130@ru.ac.bd";
        String password = "adfe";
        String toEmail = "naimur.ru.cse@gmail.com";
        String ccEmail = "ek369542@gmail.com";

        String username = Base64.getEncoder().encodeToString(fromEmail.getBytes());
        String pass = Base64.getEncoder().encodeToString(password.getBytes());

        SSLSocket socket = (SSLSocket) SSLSocketFactory
                .getDefault()
                .createSocket("smtp.gmail.com", 465);

        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        // Server greeting
        br.readLine();

        send(dos, "EHLO localhost\r\n");

        send(dos, "AUTH LOGIN\r\n");
        br.readLine();

        send(dos, username + "\r\n");
        br.readLine();

        send(dos, pass + "\r\n");
        br.readLine();

        // Sender
        send(dos, "MAIL FROM:<" + fromEmail + ">\r\n");

        // TO (visible)
        send(dos, "RCPT TO:<" + toEmail + ">\r\n");

        // BCC (hidden)
        send(dos, "RCPT TO:<" + ccEmail + ">\r\n");

        send(dos, "DATA\r\n");
        br.readLine();

        // Headers (NO BCC here ❌)
        send(dos, "From: " + fromEmail + "\r\n");
        send(dos, "To: " + toEmail + "\r\n");
        send(dos, "Subject: BCC Email Test\r\n");
        send(dos, "MIME-Version: 1.0\r\n");
        send(dos, "Content-Type: text/plain\r\n");
        send(dos, "\r\n");

        // Body
        send(dos, "Hello,\r\nThis is a proper BCC email test.\r\n");

        // End of message
        send(dos, ".\r\n");
        br.readLine();

        send(dos, "QUIT\r\n");

        socket.close();
    }

    private static void send(DataOutputStream dos, String msg) throws Exception {
        dos.writeBytes(msg);
        dos.flush();
        System.out.println("CLIENT: " + msg);
    }
}