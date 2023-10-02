package codes.dreaming;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create a CLI gui to select between server and client
        System.out.println("Would you like to run a server or a client?");
        System.out.println("1. Server");
        System.out.println("2. Client");

        // Get the user's input
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input == 1) {
            // Ask the user for the port
            System.out.println("Please enter the port to run the server on:");
            int port = scanner.nextInt();

            // Initialize the server
            Server server = new Server(port);
            // Run the server
            server.run();
        } else {
            // Ask the user for the host and port
            System.out.println("Please enter the host to connect to:");
            String host = scanner.next();
            System.out.println("Please enter the port to connect to:");
            int port = scanner.nextInt();

            // Initialize the client
            Client client = new Client(host, port);
            // Run the client
            client.run();
        }
        System.out.println("Exiting...");
    }
}
