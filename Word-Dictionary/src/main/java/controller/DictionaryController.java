package controller;

import controller.utilities.InputValidator;
import model.Word;
import model.binary_tree.BinaryTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DictionaryController {
    private static BinaryTree<Word>[] treeLetters;
    //Controllers
    private InputValidator inputValidator;
    private WordController wordController;
    public DictionaryController() {
        treeLetters = new BinaryTree[26];
        inputValidator = new InputValidator();
        wordController = new WordController(inputValidator, this);

        for (int i = 0; i < 26 ; i++) {
            treeLetters[i] = new BinaryTree<>((Comparator.comparing(Word::getWord)));
        }

        loadData();
    }

    public BinaryTree<Word> getBinaryTree( int position){
        return getTreeLetters()[position];
    }
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
    public static BinaryTree<Word>[] getTreeLetters() {
        return treeLetters;
    }

    public WordController getWordController() {
        return wordController;
    }

    public void setWordController(WordController wordController) {
        this.wordController = wordController;
    }

    public InputValidator getInputValidator() {
        return inputValidator;
    }

    public void setInputValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

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
