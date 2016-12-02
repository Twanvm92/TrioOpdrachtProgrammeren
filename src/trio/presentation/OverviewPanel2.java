/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author lukab
 */
public class OverviewPanel2 extends JPanel{
   
    JLabel titleLabel1, purposeLabel, titleLabel2;
    JComboBox<String> myTitles, myAccounts;
    
    public OverviewPanel2() {
        setLayout( new BorderLayout(40,40));
       
     setBorder(BorderFactory.createEmptyBorder(50,50,50,50)); 
        myTitles = new JComboBox<String>();
        myAccounts = new JComboBox<String>();
      
        myTitles.addItem("House of Cards");
        myTitles.addItem("Breaking Bad");
        myTitles.addItem("Dexter");
        
        myAccounts.addItem("Account 1");
        myAccounts.addItem("Account 2");
        myAccounts.addItem("Account 3");
        
        titleLabel1 = new JLabel("Selecteer serie  ");
        titleLabel1.setFont(new Font("Arial", Font.PLAIN, 14));
        titleLabel2 = new JLabel("Selecteer account ");
        titleLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
        purposeLabel = new JLabel("Gemiddeld % bekeken per aflevering");
        purposeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JPanel overview2_North = new JPanel();
        overview2_North.add(titleLabel1);
        overview2_North.add(myTitles);
        overview2_North.add(titleLabel2);
        overview2_North.add(myAccounts);
        
        JPanel overview2_Center = new JPanel();
        overview2_Center.setLayout(new BorderLayout(0, 10));
        overview2_Center.add (purposeLabel, BorderLayout.NORTH);
        overview2_Center.add (new JTextArea(100, 100), BorderLayout.CENTER);
        add(overview2_North, BorderLayout.NORTH);
        add (overview2_Center, BorderLayout.CENTER);
}
    
}