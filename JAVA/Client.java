import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            //  Connect to server at localhost on port 5000
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server.");

            // Create I/O streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            //  Send message to server
            output.println("Hello Server!");

            //  Receive response
            String response = input.readLine();
            System.out.println("Server says: " + response);

            //  Close resources
            input.close();
            output.close();
            socket.close();
            System.out.println("Client closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
