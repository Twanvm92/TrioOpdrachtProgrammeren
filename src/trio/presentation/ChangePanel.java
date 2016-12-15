/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author lukab
 */
public class ChangePanel extends JPanel {
     JComboBox<String> overviewCB;
     JComboBox<String> deleteCB;
     ArrayList<String> movieArray, profileArray, serieArray, accountArray; //dadelijk uit klasse movie
     JButton okButton;
     JList movieList, serieList, profileList, accountList;
     DefaultComboBoxModel model, model1, model2, model3;
    
     
     
public ChangePanel(){
    
    okButton = new JButton ("OK");
    //okButton.addActionListener(new okHandler());

    overviewCB = new JComboBox<String>();
    overviewCB.addActionListener(new selectHandler());
    overviewCB.addItem("Accounts");
    overviewCB.addItem("Profielen");
    overviewCB.addItem("Films");
    overviewCB.addItem("Series");
    
    deleteCB = new JComboBox<String>();

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

    
    add (overviewCB);
    add (deleteCB);
    add (okButton);
   
}

    public class selectHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         
        
           if (overviewCB.getItemAt(overviewCB.getSelectedIndex()) == "Films") {
                deleteCB.setModel(model3);
             }
           
             if (overviewCB.getItemAt(overviewCB.getSelectedIndex()) == "Series") {
                deleteCB.setModel(model2);
             }
             
               if (overviewCB.getItemAt(overviewCB.getSelectedIndex()) == "Profielen") {
                deleteCB.setModel(model1);
                
                 if (overviewCB.getItemAt(overviewCB.getSelectedIndex()) == "Accounts") {
                deleteCB.setModel(model);
             }
             }
      }
    }
}
