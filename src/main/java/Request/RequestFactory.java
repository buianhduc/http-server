package Request;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class RequestFactory {
    public static Request parse(String request) {

        String requestLine;
        List<String> headers = new ArrayList<>();
        String body;

        // Separate body with header
        String[] result = request.split("\r\n\r\n");
        String head = result[0];
        body = result.length > 1 ? result[1] : "";

        // Get the request line
        result = head.split("\r\n");
        requestLine = result[0];
        if (result.length > 1) {
            headers = List.of(Arrays.copyOfRange(result, 1, result.length));
        }

        return new Request(new RequestHeader(requestLine), body.getBytes(), headers.toArray(String[]::new));
    }
}
