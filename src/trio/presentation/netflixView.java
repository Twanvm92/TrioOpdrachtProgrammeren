/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;

import java.awt.*;
import java.awt.event.ItemEvent;
import javax.swing.*;
import trio.domain.Cards;
import trio.domain.Program;

/**
 *
 * @author lukab
 */
public class netflixView extends JPanel {
    JPanel overview1, overview2, overview3, overview4, overview5, overview6;
    Cards card;
    CardLayout cl;
            
    public netflixView() {
        
   
        cl = new CardLayout();
         setLayout(cl);
         
        overview1 = new JPanel( new BorderLayout());
       
        JComboBox<String> myTitles = new JComboBox<String>();
        
        JPanel overview1_North = new JPanel();
        overview1_North.setBackground(Color.red);
        overview1_North.add(new JLabel("Selecteer serie"));
        overview1_North.add(myTitles);
        JPanel overview1_Center = new JPanel();
        overview1_Center.setLayout(new BoxLayout(overview1_Center, BoxLayout.PAGE_AXIS));
        overview1_Center.add (new JLabel("Gemiddeld % bekeken per aflevering"));
        overview1_Center.add (new JTextArea(100, 100));
        overview1.add(overview1_North, BorderLayout.NORTH);
        overview1.add (overview1_Center, BorderLayout.CENTER);
        overview1.setBackground(Color.red);


        
        overview2 = new JPanel();
        overview2.setBackground(Color.blue);
        
        overview3 = new JPanel();
        overview3.setBackground(Color.yellow);
        
         overview4 = new JPanel();
        overview4.setBackground(Color.CYAN);
        
         overview5= new JPanel();
        overview5.setBackground(Color.green);
        
         overview6 = new JPanel();
        overview6.setBackground(Color.white);
        
        
        
        
        add (overview1, "CARD1");
        add (overview2, "CARD2");
        add (overview3, "CARD3");  
        add (overview4, "CARD4");
        add (overview5, "CARD5");
        add (overview6, "CARD6");
      
        
       
    }
    

    
    }

