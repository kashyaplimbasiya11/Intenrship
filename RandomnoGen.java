import java.util.Scanner;
import java.util.Random;

public class RandomnoGen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 3;
        int roundsPlayed = 0;
        int userScore = 0;

        while (true) {
            System.out.println("\nRound " + (roundsPlayed + 1));

            // Step 1: Generate a random number within the specified range
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

            while (maxAttempts > 0) {
                // Step 2: Prompt the user to enter their guess
                System.out.print("Guess the number between " + lowerBound + " and " + upperBound + ": ");
                int userGuess = scanner.nextInt();

                // Step 3: Compare the user's guess and provide feedback
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + targetNumber + "!");
                    userScore += maxAttempts;
                    roundsPlayed++;
                    System.out.println("Rounds played: " + roundsPlayed + ", Your score: " + userScore);

                    System.out.print("Do you want to play again? (yes/no): ");
                    String playAgain = scanner.next();
                    if (!playAgain.equalsIgnoreCase("yes")) {
                        scanner.close();
                        return;
                    } else {
                        maxAttempts = 10;
                        break;
                    }
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                // Step 5: Limit the number of attempts
                maxAttempts--;
            }

            if (maxAttempts == 0) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");

                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next();
                if (!playAgain.equalsIgnoreCase("yes")) {
                    scanner.close();
                    return;
                } else {
                    maxAttempts = 10;
                    roundsPlayed++;
                }
            }
        }
    }
}
