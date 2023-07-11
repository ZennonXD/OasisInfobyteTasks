import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        for (int level = 1; level <= 3; level++) {
            System.out.println("\nLevel " + level + " - " + getLevelDifficulty(level));

            int score = playGame(scanner, level);
            totalScore += score;

            System.out.println("Your score for level " + level + ": " + score);
        }

        System.out.println("\nYour total score: " + totalScore);
        scanner.close();
    }

    public static String getLevelDifficulty(int level) {
        switch (level) {
            case 1:
                return "Easy";
            case 2:
                return "Medium";
            case 3:
                return "Hard";
            default:
                return "";
        }
    }

    public static int playGame(Scanner scanner, int level) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        boolean hasWon = false;
        int attempts = 0;

        System.out.println("Guess a number between 1 and 100:");

        while (!hasWon && attempts < 10) {
            int guess = scanner.nextInt();

            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                hasWon = true;
            }

            int difference = Math.abs(guess - numberToGuess);
            String proximity;

            if (difference <= 5) {
                proximity = "Very close!";
            } else if (difference <= 10) {
                proximity = "Close!";
            } else if (difference <= 20) {
                proximity = "Somewhat close.";
            } else {
                proximity = "Not close.";
            }

            System.out.println("Proximity: " + proximity);
        }

        if (hasWon) {
            System.out.println("Congratulations! You guessed the number.");
        } else {
            System.out.println("Game over! The number was " + numberToGuess);
        }

        int score = 10 - attempts;
        return Math.max(score, 0);
    }
}
