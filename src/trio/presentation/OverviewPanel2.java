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
import trio.transaction.TransactionResult2;
import trio.transaction.TransactionResult3;
import trio.transaction.TransactionResultComboxAbonnement;
import trio.transaction.TransactionResultComboxSerie;
import trio.transaction.TransactionScript;
import trio.transaction.TransactionScript2;
import trio.transaction.TransactionScript3;
import trio.transaction.TransactionScriptComboxAbonnement;
import trio.transaction.TransactionScriptComboxSerie;

/**
 *
 * @author lukab
 */
public class OverviewPanel2 extends JPanel{
   
    JLabel titleLabel1, purposeLabel, titleLabel2;
    JComboBox<String> myTitles, myAccounts;
    JTextArea text;
    
    public OverviewPanel2() {
        setLayout( new BorderLayout(40,40));
       
        setBorder(BorderFactory.createEmptyBorder(50,50,50,50)); 
     
        // declare and initialize new Transitionscript
        // put results of the query() method in an arraylist.
        TransactionScriptComboxSerie script = new TransactionScriptComboxSerie(OverviewPanel2.this);
        ArrayList<TransactionResultComboxSerie> resultArray = script.query();
        
        myTitles = new JComboBox<String>();
        
        // add results from resultArray to JCombobox
        for (int x = 0; x < resultArray.size();x++) {
            TransactionResultComboxSerie result = resultArray.get(x);
            myTitles.addItem(result.getTitel());
        }
        
        // declare and initialize new Transitionscript
        // put results of the query() method in an arraylist.
        TransactionScriptComboxAbonnement script2 = new TransactionScriptComboxAbonnement(OverviewPanel2.this);
        ArrayList<TransactionResultComboxAbonnement> resultArray2 = script2.query();
        
        myAccounts = new JComboBox<String>();
        
        // add results from resultArray to JCombobox
        for (int x = 0; x < resultArray2.size();x++) {
            TransactionResultComboxAbonnement result = resultArray2.get(x);
            myAccounts.addItem(result.getNaam());
        }
        
        titleLabel1 = new JLabel("Selecteer serie  ");
        titleLabel1.setFont(new Font("Arial", Font.PLAIN, 14));
        titleLabel2 = new JLabel("Selecteer account ");
        titleLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
        purposeLabel = new JLabel("Gemiddeld % bekeken per aflevering");
        purposeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        
        myTitles.addActionListener(new action());
        myAccounts.addActionListener(new action());
        
        JPanel overview2_North = new JPanel();
        overview2_North.add(titleLabel1);
        overview2_North.add(myTitles);
        overview2_North.add(titleLabel2);
        overview2_North.add(myAccounts);
        
        JPanel overview2_Center = new JPanel();
        overview2_Center.setLayout(new BorderLayout(0, 10));
        overview2_Center.add (purposeLabel, BorderLayout.NORTH);
        text = new JTextArea(100, 100);
        overview2_Center.add (text);
        add(overview2_North, BorderLayout.NORTH);
        add (overview2_Center, BorderLayout.CENTER);
}
    class action implements ActionListener{
            public void actionPerformed(ActionEvent e){

                String s = ""; 
                TransactionScript t = new TransactionScript2("" + myAccounts.getSelectedItem(), "" + myTitles.getSelectedItem(), OverviewPanel2.this);
                ArrayList<TransactionResult2> list = new ArrayList<TransactionResult2>();
                list = t.query();
                
                for(TransactionResult2 r : list){
                    s += r.toString() + " \n";
                    
                }
                
                text.setText(s);
               
                
               
                 
                 
                
                
               
                
                
                 
                 
                
                
                

            }
        } 
}