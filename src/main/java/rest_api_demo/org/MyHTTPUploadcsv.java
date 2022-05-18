package rest_api_demo.org;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


/**
 * Klase atsakinga uz uploada csv failo i HTTP serveri ir perdavimo CSVParser'iui
 * Spring @Controller atitikmuo
 */

public class MyHTTPUploadcsv implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        ArrayList<String> requestBody = new ArrayList<>();
        InputStream input = exchange.getRequestBody();
        new BufferedReader(new InputStreamReader(input))
                .lines()
                .forEach(requestBody::add);
        String uploadStatus = "<p class='BAD'> Upload status: uploded not csv file</p>";
        if("Content-Type: text/csv".equals(requestBody.get(2))){
            uploadStatus = "<p class='OK'> Upload status: csv file uploaded</p>";
            @SuppressWarnings("unused")
            CSVParser csvParser = new CSVParser(requestBody);
        }
        String csvFile = String.join("\n", requestBody);
        String responseFileContent = Files.readString(Path.of(Settings.HTML_HEADER.value))+
                "<h1>REST API DEMO</h1>\n" +
                "<hr>"+
                "<div class='file'><pre>"+ csvFile+
                "</pre></div>"+
                uploadStatus+
                "<hr>"+
                Files.readString(Path.of(Settings.HTML_MENU.value))+
                Files.readString(Path.of(Settings.HTML_FOOTER.value));
        exchange.sendResponseHeaders(200, responseFileContent.length());
        OutputStream os = exchange.getResponseBody();
        os.write(responseFileContent.getBytes());
        os.close();
    }
}
