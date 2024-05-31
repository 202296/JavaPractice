import java.util.Scanner;

// GuessTheNumber class that extends Game
public class GuessTheNumber extends Game {
    private Scanner scanner; // Scanner to read user input

    // Constructor to initialize the game with maximum attempts
    public GuessTheNumber(int maxAttempts) {
        super(maxAttempts);
        this.scanner = new Scanner(System.in);
        this.numberToGuess = generateRandomNumber(1, 100); // Generate a random number between 1 and 100
    }

    // Method to start the game
    @Override
    public void start() {
        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I have randomly selected a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        // Loop until the game is over
        while (!isGameOver()) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt(); // Read user input
            addAttempt(guess); // Add the attempt to the list
            giveFeedback(guess); // Provide feedback on the guess

            // Check if the guess is correct
            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number correctly.");
                break;
            } else if (isGameOver()) {
                System.out.println("Game Over! You've used all your attempts.");
                System.out.println("The number was: " + numberToGuess);
            } else {
                System.out.println("Attempts left: " + attemptsLeft());
            }
        }
    }

    // Method to provide feedback to the player on their guess
    private void giveFeedback(int guess) {
        if (guess > numberToGuess) {
            System.out.println("Your guess is too high.");
        } else if (guess < numberToGuess) {
            System.out.println("Your guess is too low.");
        }
    }
}
