package codes.dreaming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    String host;
    Integer port;

    public Client(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws IOException {
        // Open a socket to the server
        Socket socket = new Socket(host, port);
        PrintWriter socketOutput = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Ask the user for a string
        System.out.println("Please enter a string to send to the server:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        // Send the string to the server
        socketOutput.println(userInput);

        // Get the response from the server
        String response = socketInput.readLine();

        // Print the response
        System.out.println("Response from server: " + response);
    }
}
