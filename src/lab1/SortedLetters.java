package lab1;

import java.util.Arrays;
import java.util.Scanner;

public class SortedLetters {
    private String str;

    SortedLetters(String str) {
        this.str = str;
    }

    /**
     * Sorts the letters in each word of the input string alphabetically.
     *
     * @return A new string with sorted letters in each word.
     */
    public String sortLettersInWords() {
        // Split the input string into words based on spaces.
        String[] words = str.split(" ");
        StringBuilder res = new StringBuilder();

        // Iterate through each word in the array.
        for (String word : words) {
            // Initialize a StringBuilder to store sorted letters.
            StringBuilder sortedLetters = new StringBuilder();

            // Initialize a StringBuilder to store non-letter characters.
            StringBuilder nonLetterChars = new StringBuilder();

            // Iterate through each character in the word.
            for (char letter : word.toCharArray()) {
                // Check if the character is a letter.
                if (Character.isLetter(letter)) {
                    // Convert the letter to lowercase and append it to sortedLetters.
                    sortedLetters.append(Character.toLowerCase(letter));
                } else {
                    nonLetterChars.append(letter);
                }
            }

            // Convert the word to a character array for sorting.
            char[] letters = sortedLetters.toString().toCharArray();
            Arrays.sort(letters);

            // Append the sorted word to the result with a space.
            res.append(letters).append(nonLetterChars).append(" ");
        }

        // Convert the result to a string and remove trailing spaces.
        return res.toString().trim();
    }

    // Getter for the original input string.
    public String getStr() {
        return str;
    }

    // Setter for the input string.
    public void setStr(String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        // Create a Scanner for user input.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String inputStr = sc.nextLine();

        if (inputStr.isEmpty()) {
            System.out.println("Input is empty.");
            return;
        }

        // Create an instance of SortedLetters with the input string.
        SortedLetters sortedLetters = new SortedLetters(inputStr);

        // Sort the letters in words and store the result.
        String sortedString = sortedLetters.sortLettersInWords();

        // Display the original input string and the sorted string.
        System.out.println("Original string: " + sortedLetters.getStr());
        System.out.println("Sorted string: " + sortedString);

        // Close the scanner to release resources.
        sc.close();
    }

}
