
package game;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        
        String inputName = JOptionPane.showInputDialog(null, 
                "Enter your name:", 
                "Welcome to the Cybersecurity Trivia Game!", 
                JOptionPane.QUESTION_MESSAGE);

        
        final String playerName = (inputName == null || inputName.trim().isEmpty()) ? "Player" : inputName;

       
        SwingUtilities.invokeLater(() -> {
            new GameUI(playerName);
        });
    }
}


