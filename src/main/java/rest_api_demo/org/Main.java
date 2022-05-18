package rest_api_demo.org;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            @SuppressWarnings("unused")
            MyHTTPServer myhttpServer = new MyHTTPServer(Integer.valueOf(Settings.HTTP_PORT.value));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
