package com.sophomorelearing;

public class Word{
    private String wordData;

    public Word(String word){
        this.wordData = word;
        if( !isValid(word) )
            throw new IllegalWordException(" ");
    }

    public String toString(){
        return wordData;
    }

    private static boolean isValid(String word){
        boolean isValid = true;
        for (int i = 0; i < word.length(); i++) {
            if( !Character.isLetter(word.charAt(i)) )
                isValid = false;
        }
        return isValid;
    }
}
