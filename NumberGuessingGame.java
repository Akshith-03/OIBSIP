import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int totalRounds = 3;
        int totalScore = 0;

        System.out.println(" Guess the Number game!");
        System.out.println("The Min and Max Range of the number: 1,100");
        System.out.println("You have " + totalRounds + " rounds to play.");

        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("\nRound " + round);
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int score = playGame(randomNumber, maxAttempts, scanner);
            totalScore += score;
            System.out.println("Round " + round + " score: " + score);
        }

        System.out.println("\nTotal score: " + totalScore);
        scanner.close();
    }

    public static int playGame(int randomNumber, int maxAttempts, Scanner scanner) {
        int attempt = 0;
        int userGuess;
        while (attempt < maxAttempts) {
            attempt++;
            System.out.print("Attempt " + attempt + "/" + maxAttempts + ": Enter your guess: ");
            userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number.");
                return calculateScore(maxAttempts, attempt);
            } else if (userGuess < randomNumber) {
                System.out.println("The number is higher.");
            } else {
                System.out.println("The number is lower.");
            }
        }
        System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
    
        return 0; 
       
    }

    public static int calculateScore(int maxAttempts, int attempt) {
        int maxScore = 100; 
        int score = maxScore - ((attempt - 1) * (maxScore / maxAttempts));
        return Math.max(score, 0); 
    }
}
