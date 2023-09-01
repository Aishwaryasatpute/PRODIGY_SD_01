import java.util.Random;
import java.util.Scanner;

public class  guessgame{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int numberOfGuesses = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound);

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numberOfGuesses++;

            if (userGuess < randomNumber) {
                System.out.println("Try a higher number.");
            } else if (userGuess > randomNumber) {
                System.out.println("Try a lower number.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number in " + numberOfGuesses + " guesses.");
            }
        }

        scanner.close();
    }
}




