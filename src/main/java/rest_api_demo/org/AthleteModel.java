package rest_api_demo.org;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Klase skira veiksmams su Athlete's irasais:
 * formuoja Athlete ArrayList'a
 * perduoda saugojimui i DtabaseEngine
 * uzklausia DatabseEngine issaugoto iraso.
 */

public class AthleteModel {
    private ArrayList<Athlete> athletes;
    private String id;

    public AthleteModel(String id) {
        this.athletes = new ArrayList<>();
        this.id = id;
    }

    public ArrayList<Athlete> ReadFromDatabase() {
        DatabaseEngine databaseEngine = new DatabaseEngine();
        return (ArrayList<Athlete>) databaseEngine.ReadObjectFromDatabase();
    }

    public void WriteToDatabase() {
        DatabaseEngine databaseEngine = new DatabaseEngine();
        databaseEngine.WriteObjectToDatabase(this.athletes);
    }

    public void AddAthlete(Athlete athlete) {
        this.athletes.add(athlete);
    }

    public void RemoveAthlete(Athlete athlete) {
        this.athletes.remove(athlete);
    }
}


