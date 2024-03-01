package Guess;
import javax.swing.*;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();

        int totalRounds = 3;
        int winCount = 0;
        int lossCount = 0;

        for (int round = 1; round <= totalRounds; round++) {
            int computerNumber = random.nextInt(50) + 1;
            int maxAttempts = 7;
            int count = 1;

            // Display input dialog using Swing
            JOptionPane.showMessageDialog(null, "Let's start Round " + round + " of the guessing game!\n" +
                    "Guess a number between 1 and 50");

            while (count <= maxAttempts) {
                // Display input dialog using Swing
                String response = JOptionPane.showInputDialog(null, "Enter a guess between 1 and 50");
                int userAnswer = Integer.parseInt(response);

                JOptionPane.showMessageDialog(null, determineGuess(userAnswer, computerNumber, count, maxAttempts));

                if (userAnswer == computerNumber) {
                    winCount++;
                    break; // Exit the loop if the guess is correct
                }

                count++;
            }

            // Display the correct guess at the end of the round
            JOptionPane.showMessageDialog(null, "Round " + round + " Over. The correct guess was: " + computerNumber +
                    "\nAttempts: " + (count - 1));

            if (count > maxAttempts) {
                lossCount++;
            }
        }

        // Display overall score using Swing
        JOptionPane.showMessageDialog(null, "Game Over\nWins: " + winCount + "\nLosses: " + lossCount);
    }

    public static String determineGuess(int userAnswer, int computerNumber, int count, int maxAttempts) {
        int difference = Math.abs(userAnswer - computerNumber);

        if (userAnswer <= 0 || userAnswer > 50) {
            return "Your guess is invalid";
        } else if (userAnswer == computerNumber) {
            return "Correct!\nTotal Attempts: " + count;
        } else if (difference <= 5) {
            if (userAnswer < computerNumber) {
                return "You're getting warmer! Go forward.\nAttempts left: " + (maxAttempts - count);
            } else {
                return "You're getting warmer! Go backward.\nAttempts left: " + (maxAttempts - count);
            }
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nAttempts left: " + (maxAttempts - count);
        } else {
            return "Your guess is too low, try again.\nAttempts left: " + (maxAttempts - count);
        }
    }
}
