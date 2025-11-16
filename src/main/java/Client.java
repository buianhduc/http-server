import java.io.*;
import java.net.Socket;

public class Client {
    private Socket clientSocket;

    private PrintWriter out;
    private BufferedReader in;
    private String requestMessage;
    private String responseMessage;
    public Client(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void sendMessage(String message) throws IOException {
        out.println(message);
    }
    public String getRequestMessage() throws IOException {
        return in.readLine();
    }

    public Request getRequest() throws IOException {
        return new Request(this.getRequestMessage());
    }
    public void closeSocket() throws IOException {
        clientSocket.close();
    }
}
