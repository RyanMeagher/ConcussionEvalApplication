import java.util.Dictionary;
import java.util.Hashtable;

public class App {

    Dictionary<String, Athlete> players = new Hashtable<>();
    Dictionary<String, Dictionary> playersWeeklySymptoms = new Hashtable<>();


    public void addAthlete(String name) {

        if (players.get(name) == null) {
            Athlete new_athlete = new Athlete(name);
            players.put(name, new_athlete);
            System.out.printf("player %s was added %n", name);
        } else {
            System.out.printf("player %s already exists %n", name);
        }

    }

    public void addEvaluation(String name, int week_num) {
        if (players.get(name) == null) {
            System.out.printf("player %s does not exist, need to add player %n", name);
        } else {
            players.get(name).evaluate(week_num);
            this.playersWeeklySymptoms.put(name, players.get(name).symptomStorage);
        }

    }

    public void givePlayerSummary(String name, int week_num) {
        if (players.get(name) == null) {
            System.out.printf("player %s does not exist, need to add player %n", name);
        } else {
            var player = players.get(name);
            int i;
            int len = 0;
            int sev = 0;

            if (week_num > 5) {
                i = week_num - 5;
            } else {
                i = 0;
            }

            for (; i < week_num; i++) {
                System.out.println(i);
                var symptomList = player.symptomStorage.get(i + 1);
                symptomList.removeIf(n -> n == 0);
                var size = symptomList.size();
                var severity = symptomList.stream().reduce((a, b) -> a + b).get();
                System.out.printf("Number of Symptoms for week number %d is %d %n", i + 1, size);
                System.out.printf("The severity Score for week number %d is %d %n", i + 1, severity);
                var sizeDif = Math.abs(len - size);
                var severityDiff = Math.abs(sev - severity);

                if (sizeDif >= 3 || severityDiff >= 15) {
                    System.out.println("Overall Very different in severity rating between last 2 games");
                } else if (sizeDif < 3 && severityDiff < 10) {
                    System.out.println("Overall No difference in severity rating between last 2 games");

                } else {
                    System.out.println("Overall unsure in severity rating between last 2 games");
                }

                len = size;
                sev = severity;

            }
        }

    }


}
