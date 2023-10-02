package codes.dreaming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    Integer port;

    public Server(Integer port) {
        this.port = port;
    }

    public void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is running on port " + port);
        System.out.println("Server IP address: " + serverSocket.getInetAddress().getHostAddress());

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter socketOutput = new PrintWriter(socket.getOutputStream(), true);

            String inputLine = socketInput.readLine();

            // Sending back to the client the received string but in uppercase
            if (inputLine != null) {
                socketOutput.println(inputLine.toUpperCase());
            }

            // Close the resources
            socketOutput.close();
            socketInput.close();
            socket.close();
        }
    }
}
