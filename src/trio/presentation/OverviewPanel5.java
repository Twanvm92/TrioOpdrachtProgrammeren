/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;
/**
 *
 * @author lukab
 */
public class OverviewPanel5 extends JPanel{
    JLabel purposeLabel;
    
    public OverviewPanel5(){
       
        setLayout( new BorderLayout(40,40));
       
     setBorder(BorderFactory.createEmptyBorder(50,50,50,50)); 
       
        

        purposeLabel = new JLabel("Accounts met slechts 1 profiel.");
        purposeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        
        
         setLayout(new BorderLayout(0, 10));
       add (purposeLabel, BorderLayout.NORTH);
        add (new JTextArea(100, 100), BorderLayout.CENTER);
        
    }
}
