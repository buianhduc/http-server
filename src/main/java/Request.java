import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {
    private String method, url, version;
    private String body;
    public Request(String request) {
        String[] args = request.split(" ");
        this.method = args[0];
        this.url = args[1];
        this.version = args[2];
    }

}
