/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import trio.domain.*;
import trio.transaction.TransactionResultComboxAbonnementNr;
import trio.transaction.TransactionResultComboxProfiel;
import trio.transaction.TransactionScriptDelete;
import trio.transaction.TransactionScript;
import trio.transaction.*;

/**
 *
 * @author lukab
 */
public class RemovePanel extends JPanel {
     JComboBox<String> overviewCB;
     JComboBox<String> deleteCB;
     ArrayList<String> abonnemetnArray, profileArray, kijkArray; //dadelijk uit klasse movie
     JButton okButton;
     JList movieList, serieList, profileList, accountList;
     DefaultComboBoxModel model, model1, model2, model3;
     JLabel deleteLbl;
    
     
     
public RemovePanel(){
    
    
    setLayout (new GridLayout (20, 1));
    
    okButton = new JButton ("OK");
    okButton.addActionListener(new okHandler());

    deleteCB = new JComboBox<String>();
    deleteLbl = new JLabel ("Verwijder geselecteerd object");
    deleteLbl.setFont(new Font("SansSerif", Font.BOLD, 14));
   
    

    abonnemetnArray = new ArrayList<String>(); //fill the array with all the subscribtion names in the database
    ArrayList<TransactionResultComboxAbonnementNr> abList = new ArrayList<TransactionResultComboxAbonnementNr>();
    TransactionScriptComboxAbonnementNr ab = new TransactionScriptComboxAbonnementNr(RemovePanel.this);
    abList = ab.query();
    for(TransactionResultComboxAbonnementNr r : abList){
        abonnemetnArray.add(r.getNaam());
    }
   
    profileArray = new ArrayList<String>(); // fills the array  with all the profilesnames in the database
    ArrayList<TransactionResultComboxProfiel> proList = new ArrayList<TransactionResultComboxProfiel>();
    TransactionScriptComboxProfielNaam pro = new TransactionScriptComboxProfielNaam(RemovePanel.this);
    proList = pro.query();
    for (TransactionResultComboxProfiel r : proList){
        profileArray.add(r.getNaam());
    }
    
    
    kijkArray = new ArrayList<String>();// fills the watch array with all the program id's in the watch table
    ArrayList<TransactionResultProgramID> kijkList = new ArrayList<TransactionResultProgramID>();
    TransactionScriptComboxProgramID kijk = new TransactionScriptComboxProgramID(RemovePanel.this);
    kijkList = kijk.query();
    for(TransactionResultProgramID r : kijkList){
        kijkArray.add(r.getNaam());
    }
    
    
    // fills the comment boxes with the appropriate array
    model = new DefaultComboBoxModel( abonnemetnArray.toArray());
    model1 = new DefaultComboBoxModel ( profileArray.toArray());
    model2 = new DefaultComboBoxModel ( kijkArray.toArray());
    
    
    
    overviewCB = new JComboBox<String>();
    overviewCB.addActionListener(new selectHandler());
    overviewCB.addItem("abonnement");
    overviewCB.addItem("profiel");
    overviewCB.addItem("kijkgedrag");
  

    
    add (deleteLbl);
    add (overviewCB);
    add (deleteCB);
    
  
    add (okButton);
   
}
    // sets the lower comment box based on the content of the upper comment box
    public class selectHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         
         if (overviewCB.getItemAt(overviewCB.getSelectedIndex()) == "abonnement") {
                deleteCB.setModel(model);
                
             }
         
           if (overviewCB.getItemAt(overviewCB.getSelectedIndex()) == "profiel") {
                deleteCB.setModel(model1);
               
             }
           
             if (overviewCB.getItemAt(overviewCB.getSelectedIndex()) == "kijkgedrag") {
                deleteCB.setModel(model2);
                 
             }
             
              
               
                
             }
      }
    
    // executes the right query bases on the content of the lower commment box
    public class okHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            TransactionScriptDelete delete = new TransactionScriptDelete(RemovePanel.this);
            
            if (overviewCB.getItemAt(overviewCB.getSelectedIndex()) == "abonnement") {
                delete.deleteSub("" + deleteCB.getSelectedItem());
                JOptionPane.showMessageDialog(RemovePanel.this, "abonnement data succesvol verwijderd", "", JOptionPane.PLAIN_MESSAGE);
                
             }
         
           if (overviewCB.getItemAt(overviewCB.getSelectedIndex()) == "profiel") {
                 
               delete.deleteProfiel("" + deleteCB.getSelectedItem());
               JOptionPane.showMessageDialog(RemovePanel.this, "profiel data succesvol verwijderd", "", JOptionPane.ERROR_MESSAGE);
             }
           
             if (overviewCB.getItemAt(overviewCB.getSelectedIndex()) == "kijkgedrag") {
                 
                 delete.deleteKijk("" + deleteCB.getSelectedItem());
                 JOptionPane.showMessageDialog(RemovePanel.this, "kijkgedrag data succesvol verwijderd", "", JOptionPane.ERROR_MESSAGE);
             }
        }
    }
}
    
    
