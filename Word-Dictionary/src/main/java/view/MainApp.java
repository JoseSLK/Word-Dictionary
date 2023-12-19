package view;

import controller.DictionaryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The MainApp class represents the main user interface of the dictionary application.
 * It provides functionality for searching, modifying, deleting, and adding words to the dictionary.
 */
public class MainApp  extends JPanel implements ActionListener {
    // JFrame instances for the main, modify, and add windows
    private JFrame main;
    private JFrame modify;
    // JPanels for organizing the layout
    private JPanel rigth,up,down;
    // Buttons for various actions
    private JButton searchButton, ShowListbyLetterButton, modifyWordButton,
            deleteWordButton, exitButton, addWordButton, listEveryWordsButton,
            addConfirmButton, cancelAddButton, confirmModifyButton, cancelButtom;
    // TextFields for user input
    private JTextField field1;
    private JTextField field5,field6,field7,fieldx,fieldy;
    private JList list;
    private DictionaryController dic;
    private JFrame add;
    private JPanel panel5;
    private JPanel panel6;
    // Labels for guiding user input
    private JLabel label5,label6,label7,labelx,labely;
    private DefaultListModel model;

    /**
     * Constructor for the MainApp class.
     * Initializes the UI components and sets up action listeners.
     */
    public MainApp(){
        main = new JFrame("Diccionario");
        modify = new JFrame("Diccionario");
        rigth = new JPanel();
        up = new JPanel();
        down = new JPanel();
        searchButton = new JButton("buscar");
        searchButton.addActionListener(this);
        ShowListbyLetterButton = new JButton("mostrar por letra");
        ShowListbyLetterButton.addActionListener(this);
        modifyWordButton = new JButton("modificar palabra");
        modifyWordButton.addActionListener(this);
        deleteWordButton = new JButton("eliminar palabra");
        deleteWordButton.addActionListener(this);
        exitButton = new JButton("salir");
        exitButton.addActionListener(this);
        addWordButton = new JButton("agregar palabra");
        addWordButton.addActionListener(this);
        listEveryWordsButton = new JButton("todas las palabras");
        listEveryWordsButton.addActionListener(this);
        confirmModifyButton = new JButton("modificar");
        confirmModifyButton.addActionListener(this);
        cancelButtom = new JButton("cancelar");
        cancelButtom.addActionListener(this);
        field1 = new JTextField();
        model = new DefaultListModel();
        list = new JList();
        dic = new DictionaryController();
        add = new JFrame("Diccionario");
        panel5 = new JPanel();
        panel6 = new JPanel();
        addConfirmButton = new JButton("agregar");
        addConfirmButton.addActionListener(this);
        cancelAddButton = new JButton("cancelar");
        cancelAddButton.addActionListener(this);
        field5 = new JTextField();
        field6 = new JTextField();
        field7 = new JTextField();
        label5 = new JLabel("palabra  >");
        label6 = new JLabel("traducción  >");
        label7 = new JLabel("significado  >");
        labelx = new JLabel("nueva traducción  >");
        labely = new JLabel("nuevo significado  >");
        fieldx = new JTextField();
        fieldy = new JTextField();
        colorButtons();
    }

