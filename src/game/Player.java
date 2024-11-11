package game;

public class Player {
	    private String name;
	    private int score;

	    // Constructor to initialize player's name and set score to 0
	    public Player(String name) {
	        this.name = name;
	        this.score = 0;  // Initial score is 0
	    }

	    // Get the player's name
	    public String getName() {
	        return name;
	    }

	    // Get the player's score
	    public int getScore() {
	        return score;
	    }

	    // Increase the player's score by 1
	    public void increaseScore() {
	        score++;
	    }

	    // Reset the player's score (optional, useful if you want to allow restarting the game)
	    public void resetScore() {
	        score = 0;
	    }
	}


