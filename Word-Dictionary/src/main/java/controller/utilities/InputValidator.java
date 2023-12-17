package controller.utilities;
/**
 * The InputValidator class provides methods for validating input related to word meanings.
 * It includes checks for valid meanings, words, and methods to manipulate strings.
 *
 * @author JoseSLK
 * @version 1.0
 */
public class InputValidator {

    /**
     * Validates if a meaning is valid. It should not contain spaces or special characters.
     *
     * @param word The meaning to be validated.
     * @return True if the meaning is valid, false otherwise.
     */
    public boolean isValidMeaning( String word ){
        if(!onlyContainsSpaces(word)) return false;
        return true;
    }

    /**
     * Checks if a word contains only letters and doesn't include special characters.
     *
     * @param word The word to be checked.
     * @return True if the word contains only letters, false otherwise.
     */
    public boolean onlyLetters(String word) {
        if (word.contains("@") || word.contains("#") || word.contains("$")) {
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
     * Checks if a word contains only spaces.
     *
     * @param word The word to be checked.
     * @return True if the word contains only spaces, false otherwise.
     */
    public boolean onlyContainsSpaces(String word) {
        return word != null && word.trim().isEmpty();
    }

    /**
     * Validates if a word is valid. It should have a minimum length, contain only letters,
     * and not include spaces.
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
     * Returns the ASCII value of the first letter of the word in uppercase. Useful for
     * locating words in an array.
     *
     * @param word The word from which to extract the first letter.
     * @return The ASCII value of the first letter in uppercase.
     */
    public int getFirstLetter(String word){
        if( word.isEmpty() ) {
            return 0;
        }
        return (int) Character.toUpperCase(word.charAt(0))-65;
    }

    /**
     * Capitalizes the first letter of the string and converts the rest to lowercase.
     *
     * @param str The string to be formatted.
     * @return The string with the first letter capitalized and the rest in lowercase.
     */
    public String capitalizeFirstLetter(String str) {
        if (str == null || str.trim().isEmpty()) {
            return str;
        }

        String trimmedStr = str.trim();
        return Character.toUpperCase(trimmedStr.charAt(0)) + trimmedStr.substring(1).toLowerCase();
    }




}
