/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import trio.transaction.TransactionResult3;
import trio.transaction.TransactionScript;
import trio.transaction.TransactionScript3;
/**
 *
 * @author lukab
 */
public class OverviewPanel3 extends JPanel {
    
    JComboBox<String> myAccounts;
    JLabel titleLabel, purposeLabel;
    JTextArea text;
    
    public OverviewPanel3(){
    
     setLayout( new BorderLayout(40,40));
       
     setBorder(BorderFactory.createEmptyBorder(50,50,50,50)); 
        myAccounts = new JComboBox<String>();
      
        myAccounts.addItem("F. de Kat");
        myAccounts.addItem("Account2");
        myAccounts.addItem("Account3");
        myAccounts.addActionListener(new action());
        
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
        text = new JTextArea(100, 100);
        overview1_Center.add (text);
        add(overview1_North, BorderLayout.NORTH);
        add (overview1_Center, BorderLayout.CENTER);
        
        
}
    class action implements ActionListener{
            public void actionPerformed(ActionEvent e){

                String s = ""; 
                TransactionScript t = new TransactionScript3("" + myAccounts.getSelectedItem(), OverviewPanel3.this);
                ArrayList<TransactionResult3> list = new ArrayList<TransactionResult3>();
                list = t.query();
                
                for(TransactionResult3 r : list){
                    s += r.toString() + " \n";
                     
                }
                
                text.setText(s);
                
                
                 
                 
                
                
                

            }
        } 
}