package game;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private TriviaGame game;           
    private JLabel questionLabel;       
    private JButton[] optionButtons;    
    private JLabel feedbackLabel;       
    private JLabel scoreLabel;          
    private JPanel mainPanel;

    public GameUI(String playerName) {
        game = new TriviaGame(playerName);

        setTitle("Cybersecurity Trivia Game");
        setSize(800, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); 

       
        questionLabel = new JLabel("Question will appear here", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 24));
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setOpaque(true);
        questionLabel.setBackground(new Color(40, 40, 40)); 
        questionLabel.setBorder(new LineBorder(Color.BLUE, 3));
        mainPanel.add(questionLabel, BorderLayout.NORTH);

        
        JPanel optionsPanel = new JPanel(new GridLayout(2, 2, 20, 20)); 
        optionsPanel.setBackground(Color.BLACK);
        optionsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        
        
        optionButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new RoundedButton(createHtmlLabel("Option " + (i + 1)));
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 12)); 
            optionButtons[i].setForeground(Color.BLACK);
            optionButtons[i].setContentAreaFilled(false); 
            optionButtons[i].setOpaque(true); 
            optionButtons[i].setBackground(new Color(220, 220, 220));
            
   
            Border emptyBorder = BorderFactory.createEmptyBorder();
            optionButtons[i].setBorder(emptyBorder);
            
            optionButtons[i].addActionListener(new OptionButtonListener(i));
            optionsPanel.add(optionButtons[i]);
        }


        mainPanel.add(optionsPanel, BorderLayout.CENTER);

        
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        feedbackLabel = new JLabel("", SwingConstants.CENTER);
        feedbackLabel.setFont(new Font("Arial", Font.BOLD, 18));
        feedbackLabel.setForeground(Color.WHITE);
        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        scoreLabel.setForeground(Color.WHITE);

        bottomPanel.add(feedbackLabel);
        bottomPanel.add(scoreLabel);
        bottomPanel.setBackground(Color.BLACK);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        loadNextQuestion();

        setVisible(true);
    }

    private String createHtmlLabel(String string) {
		
		return null;
	}

	
    private void loadNextQuestion() {
        Question question = game.getNextQuestion();
        if (question != null) {
            questionLabel.setText(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                optionButtons[i].setText(options[i]);
                optionButtons[i].setEnabled(true);
            }
            feedbackLabel.setText("");
        } else {
            
            questionLabel.setText("Game Over! " + game.getPlayerName() + "'s final score: " + game.getScore());
            for (JButton button : optionButtons) {
                button.setEnabled(false);
            }
            feedbackLabel.setText("Thank you for playing!");
        }
    }

    
    private class OptionButtonListener implements ActionListener {
        private int buttonIndex;

        public OptionButtonListener(int buttonIndex) {
            this.buttonIndex = buttonIndex;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (game.checkAnswer(buttonIndex)) {
                feedbackLabel.setText("Correct!");
                feedbackLabel.setForeground(Color.GREEN);
            } else {
                feedbackLabel.setText("Wrong answer.");
                feedbackLabel.setForeground(Color.RED);
            }
            updateScore();
            for (JButton button : optionButtons) {
                button.setEnabled(false);
            }
           
            Timer timer = new Timer(1000, evt -> loadNextQuestion());
            timer.setRepeats(false);
            timer.start();
        }
    }

    
    private void updateScore() {
        scoreLabel.setText("Score: " + game.getScore());
    }

  
    private static class RoundedButton extends JButton {
        private static final long serialVersionUID = 1L;

        public RoundedButton(String text) {
            super(text);
            setFocusPainted(false);
            setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25); 
            g2.setColor(getForeground());
            g2.setFont(getFont());
            FontMetrics fm = g2.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(getText())) / 2;
            int y = (getHeight() + fm.getAscent()) / 2 - fm.getDescent();
            g2.drawString(getText(), x, y);
            g2.dispose();
            super.paintComponent(g);
        }
    }
}

