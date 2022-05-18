package rest_api_demo.org;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyHTTPTableHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String tableFileContent = Files.readString(Path.of(Settings.HTML_HEADER.value)) +
                Files.readString(Path.of(Settings.HTML_TABLE.value)) +
                Files.readString(Path.of(Settings.HTML_MENU.value)) +
                Files.readString(Path.of(Settings.HTML_FOOTER.value));
        exchange.sendResponseHeaders(200, tableFileContent.length());
        OutputStream os = exchange.getResponseBody();
        os.write(tableFileContent.getBytes());
        os.close();
    }
}