    /**
     * Sets the background color for various buttons.
     */
    public void colorButtons(){
        Color buttonColorConfirm = new Color(0xD5F5E3);
        Color buttonColorCancel = new Color(0xFADBD8 );
        Color buttonColorPurple = new Color(0xE8DAEF );
        Color buttonColorYellow = new Color(0xFCF3CF );
        Color buttonColorBlack = new Color(0xD5D8DC );

        addConfirmButton.setBackground(buttonColorConfirm);
        confirmModifyButton.setBackground(buttonColorConfirm);

        cancelAddButton.setBackground(buttonColorCancel);
        cancelButtom.setBackground(buttonColorCancel);
        exitButton.setBackground(buttonColorBlack);

        searchButton.setBackground(buttonColorBlack);

        addWordButton.setBackground(buttonColorYellow);
        ShowListbyLetterButton.setBackground(buttonColorBlack);
        modifyWordButton.setBackground(buttonColorYellow);
        deleteWordButton.setBackground(buttonColorBlack);
        listEveryWordsButton.setBackground(buttonColorYellow);
    }
    /**
     * Initializes the main window and sets up the layout.
     */
    public void main(){
        buttons();
        fields();
        main.setSize(1000,550);
        main.setLayout((LayoutManager) null);
        main.add(rigth());
        main.add(up());
        main.add(down());
        main.setResizable(false);
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }
    /**
     * Initializes the add window and sets up the layout.
     */
    public void add(){
        labels();
        fields();
        add.setSize(600,240);
        add.setLayout((LayoutManager) null);
        add.add(panel());
        add.setResizable(false);
        add.setLocationRelativeTo(null);
        add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add.setVisible(true);
    }

    /**
     * Initializes the modify window and sets up the layout.
     */
    public void modify(){
        labels();
        fields();
        modify.setSize(600,240);
        modify.setLayout((LayoutManager) null);
        modify.add(panel6());
        modify.setResizable(false);
        modify.setLocationRelativeTo(null);
        modify.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        modify.setVisible(true);
    }
    /**
     * Sets the labels and their positions.
     */
    public void labels(){
        label5.setBounds(15,25,70,15);
        label5.setBackground(Color.black);
        label6.setBounds(286,25,90,15);
        label6.setBackground(Color.black);
        label7.setBounds(15,90,90,15);
        label7.setBackground(Color.black);
        labelx.setBounds(15,25,130,15);
        labelx.setBackground(Color.black);
        labely.setBounds(15,90,130,15);
        labely.setBackground(Color.black);
    }

    /**
     * Sets up the layout for the right panel.
     *
     * @return JPanel for the right panel layout.
     */
    public JPanel rigth(){
        rigth.setBounds(752,4,228,503);
        rigth.setLayout((LayoutManager) null);
        rigth.add(ShowListbyLetterButton);
        rigth.add(modifyWordButton);
        rigth.add(deleteWordButton);
        rigth.add(exitButton);
        rigth.add(addWordButton);
        rigth.add(listEveryWordsButton);
        rigth.setBackground(Color.WHITE);
        return rigth;
    }
    /**
     * Sets up the layout for the add window panel.
     *
     * @return JPanel for the add window panel layout.
     */
    public JPanel panel(){
        panel5.setBounds(4,4,576,194);
        panel5.setLayout((LayoutManager) null);
        panel5.setBackground(Color.WHITE);
        panel5.add(label5);
        panel5.add(label7);
        panel5.add(label6);
        panel5.add(field5);
        panel5.add(field6);
        panel5.add(field7);
        panel5.add(addConfirmButton);
        panel5.add(cancelAddButton);
        return panel5;
    }

    /**
     * Sets up the layout for the modify window panel.
     *
     * @return JPanel for the modify window panel layout.
     */
    public JPanel panel6(){
        panel6.setBounds(4,4,576,194);
        panel6.setLayout((LayoutManager) null);
        panel6.add(cancelButtom);
        panel6.add(confirmModifyButton);
        panel6.add(fieldx);
        panel6.add(fieldy);
        panel6.add(labelx);
        panel6.add(labely);
        panel6.setBackground(Color.WHITE);
        return panel6;
    }

    /**
     * Sets up the layout for the up panel.
     *
     * @return JPanel for the up panel layout.
     */
    public JPanel up(){
        up.setBounds(4,4,744,64);
        up.setLayout((LayoutManager) null);
        up.add(searchButton);
        up.add(field1);
        up.setBackground(Color.WHITE);
        return up;
    }

