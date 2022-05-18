import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rest_api_demo.org.Athlete;
import rest_api_demo.org.AthleteModel;
import rest_api_demo.org.DatabaseEngine;

import java.util.ArrayList;

public class RESTapiDemoTest {

    @Test
    void DatabaseEngineTest(){
        Athlete athleteTest1 = new Athlete("Testas1",1,
                "01:01.1",1,1,1,
                1,"01:01:1");
        Athlete athleteTest2 = new Athlete("Testas2",2,
                "02:02.2",2,2,2,
                2,"02:02:2");
        Athlete athleteTest3 = new Athlete("Testas3",3,
                "03:03.3",3,3,3,
                3,"03:03:3");
        AthleteModel athleteModel = new AthleteModel("test");
        ArrayList<Athlete> athletesTest = new ArrayList<>();
        athletesTest.add(athleteTest1);
        athletesTest.add(athleteTest2);
        athletesTest.add(athleteTest3);
        athleteModel.AddAthlete(athleteTest1);
        athleteModel.AddAthlete(athleteTest2);
        athleteModel.AddAthlete(athleteTest3);
        athleteModel.WriteToDatabase();
        ArrayList<Athlete> athletesTest2 = athleteModel.ReadFromDatabase();
        Assertions.assertEquals(athletesTest.get(0).getAthleteName(), athletesTest2.get(0).getAthleteName());
    }




}
