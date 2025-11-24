package core;

public class URI {
    private String uri;
    public URI(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "URI{" +
                "uri='" + uri + '\'' +
                '}';
    }
}
