package controller;

import controller.utilities.InputValidator;
import model.Word;
import model.binary_tree.BinaryTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The DictionaryController class manages the operations related to the dictionary.
 */
public class DictionaryController {
    /** An array of Binary Trees to store words grouped by their first letter. */
    private static BinaryTree<Word>[] treeLetters;
    /** The input validator for validating and formatting input strings. */
    private InputValidator inputValidator;
    /** The WordController for managing word-related operations. */
    private WordController wordController;

    /**
     * Constructs a new DictionaryController.
     * Initializes the array of Binary Trees and loads initial data into the dictionary.
     */
    public DictionaryController() {
        treeLetters = new BinaryTree[26];
        inputValidator = new InputValidator();
        wordController = new WordController(inputValidator, this);

        for (int i = 0; i < 26 ; i++) {
            treeLetters[i] = new BinaryTree<>((Comparator.comparing(Word::getWord)));
        }

        loadData();
    }
    /**
     * Lists all words grouped by their first letter.
     *
     * @return A list of lists containing words grouped by their first letter.
     */
    public List<List<Word>> listAllWordsGroupedByLetter() {
        List<List<Word>> listAllWords = new ArrayList<>();

        for (int i = 0; i < treeLetters.length; i++) {
            List<Word> words = treeLetters[i].listAmplitudeDown();
            if (words != null) {
                listAllWords.add(words);
            }
        }

        return listAllWords;
    }

    /**
     * Retrieves words associated with a given letter.
     *
     * @param letter The letter to retrieve words for.
     * @return A list of words associated with the given letter.
     */
    public List<String> getWordsByLetter(String letter){
        List<String> out = new ArrayList<>();
        if(treeLetters[inputValidator.getFirstLetter(letter)].listAmplitudeDown() != null){
            List<Word> words =  treeLetters[inputValidator.getFirstLetter(letter)].listAmplitudeDown();
            for ( Word word: words){
                out.add(word.toString());
            }
            return out;
        }
        return null;
    }
    /**
     * Retrieves the array of Binary Trees.
     *
     * @return The array of Binary Trees.
     */
    public static BinaryTree<Word>[] getTreeLetters() {
        return treeLetters;
    }

    /**
     * Retrieves the WordController associated with this DictionaryController.
     *
     * @return The WordController.
     */
    public WordController getWordController() {
        return wordController;
    }

    /**
     * Sets the WordController for this DictionaryController.
     *
     * @param wordController The WordController to set.
     */
    public void setWordController(WordController wordController) {
        this.wordController = wordController;
    }

    /**
     * Retrieves the InputValidator associated with this DictionaryController.
     *
     * @return The InputValidator.
     */
    public InputValidator getInputValidator() {
        return inputValidator;
    }

    /**
     * Sets the InputValidator for this DictionaryController.
     *
     * @param inputValidator The InputValidator to set.
     */
    public void setInputValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    /**
     * Loads initial data into the dictionary.
     */
    public void loadData(){
        getWordController().addWord("Manzanas", "Apples", "Son frutas");
        getWordController().addWord("Naranjas", "Oranges", "Son cítricos");
        getWordController().addWord("Plátanos", "Bananas", "Son amarillos");
        getWordController().addWord("Fresas", "Strawberries", "Son rojas");
        getWordController().addWord("Uvas", "Grapes", "Son moradas");
        getWordController().addWord("Mangos", "Mangoes", "Son tropicales");
        getWordController().addWord("Piñas", "Pineapples", "Son espinosas");
        getWordController().addWord("Melones", "Melons", "Son jugosos");
        getWordController().addWord("Sandías", "Watermelons", "Son refrescantes");
        getWordController().addWord("Cerezas", "Cherries", "Son dulces");
        getWordController().addWord("anon", "anon", "Es un anon");
    }
}
