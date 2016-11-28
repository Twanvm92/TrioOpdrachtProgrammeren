/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author lukab
 */
public class controlPanel extends JPanel {
    private JButton overviewBtn_1, overviewBtn_2, overviewBtn_3, overviewBtn_4;
   private JButton button[];
   private netflixView view;;
   
public controlPanel(){
    
    view = new netflixView();
    setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
    
    button = new JButton[6];
    button[0] = overviewBtn_1;
    button[1] =  overviewBtn_2;
    button[2] = overviewBtn_3;
    button[3] = overviewBtn_4;
    
    
            

    
    for (int i= 0; i< 4; i++){
        
        button[i] = new JButton("Overzicht " + (i+1));
        button[i].addActionListener(new controlHandler()); 
        add (button[i]); }
       
}

public class controlHandler implements ActionListener {
    public void actionPerformed (ActionEvent e) {
        
    
           
          
            
        }
    }
}

