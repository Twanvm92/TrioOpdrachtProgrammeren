/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import trio.transaction.TransactionScript;
import trio.transaction.TransactionScript3;
import trio.transaction.TransactionResult5;
import trio.transaction.TransactionScript5;

/**
 * One of the OverviewPanels. <code> OverviewPanel5 </code> Show the fifth overview of the application 
 * @see TransactionResult5
 * @author Lukab
 * @see TransactionScript5
 */
public class OverviewPanel5 extends JPanel{
    JLabel purposeLabel;
    TransactionScript5 script;
    JTextArea area;
    
    public OverviewPanel5(){
       
        
        setLayout( new BorderLayout(40,40));
       
     setBorder(BorderFactory.createEmptyBorder(50,50,50,50)); 
          area = new JTextArea();
       area.setFont(new Font("Monospaced", Font.PLAIN, 12));
       area.setLineWrap(true);
     
       
       // declare and initialize new Transitionscript
        // put results of the query() method in an arraylist.
       script = new TransactionScript5();
        
        ArrayList array = script.query();
        
          
        
        for (Object result : array) {
            
            
           area.append(result.toString());
           area.append("\n");
           
        }
        purposeLabel = new JLabel("Accounts met slechts 1 profiel.");
        purposeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        
        
        
         setLayout(new BorderLayout(0, 10));
       add (purposeLabel, BorderLayout.NORTH);
        add (area);
        
       

    }
    
    
}
