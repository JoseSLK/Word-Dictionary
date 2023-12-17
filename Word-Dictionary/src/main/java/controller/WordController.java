package controller;

import controller.utilities.InputValidator;
import model.Word;
import model.binary_tree.BinaryTree;
import model.binary_tree.TreeNode;
/**
 * The WordController class manages the operations related to words in the dictionary.
 */
public class WordController {
    /** The input validator for validating and formatting input strings. */
    private InputValidator inputValidator;
    /** The DictionaryController for managing dictionary-related operations. */
    private DictionaryController dictionaryController;

    /**
     * Constructs a new WordController.
     *
     * @param inputValidator        The input validator for validating and formatting input strings.
     * @param dictionaryController  The DictionaryController associated with this WordController.
     */
    public WordController(InputValidator inputValidator, DictionaryController dictionaryController) {
        this.inputValidator = inputValidator;
        this.dictionaryController = dictionaryController;
    }

    /**
     * Retrieves the Binary Tree associated with a given position in the array.
     *
     * @param position The position in the array.
     * @return The Binary Tree associated with the given position.
     */
    public BinaryTree<Word> getBinaryTree( int position){
        return dictionaryController.getTreeLetters()[position];
    }

    /**
     * Adds a new word to the dictionary.
     *
     * @param word      The word to add.
     * @param translation The translation of the word.
     * @param meaning   The meaning of the word.
     * @return True if the word is successfully added, false otherwise.
     */
    public boolean addWord(String word, String translation, String meaning){
        word = inputValidator.capitalizeFirstLetter(word);
        BinaryTree<Word> binaryTree = getBinaryTree(inputValidator.getFirstLetter(word));

        if (binaryTree.findNode(new Word(word, null, null)) != null) {
            return false;
        }

        binaryTree.addNode(new Word(word, translation, meaning));

        if ( !binaryTree.isEmpty() ){
            return binaryTree.findNode(new Word(word, translation, meaning)) != null;
        }
        return false;
    }

    /**
     * Modifies an existing word in the dictionary.
     *
     * @param word      The word to modify.
     * @param translation The new translation of the word.
     * @param meaning   The new meaning of the word.
     * @return True if the word is successfully modified, false otherwise.
     */
    public boolean modifyWord(String word, String translation, String meaning){
        BinaryTree<Word> binaryTree = getBinaryTree(inputValidator.getFirstLetter(word));

        TreeNode<Word> node = binaryTree.findNode(new Word(word, translation, meaning));

        if( node != null ) {
            node.setInfo(new Word(word, translation, meaning));
            return true;
        }

        return false;
    }

    /**
     * Deletes an existing word from the dictionary.
     *
     * @param word The word to delete.
     * @return True if the word is successfully deleted, false otherwise.
     */
    public boolean deleteWord(String word){

        BinaryTree<Word> binaryTree = getBinaryTree(inputValidator.getFirstLetter(word));

        if(binaryTree.isEmpty())return false;

        TreeNode<Word> node = binaryTree.findNode(new Word(word));

        if( node == null )return false;

        Word wordAux = binaryTree.deleteNode(node);

        return true;
    }

    /**
     * Retrieves information about a word in the dictionary.
     *
     * @param word The word to retrieve information for.
     * @return The Word object containing information about the word, or null if the word is not found.
     */
    public Word getWord( String word ) {
        BinaryTree<Word> binaryTree = getBinaryTree(inputValidator.getFirstLetter(word));
        TreeNode<Word> wordA = binaryTree.findNode(new Word(word));

        if(wordA != null){
            return wordA.getInfo();
        }
        return null;
    }

}
