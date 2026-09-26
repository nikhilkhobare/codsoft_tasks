import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        int totalScore = 0; q
        int roundsWon = 0;
        String playAgain = "yes";
        
        System.out.println("===== NUMBER GUESSING GAME =====");
        System.out.println("Guess the number between 1 to 100");

        while (playAgain.equalsIgnoreCase("yes")) {
            int numberToGuess = rand.nextInt(100) + 1; // 1 to 100
            int attempts = 0;
            int maxAttempts = 7; // 5. Limit attempts
            boolean guessedCorrectly = false;

            System.out.println("\nNew Round Started! You have " + maxAttempts + " attempts.");

            // 4. Repeat until correct guess
            while (attempts < maxAttempts) {
                // 2. Prompt user
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                // 3. Compare
                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    int roundScore = (maxAttempts - attempts + 1) * 10;
                    totalScore += roundScore;
                    System.out.println("Score for this round: " + roundScore);
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again. Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Too high! Try again. Attempts left: " + (maxAttempts - attempts));
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You lost this round! The number was: " + numberToGuess);
            }

            // 6. Multiple rounds
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next();
        }

        // 7. Display score
        System.out.println("\n===== GAME OVER =====");
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Total Score: " + totalScore);
        
        sc.close();
    }
}