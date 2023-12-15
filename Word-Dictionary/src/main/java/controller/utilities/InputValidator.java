package controller.utilities;

public class InputValidator {
    /**
     * Este metodo verifia si la palabra ingrasada es valida.(Nos sirve para la traduccion)
     * No sera valida si contiene espacios,un numero o caracter especial*/
    public boolean isValidWord(String word){

        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == 32) continue;
            if (word.charAt(i) < 65) return false;
            if (word.charAt(i) > 90 && word.charAt(i) < 97) return false;
            if (word.charAt(i) > 122) return false;
        }
        return false;
    }

    /**
     * Este metodo verifia que la definicion de la palabra no contenga caracteres especiales,
     * exclutendo a la "coma" y numeros*/
    public boolean isValidDefinition(String definition){
        return false;
    }

    /**
     * Devuelve la primera letra de la palabra en mayuscula,
     * esto sera util para ubicar en el arreglo las palabras*/
    public char getFirstLetter(String word){
        if( word.isEmpty() ) {
            return 0;
        }
        return Character.toUpperCase(word.charAt(0));
    }
    /**Verifica que una palabra no sea una sola letra y espacios*/
    public boolean isValidLetter(String input){
        return false;
    }


}
