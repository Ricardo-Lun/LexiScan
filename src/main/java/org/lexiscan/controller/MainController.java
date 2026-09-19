package org.lexiscan.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.lexiscan.model.TextAnalyzer;

public class MainController {

    @FXML
    private TextArea textInput;

    @FXML
    private Label characterCountLabel;

    @FXML
    private Button clearButton;

    @FXML
    private Button analyzeButton;

    @FXML
    private Button exampleOneButton;

    @FXML
    private Button exampleTwoButton;

    @FXML
    private Button exampleThreeButton;

    @FXML
    private TextFlow highlightedText;

    // Resultados
    @FXML
    private Label wordCountLabel;

    @FXML
    private Label vowelCountLabel;

    @FXML
    private Label consonantCountLabel;

    @FXML
    private Label digitCountLabel;

    @FXML
    private Label specialCountLabel;

    // Radio buttons
    @FXML
    private RadioButton wordsRadio;

    @FXML
    private RadioButton vowelsRadio;

    @FXML
    private RadioButton consonantsRadio;

    @FXML
    private RadioButton digitsRadio;

    @FXML
    private RadioButton specialRadio;

    @FXML
    private ToggleGroup analysisGroup;

    // model

    private final TextAnalyzer textAnalyzer = new TextAnalyzer();

    // texto analizado

    private String analyzedText = "";

    @FXML
    public void initialize() {

        // Actualizar contador de caracteres mientras el usuario escribe.
        textInput.textProperty().addListener((observable, oldValue, newValue) -> {

            int characterCount = newValue.length();

            characterCountLabel.setText(
                    characterCount + (characterCount == 1
                            ? " carácter"
                            : " caracteres")
            );
        });


        // Botón analizar
        analyzeButton.setOnAction(event -> analyzeText());


        // Botón limpiar
        clearButton.setOnAction(event -> clearAnalysis());


        // Ejemplos
        exampleOneButton.setOnAction(event ->
                loadExample("¡Hola, mundo!")
        );

        exampleTwoButton.setOnAction(event ->
                loadExample("La vida es mejor con código.")
        );

        exampleThreeButton.setOnAction(event ->
                loadExample("123.45 @#%")
        );


        // Radio buttons
        wordsRadio.setOnAction(event ->
                highlightCategory("words")
        );

        vowelsRadio.setOnAction(event ->
                highlightCategory("vowels")
        );

        consonantsRadio.setOnAction(event ->
                highlightCategory("consonants")
        );

        digitsRadio.setOnAction(event ->
                highlightCategory("digits")
        );

        specialRadio.setOnAction(event ->
                highlightCategory("special")
        );


        // Estado inicial
        updateCharacterCount();
        resetResults();
    }


    // analizar texto

    private void analyzeText() {

        String text = textInput.getText();

        if (text == null) {
            text = "";
        }

        analyzedText = text;

        // Usamos el MODEL para obtener los resultados.
        int words = textAnalyzer.countWords(text);
        int vowels = textAnalyzer.countVowels(text);
        int consonants = textAnalyzer.countConsonants(text);
        int digits = textAnalyzer.countDigits(text);
        int special = textAnalyzer.countSpecialCharacters(text);

        // Enviamos los resultados a la VISTA.
        wordCountLabel.setText(String.valueOf(words));
        vowelCountLabel.setText(String.valueOf(vowels));
        consonantCountLabel.setText(String.valueOf(consonants));
        digitCountLabel.setText(String.valueOf(digits));
        specialCountLabel.setText(String.valueOf(special));

        // Mostrar el texto analizado sin ningún resaltado.
        showOriginalText();
    }


    // limpiar

    private void clearAnalysis() {

        textInput.clear();

        analyzedText = "";

        resetResults();

        highlightedText.getChildren().clear();

        analysisGroup.selectToggle(null);

        updateCharacterCount();
    }

    // resultados

    private void resetResults() {

        wordCountLabel.setText("0");
        vowelCountLabel.setText("0");
        consonantCountLabel.setText("0");
        digitCountLabel.setText("0");
        specialCountLabel.setText("0");
    }

    // controlador de caracteres

    private void updateCharacterCount() {

        String text = textInput.getText();

        if (text == null) {
            text = "";
        }

        int count = text.length();

        characterCountLabel.setText(
                count + (count == 1
                        ? " carácter"
                        : " caracteres")
        );
    }


    // muestra el ejemplo

    private void loadExample(String example) {

        textInput.setText(example);

        // Analizamos automáticamente el ejemplo.
        analyzeText();
    }


    // texto original

    private void showOriginalText() {

        highlightedText.getChildren().clear();

        for (char character : analyzedText.toCharArray()) {

            Text text = new Text(String.valueOf(character));

            text.getStyleClass().add("highlight-normal");

            highlightedText.getChildren().add(text);
        }
    }

    // resaltar categoria

    private void highlightCategory(String category) {

        if (analyzedText == null || analyzedText.isEmpty()) {
            return;
        }

        highlightedText.getChildren().clear();

        for (char character : analyzedText.toCharArray()) {

            Text text = new Text(String.valueOf(character));

            boolean highlight = false;

            switch (category) {

                case "words":
                    highlight = Character.isLetter(character);
                    break;

                case "vowels":
                    highlight = textAnalyzer.isVowel(character);
                    break;

                case "consonants":
                    highlight = textAnalyzer.isConsonant(character);
                    break;

                case "digits":
                    highlight = textAnalyzer.isDigit(character);
                    break;

                case "special":
                    highlight = textAnalyzer.isSpecialCharacter(character);
                    break;
            }

            if (highlight) {
                text.getStyleClass().add("highlight-" + category);
            } else {
                text.getStyleClass().add("highlight-normal");
            }

            highlightedText.getChildren().add(text);
        }
    }
}