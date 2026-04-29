import java.io.*;
import javax.net.ssl.*;
import java.util.Base64;

class CCEmail {

    private static DataOutputStream dos;
    private static BufferedReader br;

    public static void main(String[] args) throws Exception {

        String fromEmail = "enter_your_gmail@gmail.com";
        String password = "enter_your_app_password";
        String toEmail = "enter_to_email@gmail.com";
        String ccEmail = "enter_cc_email@gmail.com";

        String username = Base64.getEncoder().encodeToString(fromEmail.getBytes());
        String pass = Base64.getEncoder().encodeToString(password.getBytes());

        SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault()
                .createSocket("smtp.gmail.com", 465);

        dos = new DataOutputStream(socket.getOutputStream());
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        readLine(); // Server greeting

        send("EHLO smtp.gmail.com\r\n");
        readEHLO();

        send("AUTH LOGIN\r\n");
        readLine(); // 334 username prompt

        send(username + "\r\n");
        readLine(); // 334 password prompt

        send(pass + "\r\n");
        readLine(); // 235 authentication success

        send("MAIL FROM:<" + fromEmail + ">\r\n");
        readLine();

        send("RCPT TO:<" + toEmail + ">\r\n");
        readLine();

        send("RCPT TO:<" + ccEmail + ">\r\n");
        readLine();

        send("DATA\r\n");
        readLine();

        send("From: " + fromEmail + "\r\n");
        send("To: " + toEmail + "\r\n");
        send("Cc: " + ccEmail + "\r\n");
        send("Subject: Test Email with CC\r\n");
        send("\r\n");

        send("Hello,\r\n");
        send("This is a test email using Java SMTP.\r\n");
        send("Regards,\r\nJava Program\r\n");

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
            throw new RuntimeException("Server closed connection (Broken pipe root cause)");
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