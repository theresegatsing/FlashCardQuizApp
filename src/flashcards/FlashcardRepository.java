package flashcards;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


/**
 * Handles loading and saving flashcards from/to a text file.
 * Each line is stored as: question|answer
 * 
 * @author Therese Elvira Mombou Gatsing
 */

public class FlashcardRepository {


    private final Path filePath;

    public FlashcardRepository(String fileName) {
        this.filePath = Path.of(fileName);
    }
    
    /**
     * Loads all flashcards from the file.
     * If the file does not exist, returns an empty list.
     */
    public List<Flashcard> load() {
        List<Flashcard> cards = new ArrayList<>();

        if (!Files.exists(filePath)) {
            return cards;
        }

        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                // Format: question|answer
                String[] parts = line.split("\\|", 2);
                if (parts.length == 2) {
                    String question = parts[0];
                    String answer = parts[1];
                    cards.add(new Flashcard(question, answer));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading flashcards file: " + e.getMessage());
        }

        return cards;
    }
    
    /**
     * Saves all flashcards to the file, overwriting previous content.
     */
    public void save(List<Flashcard> cards) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (Flashcard card : cards) {
                writer.write(card.getQuestion() + "|" + card.getAnswer());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving flashcards file: " + e.getMessage());
        }
    }

}
