import java.util.Random;
import java.util.Scanner;

public class SmartGuessGame {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Random random = new Random();
            
            System.out.println("===== SMART GUESSING GAME =====");
            System.out.println("Choose Difficulty Level:");
            System.out.println("1. Easy (1-50)");
            System.out.println("2. Medium (1-100)");
            System.out.println("3. Hard (1-200)");
            
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            
            int maxRange;
            
            switch(choice) {
                case 1 -> maxRange = 50;
                case 2 -> maxRange = 100;
                case 3 -> maxRange = 200;
                default -> {
                    maxRange = 100;
                    System.out.println("Invalid choice! Medium level selected.");
                }
            }
            
            int secretNumber = random.nextInt(maxRange) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessed = false;
            
            System.out.println("\nGuess the number between 1 and " + maxRange);
            System.out.println("You have " + maxAttempts + " attempts.\n");
            
            while(attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;
                
                if(guess == secretNumber) {
                    guessed = true;
                    int score = (maxAttempts - attempts + 1) * 10;
                    System.out.println("\nCongratulations!");
                    System.out.println("You guessed the number in " + attempts + " attempts.");
                    System.out.println("Your Score: " + score);
                    break;
                }
                else if(guess < secretNumber) {
                    System.out.println("Too Low!");
                }
                else {
                    System.out.println("Too High!");
                }
                
                System.out.println("Attempts Left: " + (maxAttempts - attempts));
            }
            
            if(!guessed) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + secretNumber);
            }
        }
    }
}