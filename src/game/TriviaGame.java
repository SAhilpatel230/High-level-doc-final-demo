package game;

import java.util.ArrayList;
import java.util.List;

public class TriviaGame {
    private List<Question> questions; // List to hold questions
    private Player player; // Player object to store player info and score
    private int currentQuestionIndex;

    // Constructor to initialize the game with player's name
    public TriviaGame(String playerName) {
        questions = new ArrayList<>();
        player = new Player(playerName); // Initialize player with their name
        currentQuestionIndex = 0;
        loadQuestions(); // Load the questions
    }

    // Load questions into the game
    private void loadQuestions() {
        questions.add(new Question(
            "Which type of malware disguises itself as legitimate software?",
            new String[]{"Virus", "Worm", "Trojan", "Ransomware"},
            2  // Correct answer is "Trojan"
        ));

        questions.add(new Question(
            "What does 'phishing' involve?",
            new String[]{"Infecting a network", "Social engineering", "Encrypting files", "Crashing a system"},
            1  // Correct answer is "Social engineering"
        ));

        questions.add(new Question(
            "What is the strongest encryption type listed?",
            new String[]{"MD5", "AES-256", "SHA-1", "Blowfish"},
            1  // Correct answer is "AES-256"
        ));

        questions.add(new Question(
            "Which protocol is commonly used to secure communications on the web?",
            new String[]{"HTTP", "FTP", "SSL/TLS", "POP3"},
            2  // Correct answer is "SSL/TLS"
        ));

        questions.add(new Question(
            "What is a common sign of a phishing email?",
            new String[]{"Correct grammar", "Professional email domain", "Asking for sensitive information", "Friendly tone"},
            2  // Correct answer is "Asking for sensitive information"
        ));

        questions.add(new Question(
            "Which type of attack involves overwhelming a server with traffic?",
            new String[]{"SQL Injection", "Brute Force Attack", "DDoS", "Cross-Site Scripting"},
            2  // Correct answer is "DDoS"
        ));

        questions.add(new Question(
            "What does the 'S' in HTTPS stand for?",
            new String[]{"Secure", "Simple", "Server", "System"},
            0  // Correct answer is "Secure"
        ));

        questions.add(new Question(
            "Which of these is a type of cryptographic hash function?",
            new String[]{"AES", "RSA", "SHA-256", "SSL"},
            2  // Correct answer is "SHA-256"
        ));

        questions.add(new Question(
            "Which tool is commonly used for network security monitoring?",
            new String[]{"Nmap", "Wireshark", "Photoshop", "Microsoft Word"},
            1  // Correct answer is "Wireshark"
        ));

        questions.add(new Question(
            "What is the main purpose of a firewall?",
            new String[]{"Monitor network traffic", "Encrypt data", "Perform backups", "Improve internet speed"},
            0  // Correct answer is "Monitor network traffic"
        ));
    }

    // Get the next question
    public Question getNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex++);
        }
        return null; // No more questions
    }

    // Check if the answer is correct and update score through Player
    public boolean checkAnswer(int answerIndex) {
        Question currentQuestion = questions.get(currentQuestionIndex - 1);
        if (currentQuestion.isCorrectAnswer(answerIndex)) {
            player.increaseScore(); // Increment score using the Player object
            return true;
        }
        return false;
    }

    // Get the player's score from the Player class
    public int getScore() {
        return player.getScore();
    }

    // Get the player's name from the Player class
    public String getPlayerName() {
        return player.getName();
    }
}