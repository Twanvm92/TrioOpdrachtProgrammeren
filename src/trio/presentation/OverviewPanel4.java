/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import trio.transaction.TransactionResult4;
import trio.transaction.TransactionScript;
import trio.transaction.TransactionScript4;

/**
 *
 * @author lukab
 */
public class OverviewPanel4 extends JPanel{
    
    JLabel purposeLabel;
    TransactionScript4 script;
    JTextArea area;
    ArrayList<String> array;

    
    
    public OverviewPanel4(){
       
        setLayout( new BorderLayout(40,40));
       
     setBorder(BorderFactory.createEmptyBorder(50,50,50,50)); 
       area = new JTextArea();
       area.setFont(new Font("Monospaced", Font.PLAIN, 12));
       area.setLineWrap(true);
       
    

        script = new TransactionScript4();
        
        ArrayList array = script.query();
        
          
        
        for (Object result : array) {
            
            
           area.append(result.toString());
           area.append("\n");
           
        }
        

        
        purposeLabel = new JLabel("Films met langste tijdsduur voor kijkers onder de 16 jaar.");
        purposeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        
      
      
        
  
       setLayout(new BorderLayout(0, 10));
       add (purposeLabel, BorderLayout.NORTH);
    
        add (area, BorderLayout.CENTER);
        
        
       
        
         
         
         
        
        
      
        
       
}
        
    }

