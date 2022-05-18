package rest_api_demo.org;

import java.util.ArrayList;

/**
 * Klase atsakinga uz gaudo HTTP requesto parsinima
 * gautas csv failas konvertuojamas i Athlete klases
 * masyva ir perduoda i AthleteModel
 */
public class CSVParser {
    public CSVParser(ArrayList<String> uploadRequest) {
        if (uploadRequest.size() > 6) {
            AthleteModel athleteModel = new AthleteModel("1");
            for (int i = 0; i < uploadRequest.size() - 1; i++) {
                if (i > 5 && i < uploadRequest.size() - 1) {
                    if (!"".equals(uploadRequest.get(i))) {
                        String[] line = uploadRequest.get(i).split(",");
                        if (line.length == 8) {
                            Athlete athlete = new Athlete(line[0], Integer.valueOf(line[1]), line[2],
                                    Integer.valueOf(line[3]), Integer.valueOf(line[4]),
                                    Integer.valueOf(line[5]), Integer.valueOf(line[6]), line[7]);
                            athleteModel.AddAthlete(athlete);
                        } else {
                            System.out.println("CSVParse error on csvfile line " + (i - 5) + " not enogth columns " + line.length);
                        }
                    }
                }
            }
            athleteModel.WriteToDatabase();
        } else {
            System.out.println("CSV uploded file parse error");
            System.out.println("uploded csv file lines count: " + uploadRequest.size());
            uploadRequest.forEach(el -> System.out.println(el));
        }
    }
}
