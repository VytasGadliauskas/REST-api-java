package rest_api_demo.org;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Klase skirta atlikti veiksmus su AthleteCaliculated objektu
 */
public class AthleteCaliculatedModel {
    private ArrayList<AthleteCaliculated> athletesCaliculated;
    private ArrayList<Athlete> athletes;
    private String id;

    public AthleteCaliculatedModel(String id) {
        this.athletesCaliculated = new ArrayList<>();
        this.id = id;
        this.athletes = this.ReadFromDatabase();
        Caliculations();
    }

    public ArrayList<AthleteCaliculated> getAthletesCaliculated() {
        return athletesCaliculated;
    }

    public void Caliculations(){
        AthletePlaceCaliculator athletePlaceCaliculator =
                new AthletePlaceCaliculator(this.athletes);
        LinkedHashMap<Athlete,Integer> totalResultTable  = athletePlaceCaliculator.getTotalResultTable();
        totalResultTable.forEach((key, value) -> {
            System.out.println(key.getAthleteName()+" "+value);
            athletesCaliculated.add(athletePlaceCaliculator.getAthleteCaliculatedWithPlaces(key));
        });
    }

    public ArrayList<Athlete> ReadFromDatabase() {
        DatabaseEngine databaseEngine = new DatabaseEngine();
        return (ArrayList<Athlete>) databaseEngine.ReadObjectFromDatabase();
    }
}
