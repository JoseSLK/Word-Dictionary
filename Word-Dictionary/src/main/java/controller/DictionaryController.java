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



    public List<Word> getWordsByLetter(){
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
}
