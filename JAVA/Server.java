import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket listening on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is running and waiting for client...");

            //  Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            //  Create I/O streams for communication
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            //  Receive and respond
            String message = input.readLine();
            System.out.println("Client says: " + message);
            output.println("Message received by server.");

            //  Close all connections
            input.close();
            output.close();
            socket.close();
            serverSocket.close();
            System.out.println("Server closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
