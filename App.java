import java.util.Dictionary;
import java.util.Hashtable;

public class App {

        Dictionary<String, Athlete> players = new Hashtable<>();
        Dictionary<String, Dictionary> playersWeeklySymptoms = new Hashtable<>();



    public void addAthlete(String name){

        if (players.get(name) == null){
            Athlete new_athlete= new Athlete(name);
            players.put(name,new_athlete);
            System.out.printf("player %s was added %n", name);
        }
        else{
            System.out.printf("player %s already exists %n", name);
        }

    }

    public void addEvaluation(String name, int week_num){
        if (players.get(name) == null){
            System.out.printf("player %s does not exist, need to add player %n", name);
        }
        else{
            players.get(name).evaluate(week_num);
        }
        this.playersWeeklySymptoms.put(name,players.get(name).symptomStorage);

    }





}
