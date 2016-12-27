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

/**
 * The <code> NetfilxView </code> is a panel that the user exactly sees. The layout
 * change by use of the <code> ControlPanel </code>
 * @see ControlPanel
 * @author Lukab
 * @see Cards
 */
public class NetfilxView extends JPanel {
    OverviewPanel1 overview1; 
    OverviewPanel2 overview2;
    OverviewPanel3 overview3;
    OverviewPanel4 overview4;
    OverviewPanel5 overview5;
    OverviewPanel6 overview6;
    AddPanel overview7;
    ChangePanel overview8;
    RemovePanel overview9;
    Cards card;
    CardLayout cl;
            
    public NetfilxView() {
        
   
        cl = new CardLayout();
        setLayout(cl);
        
        //initialize the OverviewPanels
         
        overview1 = new OverviewPanel1();
       
        
        overview2 = new OverviewPanel2();

        
        overview3 = new OverviewPanel3();

        
         overview4 = new OverviewPanel4();
       
        
         overview5= new OverviewPanel5();
    
        
         overview6 = new OverviewPanel6();
         
         overview7 = new AddPanel();
         overview8 = new ChangePanel();
         overview9 = new RemovePanel();
     
        
        
        
        // adds the overviewPanels on the Panel with a special name
        add (overview1, "CARD1");
        add (overview2, "CARD2");
        add (overview3, "CARD3");  
        add (overview4, "CARD4");
        add (overview5, "CARD5");
        add (overview6, "CARD6");
        add (overview7, "CARD7");
        add (overview8, "CARD8");
        add (overview9, "CARD9");
                
      
        
       
    }
    

    
    }

