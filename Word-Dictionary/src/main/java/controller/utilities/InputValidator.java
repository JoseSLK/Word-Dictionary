package controller.utilities;
/**
 *The InputValidator class provides methods for validating and formatting input strings.
 * @author JoseSLK
 * @version 1.0
 */
public class InputValidator {

    /**
     * Checks if a given string contains only letters.
     *
     * @param word The string to be checked.
     * @return True if the string contains only letters, false otherwise.
     */
    public boolean onlyLetters(String word) {
        if (word.contains("@") || word.contains("#") || word.contains("$") || word.contains("ñ")) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (currentChar == ' ') {
                return false;
            }

            if (!Character.isLetter(currentChar)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a given string contains only spaces.
     *
     * @param word The string to be checked.
     * @return True if the string contains only spaces, false otherwise.
     */
    public boolean onlyContainsSpaces(String word) {
        return word != null && word.trim().isEmpty();
    }

    /**
     * Validates a word based on specific criteria.
     *
     * @param word The word to be validated.
     * @return True if the word is valid, false otherwise.
     */
    public boolean isValidWord(String word){

        int minLength = 3;

        if (word.length() < minLength ) {
            return false;
        }
        if(!onlyLetters(word)) return false;
        if (onlyContainsSpaces(word)) return false;

        return true;
    }

    /**
     * Retrieves the index of the first letter in uppercase.
     *
     * @param word The word from which to retrieve the first letter.
     * @return The index of the first letter in uppercase.
     */
    public int getFirstLetter(String word){
        if( word.isEmpty() ) {
            return 0;
        }
        return (int) Character.toUpperCase(word.charAt(0))-65;
    }

    /**
     * Capitalizes the first letter of a string.
     *
     * @param str The string to be formatted.
     * @return The string with the first letter capitalized.
     */
    public String capitalizeFirstLetter(String str) {
        if (str == null || str.trim().isEmpty()) {
            return str;
        }

        String trimmedStr = str.trim();
        return Character.toUpperCase(trimmedStr.charAt(0)) + trimmedStr.substring(1).toLowerCase();
    }




}
