# 📘 Flashcard Quiz App — Java Console Project

A simple and interactive **command-line flashcard application** written in Java.  
Users can create custom flashcards, review them, and take quizzes — all through a clean console interface.

This project demonstrates:
- Object-Oriented Design  
- Java Collections (`List`, `ArrayList`)  
- File I/O using `java.nio.file`  
- Separation of concerns (Model → Repository → Engine → UI)  
- Basic console UI design  

---

## ⭐ Features

- ✏️ Add custom flashcards  
- 📄 List all flashcards  
- 🧠 Quiz mode with score tracking  
- 💾 Automatic persistence to `flashcards.txt`  
- 🎲 Randomized question order  
- 💻 Lightweight and runs entirely in terminal  

---

## 📁 Project Structure


```text
flashcards/
│
├── Flashcard.java             # Model class for a single flashcard
├── FlashcardRepository.java   # Handles file saving/loading
├── QuizEngine.java            # Quiz logic and scoring
└── FlashcardApp.java          # Console UI (main program)

flashcards.txt                 # Auto-created data file
