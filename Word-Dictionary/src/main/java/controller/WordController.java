package controller;

import controller.utilities.InputValidator;
import model.Word;
import model.binary_tree.BinaryTree;
import model.binary_tree.TreeNode;

public class WordController {
    private InputValidator inputValidator;
    private DictionaryController dictionaryController;

    public WordController(InputValidator inputValidator, DictionaryController dictionaryController) {
        this.inputValidator = inputValidator;
        this.dictionaryController = dictionaryController;
    }

    public BinaryTree<Word> getBinaryTree( int position){
        return dictionaryController.getTreeLetters()[position];
    }

    public boolean addWord(String word, String traslation, String meaning){
        word = inputValidator.capitalizeFirstLetter(word);
        BinaryTree<Word> binaryTree = getBinaryTree(inputValidator.getFirstLetter(word));

        if (binaryTree.findNode(new Word(word, null, null)) != null) {
            return false;
        }

        binaryTree.addNode(new Word(word, traslation, meaning));

        if ( !binaryTree.isEmpty() ){
            return binaryTree.findNode(new Word(word, traslation, meaning)) != null;
        }
        return false;
    }

    public boolean modifyWord(String word, String traslation, String meaning){
        BinaryTree<Word> binaryTree = getBinaryTree(inputValidator.getFirstLetter(word));

        TreeNode<Word> node = binaryTree.findNode(new Word(word, traslation, meaning));

        if( node != null ) {
            node.setInfo(new Word(word, traslation, meaning));
            return true;
        }

        return false;
    }

    public boolean deleteWord(String word){

        BinaryTree<Word> binaryTree = getBinaryTree(inputValidator.getFirstLetter(word));

        if(binaryTree.isEmpty())return false;

        TreeNode<Word> node = binaryTree.findNode(new Word(word));

        if( node == null )return false;

        Word wordAux = binaryTree.deleteNode(node);

        return true;
    }

    public Word getWord( String word ) {
        BinaryTree<Word> binaryTree = getBinaryTree(inputValidator.getFirstLetter(word));
        TreeNode<Word> wordA = binaryTree.findNode(new Word(word));

        if(wordA != null){
            return wordA.getInfo();
        }
        return null;
    }

}
