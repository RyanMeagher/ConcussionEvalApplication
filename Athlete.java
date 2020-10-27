
import java.lang.reflect.Array;
import java.util.*;

public class Athlete {
    String name;
    public int athlete_id;

    Dictionary<Integer, ArrayList<Integer>> symptomStorage = new Hashtable<>();

    Scanner scan = new Scanner(System.in);

    public Athlete(String name) {
        this.name = name;
        athlete_id = (int) (Math.random() * 9999) + (int) (Math.random() * 9999);

    }

    public void evaluate(int week_num) {
        ArrayList<Integer> response = new ArrayList<Integer>();
        String[] symptoms = {
                "Headache", "Pressure in head", "Neck Pain", "Nausea or Vomiting",
                "Dizziness", "Blurred vision", "Balance Problems", "Sensitivity to light",
                "Sensitivity to noise", " Feeling Slowed down",
                "Feeling like in a fog", "Don't feel right", "Difficulty concentrating",
                "Difficulty remembering", "Fatigue or low energy", "Confusion", "Drowsiness",
                "Trouble falling asleep", "More emotional", "Irritability", "Sadness",
                "Nervous or anxious"
        };


        for (var symptom : symptoms) {
            System.out.printf("please enter you %s score 0 if none, " +
                    "1-2 if mild, 3-4 if moderate, 5-6 if severe:", symptom);
            int choice = scan.nextInt();
            if (choice>6) choice=6;
            response.add(choice);

        }
        System.out.printf("Finished the Evaluation for %s week number %d %n", this.name, week_num );

        symptomStorage.put(week_num,response);

    }




}