    /**
     * Sets up the layout for the down panel.
     *
     * @return JPanel for the down panel layout.
     */
    public JPanel down(){
        down.setBounds(4,72,744,435);
        down.setLayout((LayoutManager) null);
        down.add(pane());
        down.setBackground(Color.WHITE);
        return down;
    }

    /**
     * Sets up the buttons and their positions.
     */
    public void buttons(){
        searchButton.setBounds(532,13,200,38);
        ShowListbyLetterButton.setBounds(15,210,200,38);
        modifyWordButton.setBounds(15,254,200,38);
        deleteWordButton.setBounds(15,298,200,38);
        exitButton.setBounds(15,445,200,38);
        addWordButton.setBounds(15,166,200,38);
        listEveryWordsButton.setBounds(15,342,200,38);
        addConfirmButton.setBounds(310,140,250,40);
        cancelAddButton.setBounds(15,140,250,40);
        confirmModifyButton.setBounds(310,140,250,40);
        cancelButtom.setBounds(15,140,250,40);
    }

    /**
     * Sets up the JScrollPane containing the word list.
     *
     * @return JScrollPane for the word list.
     */
    public JScrollPane pane(){
        list.setModel(model);
        list.setBackground(Color.WHITE);
        all();
        JScrollPane pane = new JScrollPane(list);
        pane.setBounds(10, 10,724,415);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        return pane;
    }

    /**
     * Populates the word list with all words in the dictionary.
     */
    public void all(){
        model.removeAllElements();
        for (int i = 0; i < DictionaryController.getTreeLetters().length; i++){
            for (int j = 0; j < DictionaryController.getTreeLetters()[i].listInsort().size(); j++){
                model.addElement(DictionaryController.getTreeLetters()[i].listInsort().get(j).getWord() + " ||| " +
                        DictionaryController.getTreeLetters()[i].listInsort().get(j).getMeaning() + "  |||  " +
                        DictionaryController.getTreeLetters()[i].listInsort().get(j).getTranslation());
            }
        }
    }

    /**
     * Sets up the positions for text fields.
     */
    public void fields(){
        field1.setBounds(13,13,510,39);
        field5.setBounds(78,20,200,30);
        field6.setBounds(368,20,200,30);
        field7.setBounds(95,80,473,30);
        fieldx.setBounds(142,20,419,30);
        fieldy.setBounds(142,80,419,30);
    }


