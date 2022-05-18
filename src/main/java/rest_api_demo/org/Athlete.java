package rest_api_demo.org;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Klase skirta aprasyti Athlete objekta saugomo improvizuotoje DATABASE.
 * Spring @Entity atitikmuo
 */
@Getter
@Setter
public class Athlete implements Serializable {
    private String athleteName;
    private int fencingVictories;
    private String swimingTime;
    private int ridingKnockingDown;
    private int ridingRefusing;
    private int ridingDisobedianceLeading;
    private int shootingTargetScore;
    private String runTime;


    public Athlete(String athleteName, int fencingVictories, String swimingTime,
                   int ridingKnockingDown, int ridingRefusing, int ridingDisobedianceLeading,
                   int shootingTargetScore, String runTime) {
        this.athleteName = athleteName;
        this.fencingVictories = fencingVictories;
        this.swimingTime = swimingTime;
        this.ridingKnockingDown = ridingKnockingDown;
        this.ridingRefusing = ridingRefusing;
        this.ridingDisobedianceLeading = ridingDisobedianceLeading;
        this.shootingTargetScore = shootingTargetScore;
        this.runTime = runTime;
    }
}
