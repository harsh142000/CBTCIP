import java.util.Random;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Welcome message
        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number Game!");

        // Variables
        int rangeMin = 1;
        int rangeMax = 100;
        int maxAttempts = 10;
        int currentScore = 0;
        int rounds = 1;

        while (true) {
            // Generate a random number
            int randomNumber = generateRandomNumber(rangeMin, rangeMax);

            // Initialize variables for the current round
            int attempts = 0;
            boolean guessed = false;

            // Play the current round
            while (attempts < maxAttempts && !guessed) {
                // Prompt user to guess the number
                String input = JOptionPane.showInputDialog("Round " + rounds + ": Guess the number between " + rangeMin + " and " + rangeMax);

                // Check if the input is a valid integer
                int guess;
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                    continue;
                }

                // Compare the user's guess with the random number
                if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Higher! Try again.");
                } else if (guess > randomNumber) {
                    JOptionPane.showMessageDialog(null, "Lower! Try again.");
                } else {
                    // Guessed correctly
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + (attempts + 1) + " attempts.");
                    guessed = true;
                    currentScore += maxAttempts - attempts;
                }

                attempts++;
            }

            // Check if the user has reached the maximum number of attempts
            if (!guessed) {
                JOptionPane.showMessageDialog(null, "Out of attempts! The number was: " + randomNumber);
            }

            // Ask if the user wants to play another round
            int option = JOptionPane.showConfirmDialog(null, "Your current score: " + currentScore + "\nDo you want to play another round?", "Play Again?", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION) {
                break;
            }

            rounds++;
        }

        // Game Over
        JOptionPane.showMessageDialog(null, "Game Over! Your final score: " + currentScore);
    }

    // Helper method to generate a random number within the specified range
    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
