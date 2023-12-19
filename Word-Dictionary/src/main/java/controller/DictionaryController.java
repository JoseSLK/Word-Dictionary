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
        getWordController().addWord("Aventura", "Adventure", "Exploración emocionante");
        getWordController().addWord("Innovación", "Innovation", "Introducción de nuevas ideas");
        getWordController().addWord("Creatividad", "Creativity", "Capacidad de crear algo nuevo");
        getWordController().addWord("Conocimiento", "Knowledge", "Información y comprensión adquiridas");
        getWordController().addWord("Fascinación", "Fascination", "Encanto o interés intenso");
        getWordController().addWord("Serenidad", "Serenity", "Tranquilidad y calma profunda");
        getWordController().addWord("Melodía", "Melody", "Secuencia armoniosa de sonidos");
        getWordController().addWord("Euforia", "Euphoria", "Estado de alegría intensa");
        getWordController().addWord("Resiliencia", "Resilience", "Capacidad de recuperarse frente a desafíos");
        getWordController().addWord("Exploración", "Exploration", "Viaje para descubrir lo desconocido");
        getWordController().addWord("anon", "anon", "Es un anon");
        getWordController().addWord("Arcoiris", "Rainbow", "Fenómeno óptico y meteorológico");
        getWordController().addWord("Bosque", "Forest", "Área extensa con árboles y vegetación");
        getWordController().addWord("Canción", "Song", "Composición musical con letra");
        getWordController().addWord("Delfín", "Dolphin", "Mamífero marino inteligente");
        getWordController().addWord("Elefante", "Elephant", "Mamífero de gran tamaño con trompa");
        getWordController().addWord("Fotografía", "Photography", "Captura de imágenes con una cámara");
        getWordController().addWord("Guitarra", "Guitar", "Instrumento musical de cuerdas");
        getWordController().addWord("Helado", "Ice Cream", "Postre congelado y delicioso");
        getWordController().addWord("Isla", "Island", "Área de tierra rodeada de agua");
        getWordController().addWord("Jardín", "Garden", "Área cultivada con plantas");
        getWordController().addWord("Kangaroo", "Canguro", "Mamífero marsupial saltador");
        getWordController().addWord("Luna", "Moon", "Satélite natural de la Tierra");
        getWordController().addWord("Montaña", "Mountain", "Elevación natural de la tierra");
        getWordController().addWord("Nube", "Cloud", "Agregado visible de gotas de agua o cristales de hielo");
        getWordController().addWord("Océano", "Ocean", "Extensión grande de agua salada");
        getWordController().addWord("Piano", "Piano", "Instrumento musical de teclado");
        getWordController().addWord("Quasar", "Quásar", "Objeto astronómico extremadamente brillante");
        getWordController().addWord("Río", "River", "Corriente natural de agua");
        getWordController().addWord("Sol", "Sun", "Estrella central de nuestro sistema solar");
        getWordController().addWord("Tigre", "Tiger", "Gran felino rayado");
        getWordController().addWord("Universo", "Universe", "Todo lo que existe, incluyendo espacio y tiempo");
        getWordController().addWord("Violeta", "Violet", "Color entre azul y púrpura");
        getWordController().addWord("Waterfall", "Cascada", "Caída de agua natural");
        getWordController().addWord("Xylophone", "Xilófono", "Instrumento musical de percusión");
        getWordController().addWord("Yoga", "Yoga", "Práctica física y mental");
        getWordController().addWord("Zafiro", "Sapphire", "Gema preciosa de color azul");
    }
}
