package com.sophomorelearing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileMenuHandler implements ActionListener {
    JFrame jFrame;

    FileMenuHandler(JFrame jFrame){
        this.jFrame = jFrame;
    }

    public void actionPerformed(ActionEvent e) {

        String menuName  = e.getActionCommand();

        if ( menuName == "Quit" )
            System.exit(0);// when click quit
        else if ( menuName == "Open" ){
            JFileChooser jFileChooser = new JFileChooser();

            jFileChooser.showOpenDialog(null);
            File file = jFileChooser.getSelectedFile(); //choose the file in the filechooser and put it to the file instance
            EditMenuHandler.fileIsChose = true;//a file is chosen it returns to true

            Scanner scanner = null;
            try {
                scanner = scanner = new Scanner(file);
            } catch (FileNotFoundException fileNotFoundException) {
            }

            String inputText = " ";
            while (scanner.hasNextLine()) {
                inputText += " " + scanner.nextLine();
            }// combine the multi-lines input into a single line string

            StringTokenizer stringTokenizer = new StringTokenizer(inputText);
            Word key;
            while(stringTokenizer.hasMoreTokens()){
                String keyText = stringTokenizer.nextToken();
                try {
                    key = new Word(keyText);
                    Main.unsorted.add(key);
                    Main.sorted.put(key, " ");
                }catch(IllegalWordException exception){
                    Main.invalid.add(keyText);
                }
            }//put the words in the proper data structure and sort at the same time

            WordGUI.displayGUI(Main.unsorted, Main.sorted, Main.invalid);// display
        }
    }

}
