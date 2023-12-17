package model;

/**
 * The Word class represents a word in the dictionary.
 */
public class Word {
    /**
     * The word itself.
     */
    private String word;
    /**
     * The meaning of the word.
     */
    private String meaning;
    /**
     * The translation of the word.
     */
    private String translation;

    /**
     * Constructs a Word object with the specified word, meaning, and translation.
     *
     * @param word        The word itself.
     * @param meaning     The meaning of the word.
     * @param translation The translation of the word.
     */
    public Word(String word, String meaning, String translation) {
        this.word = word;
        this.meaning = meaning;
        this.translation = translation;
    }

    /**
     * Constructs a Word object with only the specified word.
     *
     * @param word The word itself.
     */
    public Word(String word) {
        this.word = word;
    }

    /**
     * Default constructor for the Word class.
     */
    public Word(){}

    /**
     * Gets the word itself.
     *
     * @return The word itself.
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the word itself.
     *
     * @param word The new word value.
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Gets the meaning of the word.
     *
     * @return The meaning of the word.
     */
    public String getMeaning() {
        return meaning;
    }

    /**
     * Sets the meaning of the word.
     *
     * @param meaning The new meaning value.
     */
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    /**
     * Gets the translation of the word.
     *
     * @return The translation of the word.
     */
    public String getTranslation() {
        return translation;
    }

    /**
     * Sets the translation of the word.
     *
     * @param translation The new translation value.
     */
    public void setTranslation(String translation) {
        this.translation = translation;
    }

    /**
     * Returns a formatted string representation of the Word object.
     *
     * @return A formatted string representation of the Word object.
     */
    @Override
    public String toString() {
        return "  " + word + " ||| " +
                meaning + " ||| " +
                translation + "|";
    }
}
