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


}
