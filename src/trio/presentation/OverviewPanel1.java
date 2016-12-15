/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import trio.transaction.TransactionResultComboxOverview1;
import trio.transaction.TransactionScriptComboxOverview1;

/**
 *
 * @author lukab
 */
public class OverviewPanel1 extends JPanel {
    JComboBox<String> myTitles ;
    JLabel titleLabel, purposeLabel;

            
    
    public OverviewPanel1(){
        
        // declare and initialize new Transitionscript
        // put results of the query() method in an arraylist.
        TransactionScriptComboxOverview1 script = new TransactionScriptComboxOverview1(OverviewPanel1.this);
        ArrayList<TransactionResultComboxOverview1> resultArray = script.query();
    
        setLayout( new BorderLayout(40,40));
       
        setBorder(BorderFactory.createEmptyBorder(50,50,50,50)); 
        myTitles = new JComboBox<String>();
        
        // add results from resultArray to JCombobox
        for (int x = 0; x < resultArray.size(); x++ ) {
            TransactionResultComboxOverview1 result = resultArray.get(x);
            myTitles.addItem(result.getTitel());
        }
        
        titleLabel = new JLabel("Selecteer serie  ");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        purposeLabel = new JLabel("Gemiddeld % bekeken per aflevering");
        purposeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JPanel overview1_North = new JPanel();
        overview1_North.add(titleLabel);
        overview1_North.add(myTitles);
        
        JPanel overview1_Center = new JPanel();
        overview1_Center.setLayout(new BorderLayout(0, 10));
        overview1_Center.add (purposeLabel, BorderLayout.NORTH);
        overview1_Center.add (new JTextArea(100, 100), BorderLayout.CENTER);
        add(overview1_North, BorderLayout.NORTH);
        add (overview1_Center, BorderLayout.CENTER);
}
    
   
   public class selectHandler implements ActionListener { // listens to actions that have been performed
       @Override
       public void actionPerformed(ActionEvent e) {
           if (myTitles.getItemAt(myTitles.getSelectedIndex()) == "House of Cards") {
                
                
                
             }
       }
   }
    
}
