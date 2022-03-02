package com.sophomorelearing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class WordGUI{
    private static JFrame menu;
    private static Container contentPane;
    private static TextArea invalidArea;
    private static TextArea unsortedArea;
    private static TextArea sortedArea;

    public WordGUI(){
        menu = new JFrame();
        menu.setTitle("Project4");
        menu.setSize(500,500);
        menu.setLocation(550,150);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//initialize GUI

        createMenu();//to create menu(file and edit; open and quit under the file)
    }

    public static void displayGUI(ArrayList<Word> unsorted , TreeMap<Word,String> sorted, ArrayList<String> invalid){

        createTextArea();//create a contentpane with 3 text areas that show Words

        String unsortedList = toVerticalString(unsorted.toString());
        String sortedList = toVerticalString(sorted);
        String invalidList = toVerticalString(invalid.toString());// this enables lists to be shown vertically rather than horizontally

        unsortedArea.append( unsortedList );

        sortedArea.append( sortedList );

        invalidArea.append( invalidList );

    }

    private void createMenu(){
        JMenuBar menuBar = new JMenuBar();
        menu.setJMenuBar(menuBar);
        FileMenuHandler fileMenuHandler = new FileMenuHandler(menu);
        EditMenuHandler editMenuHandler = new EditMenuHandler(menu);

        JMenu file = new JMenu("File");
        menuBar.add(file);
        JMenu edit = new JMenu("Edit");
        menuBar.add(edit);// add file and edit to the menu

        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(fileMenuHandler);
        file.add(open);
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(fileMenuHandler);
        file.add(quit);//add open and quit to the file and also the action listener

        JMenuItem search = new JMenuItem("Search");
        search.addActionListener(editMenuHandler);
        edit.add(search);
    }

    private static void createTextArea(){
        menu.setLayout(new GridLayout(1,3));

        contentPane = menu.getContentPane();
        invalidArea = new TextArea();
        unsortedArea = new TextArea();
        sortedArea = new TextArea();
        contentPane.add(unsortedArea);
        contentPane.add(sortedArea);
        contentPane.add(invalidArea);//create a menu with 3 layouts
    }

    private static String toVerticalString(String word){
        StringTokenizer wordTokens = new StringTokenizer(word, ",");

        String returnString = "";
        while(wordTokens.hasMoreTokens())
            returnString += wordTokens.nextToken() + "\n";

        return returnString;
    }

    private static String toVerticalString(TreeMap<Word, String> sorted){
        Iterator iterator = sorted.keySet().iterator();
        String returningString = "";
        while(iterator.hasNext())
            returningString += iterator.next() + "\n";

        return returningString;
    }
}