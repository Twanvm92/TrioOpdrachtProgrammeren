/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;
import trio.transaction.TransactionScript;
import trio.transaction.TransactionScript4;

/**
 *
 * @author lukab
 */
public class OverviewPanel4 extends JPanel{
    
    JLabel purposeLabel;
    
    public OverviewPanel4(){
       
        setLayout( new BorderLayout(40,40));
       
     setBorder(BorderFactory.createEmptyBorder(50,50,50,50)); 
       
        

        purposeLabel = new JLabel("Films met langste tijdsduur voor kijkers onder de 16 jaar.");
        purposeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        
      
      
        
  
       setLayout(new BorderLayout(0, 10));
       add (purposeLabel, BorderLayout.NORTH);
        add (new JTextArea(100, 100), BorderLayout.CENTER);
        
         TransactionScript t = new TransactionScript4();
                t.query();
       
}
        
    }

