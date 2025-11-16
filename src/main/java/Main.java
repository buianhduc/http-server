import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
  public static void main(String[] args) {
    // You can use print statements as follows for debugging, they'll be visible when running tests.
    System.out.println("Logs from your program will appear here!");

      try (ServerSocket serverSocket = new ServerSocket(4221)) {
        // Since the tester restarts your program quite often, setting SO_REUSEADDR
        // ensures that we don't run into 'Address already in use' errors
        serverSocket.setReuseAddress(true);

        Socket clientSocket = serverSocket.accept(); // Wait for connection from client.
        Client client = new Client(clientSocket);
        Request request = client.getRequest();
        if (request.getMethod().equals("GET") && request.getUrl().equals("/")) {
          client.sendMessage("HTTP/1.1 200 OK\r\n\r\n");
        } else {
          client.sendMessage("HTTP/1.1 404 Not Found\r\n\r\n");
        }
        serverSocket.close();
        client.closeSocket();


      } catch (IOException e) {
        e.printStackTrace();
      }


  }
}
