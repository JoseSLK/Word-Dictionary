package model.binary_tree;

import controller.DictionaryController;
import model.Word;

import java.util.Comparator;
import java.util.List;

public class Hj {
    public static void main(String[] args) {
        BinaryTree<Integer> bts = new BinaryTree<>((Integer::compare));
        //BinaryTree<Word> btw = new BinaryTree<>(Comparator.comparing(Word::getWord));

        bts.addNode(50);
        bts.addNode(10);
        bts.addNode(69);
        bts.addNode(5);
        bts.addNode(34);
        bts.addNode(57);
        bts.addNode(95);
        bts.addNode(18);
        bts.addNode(40);
        bts.addNode(63);
        bts.addNode(120);
        bts.addNode(100);

        DictionaryController dictionaryController = new DictionaryController();
        System.out.println(dictionaryController.getWordController().addWord("Manzanas", "Apples", "Son frutas"));
        System.out.println(dictionaryController.getWordController().addWord("Naranjas", "Oranges", "Son cítricos"));
        System.out.println(dictionaryController.getWordController().addWord("Plátanos", "Bananas", "Son amarillos"));
        System.out.println(dictionaryController.getWordController().addWord("Fresas", "Strawberries", "Son rojas"));
        System.out.println(dictionaryController.getWordController().addWord("Uvas", "Grapes", "Son moradas"));
        System.out.println(dictionaryController.getWordController().addWord("Mangos", "Mangoes", "Son tropicales"));
        System.out.println(dictionaryController.getWordController().addWord("Piñas", "Pineapples", "Son espinosas"));
        System.out.println(dictionaryController.getWordController().addWord("Melones", "Melons", "Son jugosos"));
        System.out.println(dictionaryController.getWordController().addWord("Sandías", "Watermelons", "Son refrescantes"));
        System.out.println(dictionaryController.getWordController().addWord("Cerezas", "Cherries", "Son dulces"));
        System.out.println(dictionaryController.getWordController().addWord("anon", "anon", "Es un anon"));
        //System.out.println(dictionaryController.getWordController().deleteWord("Papas"));
        //System.out.println(dictionaryController.getWordController().getWord("Papas"));
        System.out.println("/////////////////");

        List<List<Word>> list = dictionaryController.listAllWordsGroupedByLetter();
        if (list == null) {
            System.out.println("La lista es nula");
        }

        for (int i = 0; i < list.size(); i++) {
            List<Word> aux = list.get(i);
            if (aux == null) {
                continue;
            }
            for (int j = 0; j < aux.size(); j++) {
                System.out.println(aux.get(j));
            }
        }



        // bts.addNode(96);


        //Recorre por niveles el arbol
        //bts.listAmplitudeTop().forEach(System.out::println);

        //Recorre los nodos en orden de isquierda a derecha
        //bts.listPresort().forEach(System.out::println);

        //Los recorre y guarda organizados
         //bts.listInsort().forEach(System.out::println);

        //Ultimo de izquierda a derecha
        //bts.listPosort().forEach(System.out::println);

        //Peso de arbol (Numero de nodos)
        //System.out.println(bts.weigthTree());
        //System.out.println(bts.heightTree());
        //System.out.println(bts.heightNode(bts.findNode(95)));
        //System.out.println(bts.gradeNode(bts.findNode(69)));
        //System.out.println(bts.isLeaf(bts.findNode(18)));
    }
}
