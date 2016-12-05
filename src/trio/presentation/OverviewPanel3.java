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
public class OverviewPanel3 extends JPanel {
    
    JComboBox<String> myAccounts;
    JLabel titleLabel, purposeLabel;
    
    public OverviewPanel3(){
    
     setLayout( new BorderLayout(40,40));
       
     setBorder(BorderFactory.createEmptyBorder(50,50,50,50)); 
        myAccounts = new JComboBox<String>();
      
        myAccounts.addItem("Account1");
        myAccounts.addItem("Account2");
        myAccounts.addItem("Account3");
        
        titleLabel = new JLabel("Selecteer account ");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        purposeLabel = new JLabel("Bekeken films door geselecteerd account"); // account naam toevoegen??
        purposeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JPanel overview1_North = new JPanel();
        overview1_North.add(titleLabel);
        overview1_North.add(myAccounts);
        
        JPanel overview1_Center = new JPanel();
        overview1_Center.setLayout(new BorderLayout(0, 10));
        overview1_Center.add (purposeLabel, BorderLayout.NORTH);
        overview1_Center.add (new JTextArea(100, 100), BorderLayout.CENTER);
        add(overview1_North, BorderLayout.NORTH);
        add (overview1_Center, BorderLayout.CENTER);
}

}