    /**
     * Handles button click events and performs corresponding actions.
     *
     * @param e ActionEvent representing the button click event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == searchButton){

            if (!dic.getInputValidator().isValidWord(field1.getText())){
                JOptionPane.showMessageDialog(null,"Digita una palabra valida");
            }else if( dic.getInputValidator().onlyContainsSpaces(field1.getText())){
                JOptionPane.showMessageDialog(null, "Hay campos vacios");
            }else {
                String word = dic.getInputValidator().capitalizeFirstLetter(field1.getText());

                if(dic.getWordController().getWord(word) == null){
                    JOptionPane.showMessageDialog(null, "La palabra no existe");
                }else {

                    String find = dic.getWordController().getWord(word).getWord()+" ||| " + dic.getWordController().getWord(word).getMeaning() + " ||| " +
                            dic.getWordController().getWord(word).getTranslation()+ " ";
                     model.removeAllElements();
                     model.addElement(find);

                }
            }
        }

        if( e.getSource() == ShowListbyLetterButton){
            if (!dic.getInputValidator().onlyLetters(field1.getText())){
                JOptionPane.showMessageDialog(null,"Digita una entrada valida");
            }else if( dic.getInputValidator().onlyContainsSpaces(field1.getText())){
                JOptionPane.showMessageDialog(null, "Hay campos vacios");
            }else{
                String word = dic.getInputValidator().capitalizeFirstLetter(field1.getText());

                model.removeAllElements();
                List<String>str = dic.getWordsByLetter(word);
                if(str != null){
                    for (int i = 0; i < str.size(); i++){
                        model.addElement(str.get(i));
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "No hay palabras con esta letra");
                }
            }
        }
        if( e.getSource() == modifyWordButton){
            if(list.getSelectedValue() != null){
                modify();
                String[] word = list.getSelectedValue().toString().split("\\|\\|\\|");
                String firstWord = word[0].trim();
                String wordFormat = dic.getInputValidator().capitalizeFirstLetter(firstWord);
                fieldy.setText(dic.getWordController().getWord(wordFormat).getTranslation());
                fieldx.setText(dic.getWordController().getWord(wordFormat).getMeaning());
            }else{
                JOptionPane.showMessageDialog(null,"Selecciona una palabra, para ello haz clic en la lista");
            }
        }
        if( e.getSource() == deleteWordButton){
            try{
                String[] word = list.getSelectedValue().toString().split("\\|\\|\\|");
                String firstWord = word[0].trim();
                String wordFormat = dic.getInputValidator().capitalizeFirstLetter(firstWord);

                dic.getWordController().deleteWord(wordFormat);
                model.remove(list.getSelectedIndex());
            }catch (NullPointerException exception){
                JOptionPane.showMessageDialog(null, "Selecciona una palabra haciendo click en la lista");
            }

        }
        if( e.getSource() == exitButton){
            main.dispose();
        }
        if( e.getSource() == addWordButton){
            add();
            main.setVisible(false);
        }

        if (e.getSource() == addConfirmButton) {
            String word = dic.getInputValidator().capitalizeFirstLetter(field5.getText());
            String translation = dic.getInputValidator().capitalizeFirstLetter(field6.getText());
            String meaning = dic.getInputValidator().capitalizeFirstLetter(field7.getText());
            if (dic.getInputValidator().isValidWord(word) && dic.getInputValidator().isValidWord(translation) && !meaning.isEmpty()) {
                if (dic.getWordController().addWord(word, translation, meaning)) {
                    all();
                    field5.setText("");
                    field6.setText("");
                    field7.setText("");
                    main.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Esta palabra ya existe en el diccionario");
                }
            } else {
                if (!dic.getInputValidator().isValidWord(translation)) {
                    JOptionPane.showMessageDialog(null, "La traducción no es válida");
                } else if (field7.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "La descripción no puede estar vacía");
                }else if (!dic.getInputValidator().isValidWord(word)) {
                    JOptionPane.showMessageDialog(null, "La palabra no es válida");
                }
            }
        }


        if( e.getSource() == listEveryWordsButton){
            all();
        }

        if(e.getSource() == cancelAddButton){
            add.dispose();
            main.setVisible(true);
        }

        if(e.getSource() == cancelButtom){
            modify.dispose();
            main.setVisible(true);
        }

        if(e.getSource() == confirmModifyButton){
            System.out.println(fieldy.getText());
            String tra = dic.getInputValidator().capitalizeFirstLetter(fieldx.getText());
            String des = dic.getInputValidator().capitalizeFirstLetter(fieldy.getText());
            if(des.equals("") || !dic.getInputValidator().isValidWord(tra)) {
                if (fieldy.getText().equals("")) JOptionPane.showMessageDialog(null, "El significado no puede estar vacio");
                else JOptionPane.showMessageDialog(null, "La traduccion debe ser una palabra valida");
            } else {
                String[] word = list.getSelectedValue().toString().split("\\|\\|\\|");
                String firstWord = word[0].trim();
                String wordFormat = dic.getInputValidator().capitalizeFirstLetter(firstWord);

                dic.getWordController().modifyWord(wordFormat, tra, des);

                model.removeAllElements();
                fieldx.setText("");
                fieldy.setText("");

                String find = dic.getWordController().getWord(wordFormat).getWord()+" ||| " + dic.getWordController().getWord(wordFormat).getMeaning() + " ||| " +
                        dic.getWordController().getWord(wordFormat).getTranslation()+ " ";

                model.addElement(find);

                modify.dispose();
                main.setVisible(true);
            }
        }
    }
}
