package com.sophomorelearing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMenuHandler implements ActionListener {
    JFrame jFrame;
    public static boolean fileIsChose = false;//this variable checks if a file has been chose
                                              //because the program will tell the word is not the
                                              // treemap even there is no chosen file

    public EditMenuHandler(JFrame jFrame){
        this.jFrame = jFrame;
    }

    public void actionPerformed(ActionEvent e) {

        String menuName = e.getActionCommand();

        if(menuName.equals("Search")){
            Word word = new Word( JOptionPane.showInputDialog("Enter a Word to search") );

            if( !fileIsChose )
                JOptionPane.showMessageDialog(null,"Chose a file before search a word");
            else if(Main.sorted.containsKey(word))
                JOptionPane.showMessageDialog(null,"Your word is in the TreeMap");
            else
                JOptionPane.showMessageDialog(null,"Your word is not in the TreeMap");
        }
    }
}
