import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpChatClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port);
                BufferedReader serverInput = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                BufferedReader keyboardInput = new BufferedReader(
                        new InputStreamReader(System.in));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to server.");

            while (true) {
                System.out.print("Client: ");
                String message = keyboardInput.readLine();
                output.println(message);

                String reply = serverInput.readLine();
                if (reply == null) {
                    break;
                }

                System.out.println("Server: " + reply);
                if (message.equalsIgnoreCase("bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
