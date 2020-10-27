import java.util.Scanner;

public class AppUI {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        App concussionApp = new App();
        boolean runApp = true;

        do {
            displayMenu();
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of Athlete to Add to App");
                    String name = scan.nextLine();
                    concussionApp.addAthlete(name);

                    break;
                case 2:
                    System.out.println("Add Medical Personnel functionality added Later");
                    break;

                case 3:
                    System.out.println("Enter the name of Athlete to Evaluate");
                    name = scan.nextLine();
                    System.out.println("Enter the week number of Evaluation");
                    int weekNum = scan.nextInt();
                    concussionApp.addEvaluation(name, weekNum);

                    break;

                case 4:
                    System.out.println("Enter the name of Athlete to get Summary");
                    name = scan.nextLine();
                    System.out.println("Enter the week number of Evaluation");
                    weekNum = scan.nextInt();

                    concussionApp.givePlayerSummary(name, weekNum);


                    break;
                case 5:
                    System.out.println("Exiting the application");
                    runApp = false;
                    break;

                default:
                    System.out.println("Invalid Input ");

            }

        }
        while (runApp);


    }

    static void displayMenu() {
        System.out.println("Welcome to The Sports Concussion Evaluation");
        System.out.println("==================================");
        System.out.println("Please select one of the following options");
        System.out.println("\t\t  1. Add Athlete");
        System.out.println("\t\t  2. Add Medical Personnel");
        System.out.println("\t\t  3. Evaluate Athlete");
        System.out.println("\t\t  4. Get Player Summary");
        System.out.println("\t\t  5. Exit");

    }
}
