/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import trio.domain.Cards;

/**
 *
 * @author lukab
 */
public class controlPanel extends JPanel {
    private JButton overviewBtn_1, overviewBtn_2, overviewBtn_3, overviewBtn_4, overviewBtn_5, overviewBtn_6,
            addBtn, removeBtn, changeBtn;
   private JButton button[];
   private NetflixPanel panel;
   private netflixView view;
   private Cards cards;
   
public controlPanel(netflixView view){
    
    this.view = view;
    cards = new Cards(view);
    
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    button = new JButton[6];
    button[0] = overviewBtn_1;
    button[1] =  overviewBtn_2;
    button[2] = overviewBtn_3;
    button[3] = overviewBtn_4;
    button[4] = overviewBtn_5;
    button[5] = overviewBtn_6;
    
    changeBtn = new JButton("C");
   changeBtn.addActionListener(new controlHandler()); 
     changeBtn.setBorderPainted(false);
     changeBtn.setContentAreaFilled(false);
     changeBtn.setOpaque(true);
     
    addBtn = new JButton ("+"); 
     addBtn.setBorderPainted(false);
     addBtn.setContentAreaFilled(false);
     addBtn.setOpaque(true);
    addBtn.addActionListener(new controlHandler()); 
    
          
     addBtn.setOpaque(true);
    removeBtn = new JButton ("- ");
    removeBtn.addActionListener(new controlHandler()); 
    removeBtn.setBorderPainted(false);
     removeBtn.setContentAreaFilled(false);
     removeBtn.setOpaque(true);
             
    
    
    add (Box.createRigidArea(new Dimension(0, 100)));
    
    
    
    for (int i= 0; i< 6; i++){
        
        button[i] = new JButton("Overzicht " + (i+1));
        button[i].addActionListener(new controlHandler()); 
        button[i].setBorderPainted(false);
        button[i].setContentAreaFilled(false);
        button[i].setOpaque(true);
        add (button[i]); }
 
    
    add (Box.createRigidArea(new Dimension(0, 100)));
    
    add (addBtn);
    
    add (removeBtn);
    add (changeBtn);
    
    }

public class controlHandler implements ActionListener {
    public void actionPerformed (ActionEvent e) {
        
       if (e.getSource() == button[0])  {
           cards.showCard1();
       
        }
       
       if (e.getSource() == button[1]) {
           cards.showCard2();
       }
       
       if (e.getSource() == button[2]) {
           cards.showCard3();
       }
       
       if (e.getSource() == button[3]) {
           cards.showCard4();
       }
       
       if (e.getSource() == button[4]) {
           cards.showCard5();
       }
       
       if (e.getSource() == button[5]){
           cards.showCard6();
       }
       
       if (e.getSource() == addBtn) {
           cards.showCard7();
           
       } 
       
       if (e.getSource() == changeBtn) {
           cards.showCard8();
       }
       
       if (e.getSource() == removeBtn) {
           cards.showCard9();
       }
  
        
    }

}
}

