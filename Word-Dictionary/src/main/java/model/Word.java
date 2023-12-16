package model;

public class Word {

    private String word;
    private String meaning;
    private String translation;

    public Word(String word, String meaning, String translation) {
        this.word = word;
        this.meaning = meaning;
        this.translation = translation;
    }

    public Word(String word) {
        this.word = word;
    }

    public Word(){}

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                ", translation='" + translation + '\'' +
                '}';
    }
}
