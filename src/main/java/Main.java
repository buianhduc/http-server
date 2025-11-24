import Request.Request;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Main {
  public static void main(String[] args) {
    // You can use print statements as follows for debugging, they'll be visible when running tests.
    System.out.println("Logs from your program will appear here!");

      try (ServerSocket serverSocket = new ServerSocket(4221)) {
        // Since the tester restarts your program quite often, setting SO_REUSEADDR
        // ensures that we don't run into 'Address already in use' errors
        serverSocket.setReuseAddress(true);

         // Wait for connection from client.
        while (true) {
          Socket clientSocket = serverSocket.accept();
          Thread thread = new Thread(new Client(clientSocket));
          thread.start();

        }




      } catch (IOException e) {
        e.printStackTrace();
      }


  }
}
