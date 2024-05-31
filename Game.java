import java.util.ArrayList;
import java.util.Random;

// Abstract class for a Game
public abstract class Game {
    protected int maxAttempts; // Maximum number of attempts allowed
    protected int numberToGuess; // The number that needs to be guessed
    protected ArrayList<Integer> attempts; // List to store all the attempts

    // Constructor to initialize the game with maximum attempts
    public Game(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.attempts = new ArrayList<>();
    }

    // Abstract method to start the game - must be implemented by subclasses
    public abstract void start();

    // Method to check if the game is over
    public boolean isGameOver() {
        // Game is over if max attempts reached or number is guessed
        return attempts.size() >= maxAttempts || attempts.contains(numberToGuess);
    }

    // Method to get the number of attempts left
    public int attemptsLeft() {
        return maxAttempts - attempts.size();
    }

    // Method to generate a random number within a given range
    protected int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    // Method to add an attempt to the list of attempts
    public void addAttempt(int attempt) {
        attempts.add(attempt);
    }

    // Method to get the last attempt made
    public int getLastAttempt() {
        return attempts.get(attempts.size() - 1);
    }
}
