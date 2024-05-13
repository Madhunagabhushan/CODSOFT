import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 50;
        int maxAttempt = 10;
        int score = 0;
        int totalRounds = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            totalRounds++;
            int randomNumber = random.nextInt(max - min + 1) + min;
            System.out.println("\nI have selected a number between " + min + " and " + max + ". You have to guess what it is!");

            int attempt = 0;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly && attempt < maxAttempt) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempt++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the number correctly in " + attempt + " attempts!");
                    score++;
                    roundsWon++;
                    guessedCorrectly = true;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nSorry, you've run out of attempts. The correct number was: " + randomNumber);
            }

            System.out.println("\nYour current score: " + score);
            System.out.println("Rounds won: " + roundsWon + " out of " + totalRounds);
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing! Your final score is: " + score);
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Rounds won: " + roundsWon + " out of " + totalRounds);
        scanner.close();
    }
}
