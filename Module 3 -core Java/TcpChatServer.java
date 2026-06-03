import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpChatServer {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port + ".");
            System.out.println("Waiting for a client...");

            try (Socket socket = serverSocket.accept();
                    BufferedReader clientInput = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    BufferedReader keyboardInput = new BufferedReader(
                            new InputStreamReader(System.in));
                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

                System.out.println("Client connected.");

                String clientMessage;
                while ((clientMessage = clientInput.readLine()) != null) {
                    System.out.println("Client: " + clientMessage);

                    if (clientMessage.equalsIgnoreCase("bye")) {
                        output.println("Goodbye!");
                        break;
                    }

                    System.out.print("Server: ");
                    String reply = keyboardInput.readLine();
                    output.println(reply);
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
