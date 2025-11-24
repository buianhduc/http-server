package Request;

import core.HttpVersion;
import core.Method;
import core.URI;
import lombok.Getter;

import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Logger;

@Getter
public class RequestHeader {
    private Method method;
    private HttpVersion httpVersion;
    private URI uri;

    public RequestHeader(Method method, HttpVersion httpVersion, URI uri) {
        this.method = method;
        this.httpVersion = httpVersion;
        this.uri = uri;
    }
    public RequestHeader(String requestHeader) {
        assert !requestHeader.isEmpty();
        String[] result = requestHeader.split(" ");

        if (result.length != 3)
            throw new IllegalArgumentException("Request header needs 3 arguments <Method> <URI> <HttpVersion>"
                    + "\n Request header provided" + requestHeader);
        this.method = new Method(result[0].toUpperCase());
        this.httpVersion = new HttpVersion(result[2]);
        this.uri = new URI(result[1]);
    }

    @Override
    public String toString() {
        return "RequestHeader{" +
                "method=" + method +
                ", httpVersion=" + httpVersion +
                ", uri=" + uri +
                '}';
    }
}
