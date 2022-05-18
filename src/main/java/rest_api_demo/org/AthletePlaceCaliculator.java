package rest_api_demo.org;

import java.util.*;

/**
 * Klase skirta apskaiciuoti kiekvieno atleto vieta rezutatu lenetleje.
 * Formule: Fencing.Vieta rezultatu lenteleje +
 *          Riding.Vieta rezultatu lenteleje +
 *          Shooting.Vieta rezultatu lenteleje +
 *          Swiming.Vieta rezultatu lenteleje +
 *          Running.Vieta rezultatu lenteleje
 *
 * Tas atletas kuris geriausiai (sumoje) pasirode visose disciplinose
 * tures aukstesne vieta galutineje rezultatu lenteleje
 */

public class AthletePlaceCaliculator {
    private ArrayList<Athlete> athletes;
    private LinkedHashMap<Athlete,Integer> totalResultTable;

    private ArrayList<AthleteCaliculated> athletesCaliculated;

    public AthletePlaceCaliculator(ArrayList<Athlete> athletes) {
        this.athletes = athletes;
        this.totalResultTable = new LinkedHashMap<>();
        this.athletesCaliculated = new ArrayList<>();
        totalPlaceMap();
    }

    public AthleteCaliculated getAthleteCaliculatedWithPlaces(Athlete athlete){
        HashMap<Athlete,Integer> fencingResultTable = orderResultsTableByDisciplineDesc(
                resultsByDiscipline("FENCING"));
        HashMap<Athlete,Integer> ridingResultTable = orderResultsTableByDisciplineAsc(
                resultsByDiscipline("RIDING"));
        HashMap<Athlete,Integer> shootingResultTable = orderResultsTableByDisciplineDesc(
                resultsByDiscipline("SHOOTING"));
        HashMap<Athlete,Integer> swimingResultTable = orderResultsTableByDisciplineAsc(
                resultsByDiscipline("SWIMMING"));
        HashMap<Athlete,Integer> runningResultTable = orderResultsTableByDisciplineAsc(
                resultsByDiscipline("RUNNING"));
        return new AthleteCaliculated(athlete.getAthleteName(),this.totalResultTable.get(athlete),
                fencingResultTable.get(athlete),swimingResultTable.get(athlete),
                ridingResultTable.get(athlete),shootingResultTable.get(athlete),
                runningResultTable.get(athlete));
    }

    public void totalPlaceMap(){
        LinkedHashMap<Athlete,Integer> fencingResultTable = orderResultsTableByDisciplineDesc(
                resultsByDiscipline("FENCING"));
        LinkedHashMap<Athlete,Integer> ridingResultTable = orderResultsTableByDisciplineAsc(
                resultsByDiscipline("RIDING"));
        LinkedHashMap<Athlete,Integer> shootingResultTable = orderResultsTableByDisciplineDesc(
                resultsByDiscipline("SHOOTING"));
        LinkedHashMap<Athlete,Integer> swimingResultTable = orderResultsTableByDisciplineAsc(
                resultsByDiscipline("SWIMMING"));
        LinkedHashMap<Athlete,Integer> runningResultTable = orderResultsTableByDisciplineAsc(
                resultsByDiscipline("RUNNING"));
        HashMap<Athlete,Integer> totalResultTablePoints = new HashMap<>();
        for (Athlete ath: athletes) {
            totalResultTablePoints.put(ath,fencingResultTable.get(ath)+swimingResultTable.get(ath)+
                    ridingResultTable.get(ath)+shootingResultTable.get(ath)+
                    runningResultTable.get(ath));
        }
        this.totalResultTable = orderResultsTableByDisciplineAsc(totalResultTablePoints);
    }

    public HashMap<Athlete,Integer> resultsByDiscipline(String discipline){
        HashMap<Athlete,Integer> resultTableByDiscipline = new HashMap<>();
        for (Athlete ath: athletes) {
            switch (discipline){
                case "FENCING":
                     resultTableByDiscipline.put(ath, ath.getFencingVictories());
                     break;
                case "RIDING":
                     resultTableByDiscipline.put(ath,ath.getRidingDisobedianceLeading()+
                     ath.getRidingKnockingDown()+
                     ath.getRidingRefusing());
                     break;
                case "SHOOTING":
                     resultTableByDiscipline.put(ath,ath.getShootingTargetScore());
                     break;
                case "SWIMMING":
                     resultTableByDiscipline.put(ath,Integer.valueOf(
                             ath.getSwimingTime().replaceAll("[:.]", "")));
                     break;
                case "RUNNING":
                     resultTableByDiscipline.put(ath,Integer.valueOf(
                             ath.getRunTime().replaceAll("[:.]", "")));
                     break;
                default:
            }
        }
        return resultTableByDiscipline;
    }

    public LinkedHashMap<Athlete,Integer> orderResultsTableByDisciplineDesc(HashMap<Athlete,Integer> resultTable){
        LinkedHashMap<Athlete,Integer> sortedAthletesResult = new LinkedHashMap<>();
        int place = resultTable.size();
        List<Map.Entry<Athlete, Integer>> list
                = new LinkedList<Map.Entry<Athlete, Integer>>
                (resultTable.entrySet());
        Collections.sort(list,(i1,i2) -> i1.getValue().compareTo(i2.getValue()));
        for (Map.Entry<Athlete, Integer> el : list) {
            sortedAthletesResult.put(el.getKey(),place);
            place--;
        }
        return sortedAthletesResult;
    }

    public LinkedHashMap<Athlete,Integer> orderResultsTableByDisciplineAsc(HashMap<Athlete,Integer> resultTable){
        LinkedHashMap<Athlete,Integer> sortedAthletesResult = new LinkedHashMap<>();
        int place = 1;
        List<Map.Entry<Athlete, Integer>> list
                = new LinkedList<Map.Entry<Athlete, Integer>>
                (resultTable.entrySet());
        Collections.sort(list,(i1,i2) -> i1.getValue().compareTo(i2.getValue()));
        for (Map.Entry<Athlete, Integer> el : list) {
            sortedAthletesResult.put(el.getKey(),place);
            place++;
        }
        return sortedAthletesResult;
    }

    public LinkedHashMap<Athlete, Integer> getTotalResultTable() {
        return totalResultTable;
    }
}
