package org.lexiscan.model;

public class TextAnalyzer {

    public int countWords(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        int quantity = 0;
        boolean insideWord = false;

        // Check that the "words" contains at least one letter to prevent strings like "@@@" from being considered words.
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {

                if (!insideWord) {
                    quantity++;
                    insideWord = true;
                }

            } else {
                insideWord = false;
            }
        }

        return quantity;
    }

    public int countVowels(String text) {
        if (text == null) {
            return 0;
        }

        int quantity = 0;

        for (char character : text.toCharArray()) {
            if (isVowel(character)) {
                quantity++;
            }
        }

        return quantity;
    }

    public int countConsonants(String text) {
        if (text == null) {
            return 0;
        }

        int quantity = 0;

        for (char character : text.toCharArray()) {
            if (isConsonant(character)) {
                quantity++;
            }
        }

        return quantity;
    }

    public int countDigits(String text) {
        if (text == null) {
            return 0;
        }

        int quantity = 0;

        for (char character : text.toCharArray()) {
            if (isDigit(character)) {
                quantity++;
            }
        }

        return quantity;
    }

    public int countSpecialCharacters(String text) {
        if (text == null) {
            return 0;
        }

        int quantity = 0;

        for (char character : text.toCharArray()) {
            if (isSpecialCharacter(character)) {
                quantity++;
            }
        }

        return quantity;
    }

    public boolean isVowel(char character) {
        character = Character.toLowerCase(character);

        // Make sure accented letters are properly handled.
        return character == 'a'
                || character == 'e'
                || character == 'i'
                || character == 'o'
                || character == 'u'
                || character == 'á'
                || character == 'é'
                || character == 'í'
                || character == 'ó'
                || character == 'ú'
                || character == 'ü';
    }

    public boolean isConsonant(char character) {
        return Character.isLetter(character) && !isVowel(character);
    }

    public boolean isDigit(char character) {
        return Character.isDigit(character);
    }

    //Correction, spaces should be considered as special characters
    public boolean isSpecialCharacter(char character) {
        return !Character.isLetterOrDigit(character);
    }
}