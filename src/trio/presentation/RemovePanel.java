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

/**
 *
 * @author lukab
 */
public class RemovePanel extends JPanel {
     JComboBox<String> overviewCB;
     JComboBox<String> deleteCB;
     ArrayList<String> movieArray, profileArray, serieArray, accountArray; //dadelijk uit klasse movie
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
    deleteLbl.setFont(new Font("Papyrus", Font.BOLD, 14));
   
    

    movieArray = new ArrayList<String>();
    movieArray.add("Prisoners");
    movieArray.add("Harry Potter");
    movieArray.add("movie"); //later aanpassen
   
   
    profileArray = new ArrayList<String>();
    profileArray.add("Profile1");
    profileArray.add("Profile2");
    profileArray.add("Profile3");
    
    
    serieArray = new ArrayList<String>();
    serieArray.add("Breaking Bad");
    serieArray.add("Dexter");
    serieArray.add("Hannibal");
    

  
    accountArray = new ArrayList<String>();
    accountArray.add("Account1");
    accountArray.add("Account2");
    accountArray.add("Account3");
    
    model = new DefaultComboBoxModel( accountArray.toArray());
    model1 = new DefaultComboBoxModel ( profileArray.toArray());
    model2 = new DefaultComboBoxModel ( serieArray.toArray());
    model3 = new DefaultComboBoxModel ( movieArray.toArray());
    
    overviewCB = new JComboBox<String>();
    overviewCB.addActionListener(new selectHandler());
    overviewCB.addItem("Accounts");
    overviewCB.addItem("Profielen");
    overviewCB.addItem("Films");
    overviewCB.addItem("Series");

    
    add (deleteLbl);
     add (overviewCB);
     add (deleteCB);
    
  
    add (okButton);
   
}

    public class selectHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         
         if (overviewCB.getItemAt(overviewCB.getSelectedIndex()) == "Accounts") {
                deleteCB.setModel(model);
             }
         
           if (overviewCB.getItemAt(overviewCB.getSelectedIndex()) == "Films") {
                deleteCB.setModel(model3);
             }
           
             if (overviewCB.getItemAt(overviewCB.getSelectedIndex()) == "Series") {
                deleteCB.setModel(model2);
             }
             
               if (overviewCB.getItemAt(overviewCB.getSelectedIndex()) == "Profielen") {
                deleteCB.setModel(model1);
               }
               
                
             }
      }
    

    public class okHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            // verwijder db (" DELETE FROM MOVIES/SERIES/PROFILES(etc) WHERE name = (selectedItem)..
        }
    }
}
    
    
