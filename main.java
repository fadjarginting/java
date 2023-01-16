import java.util.Arrays;
import java.util.Scanner;

// Archer class
class Archer {
    // Archer properties
    private String name;
    private int number;
    private int[] scores;

    // Constructor
    public Archer(String name, int number) {
        this.name = name;
        this.number = number;
        this.scores = new int[3];
    }

    // Setter and getter methods
    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }

    public int[] getScores() {
        return this.scores;
    }

    public void setScore(int round, int score) {
        this.scores[round - 1] = score;
    }

    // Method to calculate the average score of an Archer
    public double getAverageScore() {
        return Arrays.stream(this.scores).average().orElse(0);
    }
}

// Main class
public class ArcheryCompetition {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the number of Archers
        System.out.print("Enter the number of Archers: ");
        int numArchers = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        // Create an array of Archers to store the participants
        Archer[] archers = new Archer[numArchers];

        // Loop through each Archer
        for (int i = 0; i < archers.length; i++) {
            // Prompt the user for the Archer's name and number
            System.out.print("Enter the name of Archer " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter the number of Archer " + (i + 1) + ": ");
            int number = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            // Create a new Archer object and add it to the array
            archers[i] = new Archer(name, number);

            // Loop through each round of the competition
            for (int j = 0; j < 3; j++) {
                // Prompt the user for the Archer's score
                System.out.print("Enter the score of Archer " + (i + 1) + " in round " + (j + 1) + ": ");
                int score = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                // Set the Archer's score for the current round
                archers[i].setScore(j + 1, score);
            }
        }

        // Sort the Archers array in descending order by average score
        Arrays.sort(archers, (a1, a2) -> (int) (a2.getAverageScore() - a1.getAverageScore()));

        // Print the results of the competition
        System.out.println("Results of the Archery Competition:");
        for (int i = 0; i < archers.length; i++) {
            Archer a = archers[i];
            System.out.println(
                (i + 1) + ". Archer " + a.getNumber() + " (" + a.getName() + ") - Average score: " + a.getAverageScore()
            );
        }
    }
}
