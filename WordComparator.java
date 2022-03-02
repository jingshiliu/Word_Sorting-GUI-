package com.sophomorelearing;

import java.util.Comparator;

public class WordComparator implements Comparator <Word> {

    public int compare(Word word1, Word word2) {
        return word1.toString().compareTo(word2.toString());
    }
}
