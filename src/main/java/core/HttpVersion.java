package core;

import lombok.Getter;

@Getter
public class HttpVersion {
    private final int major;
    private final int minor;
    public HttpVersion(String version) {
        String[] splitted = version.trim().split("\\.");
        major = Integer.parseInt(splitted[0].split("/")[1]);
        minor = Integer.parseInt(splitted[1]);
    }

    @Override
    public String toString() {
        return "HttpVersion{" +
                "major=" + major +
                ", minor=" + minor +
                '}';
    }
}
