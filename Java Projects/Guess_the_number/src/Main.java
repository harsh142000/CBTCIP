import java.util.Random;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int maxAttempts = 10;
        int rangeStart = 1;
        int rangeEnd = 100;
        int score = 0;

        // Show a welcome message using a dialogue box
        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number game!");

        do {
            // Generate a random number within the specified range
            int targetNumber = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;

            // Ask the user to guess the number using a dialogue box
            String input = JOptionPane.showInputDialog("Guess a number between " + rangeStart + " and " + rangeEnd + ".");
            int attempts = 0;

            if (input == null) {
                break; // User clicked the cancel button, exit the game loop
            }

            int guess = Integer.parseInt(input);

            while (attempts < maxAttempts) {
                attempts++;

                if (guess == targetNumber) {
                    // Show a success message if the guessed number is correct
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number!");

                    // Calculate points earned and update the total score
                    int points = maxAttempts - attempts + 1;
                    score=points;

                    // Show points earned in the current round using a dialogue box
                    JOptionPane.showMessageDialog(null, "Points earned: " + points);
                    break;
                } else if (guess < targetNumber) {
                    // Ask the user for a higher number since their guess was too low
                    input = JOptionPane.showInputDialog("Your guess is too low. Enter a higher number:");
                } else {
                    // Ask the user for a lower number since their guess was too high
                    input = JOptionPane.showInputDialog("Your guess is too high. Enter a lower number:");
                }

                if (input == null) {
                    break; // User clicked the cancel button, exit the game loop
                }

                guess = Integer.parseInt(input);
            }

            if (attempts == maxAttempts) {
                // Show a message when the user runs out of attempts
                JOptionPane.showMessageDialog(null, "Sorry, you have used all your attempts. The correct number was: " + targetNumber);
                score=0;
            }

            // Ask the user if they want to play another round
            int continueOption = JOptionPane.showConfirmDialog(null, "Do you want to play another round?", "Continue?", JOptionPane.YES_NO_OPTION);

            if (continueOption == JOptionPane.NO_OPTION) {
                // Show a message when the user decides to exit the game
                JOptionPane.showMessageDialog(null, "Game Over");
                break; // Exit the game loop
            }

        } while (true);

        // Show the final score using a dialogue box when the user exits the game
        JOptionPane.showMessageDialog(null, "Your final score is: " + score);
    }
}
