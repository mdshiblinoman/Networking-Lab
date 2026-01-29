import java.io.*;
import javax.net.ssl.*;
import java.util.Base64;

class CCEmail {

    private static DataOutputStream dos;
    private static BufferedReader br;

    public static void main(String[] args) throws Exception {

        // ====== CHANGE THESE ======
        String fromEmail = "yourmail@gmail.com";
        String password = "your_app_password"; // Gmail App Password
        String toEmail = "receiver@gmail.com";
        String ccEmail = "ccreceiver@gmail.com";
        // ==========================

        String username = Base64.getEncoder().encodeToString(fromEmail.getBytes());
        String pass = Base64.getEncoder().encodeToString(password.getBytes());

        SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault()
                .createSocket("smtp.gmail.com", 465);

        dos = new DataOutputStream(socket.getOutputStream());
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("SERVER: " + br.readLine());

        send("EHLO smtp.gmail.com\r\n");
        readResponse();

        send("AUTH LOGIN\r\n");
        System.out.println("SERVER: " + br.readLine());

        send(username + "\r\n");
        System.out.println("SERVER: " + br.readLine());

        send(pass + "\r\n");
        System.out.println("SERVER: " + br.readLine());

        send("MAIL FROM:<" + fromEmail + ">\r\n");
        System.out.println("SERVER: " + br.readLine());

        send("RCPT TO:<" + toEmail + ">\r\n");
        System.out.println("SERVER: " + br.readLine());

        send("RCPT TO:<" + ccEmail + ">\r\n"); // ✅ CC recipient
        System.out.println("SERVER: " + br.readLine());

        send("DATA\r\n");
        System.out.println("SERVER: " + br.readLine());

        // ====== EMAIL HEADERS ======
        send("FROM: " + fromEmail + "\r\n");
        send("TO: " + toEmail + "\r\n");
        send("CC: " + ccEmail + "\r\n");
        send("Subject: Test Email with CC\r\n");
        send("\r\n"); // blank line between headers and body

        // ====== EMAIL BODY ======
        send("Hello,\r\n");
        send("This is a test email sent using Java SMTP with CC support.\r\n");
        send("Regards,\r\nJava Program\r\n");

        send(".\r\n"); // end of DATA
        System.out.println("SERVER: " + br.readLine());

        send("QUIT\r\n");
        System.out.println("SERVER: " + br.readLine());

        socket.close();
    }

    private static void send(String s) throws Exception {
        dos.writeBytes(s);
        dos.flush();
        System.out.print("CLIENT: " + s);
        Thread.sleep(500);
    }

    private static void readResponse() throws Exception {
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("SERVER: " + line);
            if (line.startsWith("250 "))
                break;
        }
    }
}
