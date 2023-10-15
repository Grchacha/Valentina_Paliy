package org.example;

public class CaesarCipher {
    private static final String ENGLISH_ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ENGLISH_ALPHABET_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UKRAINIAN_ALPHABET_UPPER = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
    private static final String UKRAINIAN_ALPHABET_LOWER = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";

    public static String encrypt(String text, int key, String alphabet) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (alphabet.indexOf(c) != -1) {
                int index = alphabet.indexOf(c);
                int newIndex = (index + key) % alphabet.length();
                result.append(alphabet.charAt(newIndex));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    private static String applyCipher(String text, int key, boolean encrypt) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (ENGLISH_ALPHABET_UPPER.indexOf(c) != -1) {
                result.append(shiftCharacter(c, ENGLISH_ALPHABET_UPPER, 3, encrypt));
            } else if (ENGLISH_ALPHABET_LOWER.indexOf(c) != -1) {
                result.append(shiftCharacter(c, ENGLISH_ALPHABET_LOWER, 3, encrypt));
            } else if (UKRAINIAN_ALPHABET_UPPER.indexOf(c) != -1) {
                result.append(shiftCharacter(c, UKRAINIAN_ALPHABET_UPPER, 3, encrypt));
            } else if (UKRAINIAN_ALPHABET_LOWER.indexOf(c) != -1) {
                result.append(shiftCharacter(c, UKRAINIAN_ALPHABET_LOWER, 3, encrypt));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    private static char shiftCharacter(char c, String alphabet, int key, boolean encrypt) {
        int index = alphabet.indexOf(c);
        int newIndex;
        if (encrypt) {
            newIndex = (index + key) % alphabet.length();
        } else {
            newIndex = (index - key + alphabet.length()) % alphabet.length();
        }
        return alphabet.charAt(newIndex);
    }

    public static void bruteForce(String text) {
        System.out.println("Brute Force Results for English Alphabet:");
        bruteForceForAlphabet(text, ENGLISH_ALPHABET_UPPER, ENGLISH_ALPHABET_LOWER);

        System.out.println("\nBrute Force Results for Ukrainian Alphabet:");
        bruteForceForAlphabet(text, UKRAINIAN_ALPHABET_UPPER, UKRAINIAN_ALPHABET_LOWER);
    }

    private static void bruteForceForAlphabet(String text, String upperAlphabet, String lowerAlphabet) {
        for (int key = 0; key < upperAlphabet.length(); key++) {
            System.out.println("Key " + key + " (English Upper): " + decrypt(text, key, upperAlphabet));
            System.out.println("Key " + key + " (English Lower): " + decrypt(text, key, lowerAlphabet));
        }
    }

    public static String decrypt(String text, int key, String alphabet) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (alphabet.indexOf(c) != -1) {
                int index = alphabet.indexOf(c);
                int newIndex = (index - key + alphabet.length()) % alphabet.length();
                result.append(alphabet.charAt(newIndex));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
