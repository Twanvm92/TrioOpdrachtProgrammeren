/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;

import java.awt.*;
import java.awt.event.ItemEvent;
import javax.swing.*;
import trio.domain.Program;

/**
 *
 * @author lukab
 */
public class netflixView extends JPanel {
    controlPanel panel;
    Program program;
    JPanel overview1, overview2, overview3, overview4, overview5, overview6;
    final String CARD1 = "CARD1";
    final String CARD2 = "CARD2";
    final String CARD3 = "CARD3";
    CardLayout cl;
            
    public netflixView() {
        
        cl = new CardLayout();
     
         setLayout(cl);
        overview1 = new JPanel();
        overview1.setBackground(Color.red);
        
        overview2 = new JPanel();
        overview2.setBackground(Color.blue);
        
        overview3 = new JPanel();
        overview3.setBackground(Color.yellow);
        
        add (overview1, CARD1);
        add (overview2, CARD2);
        add (overview3, CARD3);  
        
       
    }
    
    public void showCard1(){
        
        cl.show(this, CARD1);
    }
        
   public void showCard2(){
       
       cl.show(this, CARD2);
   }
   
   public void showCard3(){
       
       cl.show(this, CARD3);
   }
   
   
     public void Next(){
       
       cl.next(this);
   }
    }

