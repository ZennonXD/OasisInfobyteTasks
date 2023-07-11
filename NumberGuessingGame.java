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
                return "Intermediate";
            case 3:
                return "Pro";
            default:
                return "";
        }
    }

    public static int playGame(Scanner scanner, int level) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        boolean CorrectGuess = false;
        int trys = 0;

        System.out.println("Guess a number between 1 and 100:");

        while (!CorrectGuess && trys < 10) {
            int guess = scanner.nextInt();

            trys++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                CorrectGuess = true;
            }

            int difference = Math.abs(guess - numberToGuess);
            String proximity;

            if (difference == 0) {
                proximity = "You Guessed it right";
            }
            else if (difference >= 1 && difference <= 5) {
                proximity = "You are very Close to the Number";
            }  
            else if (difference <= 10) {
                proximity = "You are close to the number!";
            } else if (difference <= 20) {
                proximity = "You are somewhat close to the number.";
            } else {
                proximity = "You are not close! Guess carefully";
            }

            System.out.println("Nice Try :) : " + proximity);
        }

        if (CorrectGuess) {
            System.out.println("Congratulations! You guessed the number.");
        } else {
            System.out.println("Game over! The number was " + numberToGuess);
        }

        int score = 10 - trys;
        return Math.max(score, 0);
    }
}
