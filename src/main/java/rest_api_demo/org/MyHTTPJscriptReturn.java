package rest_api_demo.org;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *   Klase atsakinga uz java scripto grazinima
 *   Spring @Controller  atitikmuo
 */
public class MyHTTPJscriptReturn implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String jscriptFileContent = Files.readString(Path.of(Settings.JAVA_SCRIPT.value));
        exchange.sendResponseHeaders(200, jscriptFileContent.length());
        OutputStream os = exchange.getResponseBody();
        os.write(jscriptFileContent.getBytes());
        os.close();
    }
}
