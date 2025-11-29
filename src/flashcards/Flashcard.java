package flashcards;

/**
 * Represents a single flashcard with a question and an answer.
 * 
 * @author Therese Elvira Mombou Gatsing
 */
public class Flashcard {
	
	private final String question;
    private final String answer;

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
    
    @Override
    public String toString() {
        return "Q: " + question + " | A: " + answer;
    }
}
