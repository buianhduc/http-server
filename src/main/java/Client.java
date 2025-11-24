

import Request.Request;
import Request.RequestFactory;

import java.io.*;
import java.net.Socket;
import java.nio.CharBuffer;

public class Client implements Runnable{
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
        StringBuilder message = new StringBuilder();
        String inputLine;

        while (!((inputLine = in.readLine()) == null) && !inputLine.isEmpty()) {
            System.out.println(inputLine);
            message.append(inputLine);
            message.append("\r\n");
        }
        return message.toString();
    }

    public String getBody(int contentLength) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        char[] buf = new char[1024];
        int accLen = 0, len;
        while((len = in.read(buf, 0, Math.min(1024, contentLength - accLen))) != -1 && accLen < contentLength) {
            stringBuilder.append(buf, 0, len);
            accLen += len;
        }
        System.out.println(len);

        return stringBuilder.toString();
    }
    public Request getRequest() throws IOException {
        return RequestFactory.parse(getRequestMessage());
    }
    public void closeSocket() throws IOException {
        clientSocket.close();
    }

    @Override
    public void run() {
        try {
            System.out.println("[Client] " + getRequest());
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
