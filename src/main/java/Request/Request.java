package Request;

import core.HttpVersion;
import core.Method;
import core.URI;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Request {

    private RequestHeader requestHeader;
    private byte[] body;
    private Headers headers;

    public Request(String method, String url, String version, byte[] body, String[] headers) {
        requestHeader = new RequestHeader(new Method(method), new HttpVersion(version), new URI(url));
        this.body = body;
        this.headers = new Headers(headers);
    }

    public Request(RequestHeader requestHeader, byte[] body, String[] headers) {
        this.requestHeader = requestHeader;
        this.body = body;
        this.headers = new Headers(headers);;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestHeader=" + requestHeader +
                ", body=" + Arrays.toString(body) +
                ", headers=" + headers +
                '}';
    }
}
