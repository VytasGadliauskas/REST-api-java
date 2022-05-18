package rest_api_demo.org;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *   Klase atsakinga uz img atvaizdavima
 *   Spring @Controller  atitikmuo
 */

public class MyHTTPImageReturn  implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        File imageFilename = new File(Settings.IMAGE.value);
        byte[] imageBytes  = new byte [(int)imageFilename.length()];
        FileInputStream fileInputStream = new FileInputStream(imageFilename);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        bufferedInputStream.read(imageBytes, 0, imageBytes.length);
        exchange.getResponseHeaders().set("Content-Type", "image/jpg");
        exchange.sendResponseHeaders(200, imageBytes.length);
        OutputStream os = exchange.getResponseBody();
        os.write(imageBytes,0 ,imageBytes.length);
        os.close();
    }
}
