# LexiScan

LexiScan is a JavaFX-based text analyzer that counts, identifies, and visually highlights different elements within a text.

The application allows users to analyze words, vowels, consonants, and special characters through an interactive graphical interface.

## Features

* Count the number of words in a text.
* Count vowels.
* Count consonants.
* Count special characters.
* Visually highlight the selected element in the analyzed text.
* Display the corresponding count dynamically.
* Support text containing spaces, punctuation, and accented characters.

---

## Functional Requirements

### FR-01 — Text Input

The system shall allow the user to enter a text string to be analyzed.

### FR-02 — Word Counting

The system shall identify and count the words contained in the input text.

### FR-03 — Vowel Counting

The system shall identify and count vowels contained in the input text.

### FR-04 — Consonant Counting

The system shall identify and count consonants contained in the input text.

### FR-05 — Special Character Counting

The system shall identify and count special characters contained in the input text.

### FR-06 — Element Selection

The system shall allow the user to select which type of element they want to identify using radio buttons.

### FR-07 — Visual Highlighting

The system shall visually highlight the elements corresponding to the selected category within the analyzed text.

### FR-08 — Result Display

The system shall display the total number of identified elements below the analyzed text.

---

## Non-Functional Requirements

### NFR-01 — Usability

The interface shall be simple and intuitive, allowing the user to analyze text without requiring technical knowledge.

### NFR-02 — Responsiveness

The application shall update the analysis and visual highlighting without unnecessary delays.

### NFR-03 — Maintainability

The source code shall be organized using separate responsibilities for the model, view, and controller.

### NFR-04 — Compatibility

The application shall run on systems with a compatible Java Runtime Environment and JavaFX installation.

### NFR-05 — Readability

The source code shall follow consistent naming conventions and maintain a clear project structure.

---

## Project Structure

```text
LexiScan/
├── src/
│   └── main/
│       ├── java/
│       │   └── lexyscan/
│       │       ├── controller/
│       │       │   └── MainController.java
│       │       ├── model/
│       │       │   └── TextAnalyzer.java
│       │       └── Main.java
│       │
│       └── resources/
│           └── lexyscan/
│               └── main-view.fxml
│
├── .gitignore
├── README.md
└── pom.xml
```

### Architecture

LexiScan follows a simple **Model-View-Controller (MVC)** organization:

* **Model:** Contains the text analysis logic and calculations.
* **View:** Defines the graphical interface using JavaFX and FXML.
* **Controller:** Handles user interaction and connects the interface with the analysis logic.

---

## Technologies

* **Java**
* **JavaFX**
* **FXML**
* **CSS**
* **Maven**
* **Git / GitHub**

---

## Example

Given the following input:

```text
Anita lava la tina.
```

The application should be able to identify:

```text
Words: 4
Vowels: 8
Consonants: 9
Special characters: 1
```

When a category is selected, the corresponding elements should be visually highlighted in the text.

For example, when selecting **Vowels**, the vowels in the text will be highlighted while the rest of the text remains unchanged.

---

## Project Status

🚧 **In development**

The initial version focuses on the core text analysis functionality and interactive visual highlighting.
