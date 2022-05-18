package rest_api_demo.org;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Klase realizuojanti HTTP serveri
 */
public class MyHTTPServer {

    public MyHTTPServer(int http_port) throws IOException {
        System.out.println("HTTP server starting on 0.0.0.0:"+http_port);
        HttpServer server = HttpServer.create(new InetSocketAddress(http_port), 0);
        server.createContext("/", new MyHTTPRootHandler());
        server.createContext("/result", new MyHTTPAthleteRESTHandler());
        server.createContext("/resultcaliculated", new MyHTTPAthleteRESTCaliculatedHandler());
        server.createContext("/table", new MyHTTPTableHandler());
        server.createContext("/uploadcsv", new MyHTTPUploadcsv());
        server.createContext("/image", new MyHTTPImageReturn());
        server.createContext("/jscript", new MyHTTPJscriptReturn());
        server.setExecutor(null);
        server.start();


    }
}
