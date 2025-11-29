package flashcards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Command-line Flashcard Quiz App.
 *
 * Features:
 * - Add flashcards
 * - List all flashcards
 * - Quiz mode
 * - Save & exit
 * 
 * @author Therese Elvira Mombou Gatsing
 */
public class FlashcardApp {
	
	private static final String DATA_FILE = "flashcards.txt";

    public static void main(String[] args) {
        FlashcardRepository repository = new FlashcardRepository(DATA_FILE);
        List<Flashcard> deck = new ArrayList<>(repository.load());

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                printMenu(deck.size());
                System.out.print("Choose an option: ");
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        addFlashcard(scanner, deck);
                        break;
                    case "2":
                        listFlashcards(deck);
                        break;
                    case "3":
                        QuizEngine quiz = new QuizEngine(deck);
                        quiz.runQuiz(scanner);
                        break;
                    case "4":
                        repository.save(deck);
                        System.out.println("Flashcards saved. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }
    }

    
    private static void printMenu(int count) {
        System.out.println("\n=== Flashcard Quiz App ===");
        System.out.println("You currently have " + count + " flashcards.");
        System.out.println("1. Add flashcard");
        System.out.println("2. List flashcards");
        System.out.println("3. Start quiz");
        System.out.println("4. Save & exit");
    }

    
    private static void addFlashcard(Scanner scanner, List<Flashcard> deck) {
        System.out.println("\n--- Add Flashcard ---");
        System.out.print("Enter question: ");
        String question = scanner.nextLine().trim();

        System.out.print("Enter answer: ");
        String answer = scanner.nextLine().trim();

        if (question.isEmpty() || answer.isEmpty()) {
            System.out.println("Question and answer cannot be empty.");
            return;
        }

        Flashcard card = new Flashcard(question, answer);
        deck.add(card);
        System.out.println("Flashcard added!");
    }
    

}
