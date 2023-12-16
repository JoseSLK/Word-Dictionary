package controller;

import model.Word;
import model.binary_tree.BinaryTree;

import java.util.Comparator;

public class CentralController {
    private BinaryTree<Word> dictionaryTree;
    private static BinaryTree<Word>[] treeLetters;

    public CentralController(){
        treeLetters = new BinaryTree[26];

        for (int i = 0; i < 26 ; i++) {
            treeLetters[i] = new BinaryTree<>((Comparator.comparing(Word::getWord)));
        }
    }

    public BinaryTree<Word> getDictionaryTree() {
        return dictionaryTree;
    }

    public void setDictionaryTree(BinaryTree<Word> dictionaryTree) {
        this.dictionaryTree = dictionaryTree;
    }

    public static BinaryTree<Word>[] getTreeLetters() {
        return treeLetters;
    }

}
