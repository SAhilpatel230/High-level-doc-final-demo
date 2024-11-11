package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask for player's name
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        // Initialise the game with the player's name
        TriviaGame game = new TriviaGame(playerName);

        System.out.println("Welcome to the Cybersecurity Trivia Game, " + playerName + "!");

        Question question;
        while ((question = game.getNextQuestion()) != null) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ": " + options[i]);
            }

            int answer = -1;
            boolean validInput = false;

            // Prompt for input and handle errors
            while (!validInput) {
                System.out.print("Your answer (1-4): ");
                try {
                    answer = scanner.nextInt() - 1; // Adjust for 0-based index
                    if (answer >= 0 && answer < options.length) {
                        validInput = true; // Exit loop if input is valid
                    } else {
                        System.out.println("Please enter a number between 1 and 4.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                    scanner.next(); // Clear the invalid input
                }
            }

            if (game.checkAnswer(answer)) {
                System.out.println("Correct!\n");
            } else {
                System.out.println("Wrong answer.\n");
            }
        }

        // Display the player's final score with their name
        System.out.println("Game Over! " + playerName + "'s final score: " + game.getScore() + " out of 10");
        System.out.println("Thank you for playing the Cybersecurity Trivia Game, " + playerName + "!");
        scanner.close();
    }
}
