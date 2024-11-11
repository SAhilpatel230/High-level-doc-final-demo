package game;

public class Question {
	    private String questionText;
	    private String[] options; // Array to hold multiple-choice options
	    private int correctAnswerIndex;

	    // Constructor
	    public Question(String questionText, String[] options, int correctAnswerIndex) {
	        this.questionText = questionText;
	        this.options = options;
	        this.correctAnswerIndex = correctAnswerIndex;
	    }

	    // Getter methods
	    public String getQuestionText() {
	        return questionText;
	    }

	    public String[] getOptions() {
	        return options;
	    }

	    public int getCorrectAnswerIndex() {
	        return correctAnswerIndex;
	    }
	    
	    public boolean isCorrectAnswer(int index) {
	        return index == correctAnswerIndex;
	    }
	}


