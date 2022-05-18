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
public class MyHTTPAthleteRESTCaliculatedHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        AthleteCaliculatedModel athleteCaliculatedModel = new AthleteCaliculatedModel("1");
        ArrayList<AthleteCaliculated> athletesCaliculated = athleteCaliculatedModel.getAthletesCaliculated();
        ObjectMapper mapper = new ObjectMapper();
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, mapper.writerWithDefaultPrettyPrinter().writeValueAsString(athletesCaliculated).length());
        OutputStream os = exchange.getResponseBody();
        os.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(athletesCaliculated).getBytes());
        os.close();
    }
}
