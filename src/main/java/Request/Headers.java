package Request;

import lombok.Getter;

import java.util.HashMap;

public class Headers {
     private final HashMap<String, String> mapper ;
     Headers(String[] headerString) {
         mapper = new HashMap<>();
         for (String header : headerString) {
             String[] tmp = header.split(":", 2);

             mapper.put(tmp[0], tmp[1]);
         }
     }
     public String getHeaderByKey(String key) {
         return mapper.getOrDefault(key, null);
     }
    @Override
    public String toString() {
        return "Headers{" +
                "mapper=" + mapper +
                '}';
    }
}
