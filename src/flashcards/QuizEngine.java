package flashcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Runs a quiz session on a list of flashcards.
 * 
 * @author Therese Elvira Mombou Gatsing
 */
public class QuizEngine {
	
	private final List<Flashcard> deck;

    public QuizEngine(List<Flashcard> deck) {
        this.deck = deck;
    }

    
    /**
     * Runs a quiz round over all flashcards in random order.
     */
    
    public void runQuiz(Scanner scanner) {
        if (deck.isEmpty()) {
            System.out.println("No flashcards available. Add some first!");
            return;
        }

        List<Flashcard> shuffled = new ArrayList<>(deck);
        Collections.shuffle(shuffled);

        int correct = 0;

        System.out.println("\n=== Quiz started! ===");
        for (Flashcard card : shuffled) {
            System.out.println("\nQuestion: " + card.getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim();

            if (userAnswer.equalsIgnoreCase(card.getAnswer().trim())) {
                System.out.println("✅ Correct!");
                correct++;
            } else {
                System.out.println("❌ Incorrect. Correct answer: " + card.getAnswer());
            }
        }

        System.out.println("\n=== Quiz finished! ===");
        System.out.println("Score: " + correct + " / " + shuffled.size());
    }
}
