import java.io.*;
import javax.net.ssl.*;
import java.util.Base64;

public class BCCEmail {

    private static DataOutputStream dos;
    private static BufferedReader br;

    public static void main(String[] args) throws Exception {

        String fromEmail = "enter_your_gmail@gmail.com"; // ✅ Gmail use করো
        String appPassword = "enter_your_app_password"; // ✅ App Password

        String toEmail = "enter_to_email@gmail.com"; // ✅ TO
        String ccEmail = "enter_cc_email@gmail.com"; // ✅ CC
        String bccEmail = "enter_bcc_email@gmail.com"; // ✅ BCC

        String username = Base64.getEncoder().encodeToString(fromEmail.getBytes());
        String password = Base64.getEncoder().encodeToString(appPassword.getBytes());

        SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault()
                .createSocket("smtp.gmail.com", 465);

        dos = new DataOutputStream(socket.getOutputStream());
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        readLine(); // 220

        send("EHLO smtp.gmail.com\r\n");
        readEHLO();

        send("AUTH LOGIN\r\n");
        readLine();

        send(username + "\r\n");
        readLine();

        send(password + "\r\n");
        readLine(); // 235 success

        send("MAIL FROM:<" + fromEmail + ">\r\n");
        readLine();

        // ✅ TO
        send("RCPT TO:<" + toEmail + ">\r\n");
        readLine();

        // ✅ CC
        send("RCPT TO:<" + ccEmail + ">\r\n");
        readLine();

        // ✅ BCC (hidden)
        send("RCPT TO:<" + bccEmail + ">\r\n");
        readLine();

        send("DATA\r\n");
        readLine();

        // ✅ Headers
        send("From: " + fromEmail + "\r\n");
        send("To: " + toEmail + "\r\n");
        send("Cc: " + ccEmail + "\r\n");
        send("Subject: Test Email (CC + BCC)\r\n");
        send("\r\n");

        // ✅ Body
        send("Hello,\r\n");
        send("This is a test email sent using Java SMTP.\r\n");
        send("CC and BCC are included.\r\n");
        send("Regards,\r\nShibli\r\n");

        send(".\r\n");
        readLine();

        send("QUIT\r\n");
        readLine();

        socket.close();
    }

    private static void send(String s) throws Exception {
        dos.writeBytes(s);
        dos.flush();
        System.out.print("CLIENT: " + s);
        Thread.sleep(200);
    }

    private static void readLine() throws Exception {
        String line = br.readLine();
        if (line == null) {
            throw new RuntimeException("Server closed connection");
        }
        System.out.println("SERVER: " + line);
    }

    private static void readEHLO() throws Exception {
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("SERVER: " + line);
            if (line.length() > 3 && line.charAt(3) == ' ')
                break;
        }
    }
}