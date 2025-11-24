package core;

public class Method {
    private MethodTypes method;
    public enum MethodTypes {
        GET,
        POST,
        PUT,
        DELETE,
        TRACE,
        HEAD,
        OPTIONS
    }
    public Method(MethodTypes method)
    {
        this.method = method;
    }
    public Method(String method) throws IllegalArgumentException {
        this.method = MethodTypes.valueOf(method.toUpperCase());
    }

    @Override
    public String toString() {
        return "Method{" +
                "method=" + method +
                '}';
    }
}