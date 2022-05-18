package rest_api_demo.org;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Klase skirta aprasyti Athlete apskaiciuotu rezultatu objekta saugojimui.
 *
 */
@Getter
@Setter
public class AthleteCaliculated {
    private String athleteName;
    private int totalPlace;
    private int fencingPlace;
    private int swimingPlace;
    private int ridingPlace;
    private int shootingPlace;
    private int runPlace;

    public AthleteCaliculated(String athleteName, int totalPlace, int fencingPlace,
                              int swimingPlace, int ridingPlace,
                              int shootingPlace, int runPlace) {
        this.totalPlace = totalPlace;
        this.athleteName = athleteName;
        this.fencingPlace = fencingPlace;
        this.swimingPlace = swimingPlace;
        this.ridingPlace = ridingPlace;
        this.shootingPlace = shootingPlace;
        this.runPlace = runPlace;
    }
}
