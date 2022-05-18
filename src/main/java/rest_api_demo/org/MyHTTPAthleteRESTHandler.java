package rest_api_demo.org;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Klase atsakinga uz Athlet's REST'api, atvaizduoja DATABASE irasus JSON formatu
 * Spring @Controller atitikmuo
 */
public class MyHTTPAthleteRESTHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        AthleteModel athleteModel = new AthleteModel("1");
        ArrayList<Athlete> athletes = athleteModel.ReadFromDatabase();
        ObjectMapper mapper = new ObjectMapper();
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, mapper.writerWithDefaultPrettyPrinter().writeValueAsString(athletes).length());
        OutputStream os = exchange.getResponseBody();
        os.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(athletes).getBytes());
        os.close();
    }
}
