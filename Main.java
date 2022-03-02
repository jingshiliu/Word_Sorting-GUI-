package com.sophomorelearing;

import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

    static WordGUI wordGUI;
    public static ArrayList<Word> unsorted = new ArrayList<>();
    public static TreeMap<Word, String> sorted = new TreeMap(new WordComparator());
    public static ArrayList<String> invalid = new ArrayList<>();

    public static void main(String[] args) {

        wordGUI = new WordGUI();// call the gui and the rest functions happen after click the corresponded button

    }
}
