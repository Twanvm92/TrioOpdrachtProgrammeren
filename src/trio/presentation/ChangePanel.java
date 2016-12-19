/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;

import trio.transaction.TransactionResultComboxProfileNames;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trio.transaction.TransactionResultComboxAbonnementNr;
import trio.transaction.TransactionScriptChange;
import trio.transaction.TransactionScriptComboxAbonnementNr;

/**
 *
 * @author lukab
 */
public class ChangePanel extends JPanel {
    JTextField birthdateField, fkaccountNrField,pkaccountNrField, accountNameField, accountStreetField, 
            townField, houseNrField, postalcodeField, viewingHabitsField;
    JLabel profileNameLbl, birthdateLbl, fkaccountNrLbl, pkaccountNrLbl, accountNameLbl, accountStreetLbl, townLbl, houseNrLbl,
            postalcodeLbl, programIdLbl, viewingHabitsLbl, viewinghabits, accounts, profiles;
    JButton changeProfileBtn, changeAccountBtn, changeViewingHabitsBtn;
    JComboBox programIdCB, profileNameCB, fkaccountNrCB, profileName1CB, pkaccountNrCB;
      private TransactionScriptComboxAbonnementNr script;
    private DefaultComboBoxModel accountNrModel;
    
public ChangePanel(){
    
    setLayout (new GridLayout (20, 2));
    
   viewinghabits = new JLabel ("Kijkgedrag");
    viewinghabits.setFont(new Font("Papyrus", Font.BOLD, 14));
    accounts = new JLabel ("Abonnementen");
    accounts.setFont(new Font("Papyrus", Font.BOLD, 14));
    profiles = new JLabel ("Profielen");
    profiles.setFont(new Font("Papyrus", Font.BOLD, 14));
    
    profileNameLbl = new JLabel ("Profielnaam: ");
    birthdateLbl = new JLabel ("Geboortedatum: ");
    fkaccountNrLbl = new JLabel ("Abonneenummer: ");
    
    pkaccountNrLbl = new JLabel ("Abonneenummer: ");
    accountNameLbl = new JLabel ("Abonnee naam: ");
    accountStreetLbl = new JLabel ("Straat: ");
    townLbl = new JLabel ("Plaats: ");
    houseNrLbl = new JLabel ("Huisnummer: ");
    postalcodeLbl = new JLabel ("Postcode: ");
    
    viewingHabitsLbl = new JLabel ("Percentage ");
    viewingHabitsField = new JTextField (20);
    
    profileName1CB = new JComboBox();
    profileNameCB = new JComboBox();
    fkaccountNrCB = new JComboBox();
    pkaccountNrCB = new JComboBox();
    programIdLbl = new JLabel ("Programma ID"); //Combobox met programma's?'
    programIdCB = new JComboBox();
    
  
    birthdateField = new JTextField (20);

    
    accountNameField = new JTextField (20);
    accountStreetField = new JTextField (20);
    townField = new JTextField (20);
    houseNrField = new JTextField (20);
    postalcodeField = new JTextField (20);
    
    changeProfileBtn = new JButton ("Verander profiel");
    changeAccountBtn = new JButton ("Verander account");
    changeViewingHabitsBtn = new JButton ("Verander kijkgedrag");
    
    //declare and initialize new Transitionscript
    // put results of the query() method in an arraylist.
    script = new TransactionScriptComboxAbonnementNr(ChangePanel.this);
    ArrayList<TransactionResultComboxAbonnementNr> resultArray = script.query();
    List<String> values = new ArrayList();

    // create a combobox that will be used to hold accountnumbers
    fkaccountNrCB = new JComboBox();

    // add results from resultArray to a list
    for (int x = 0; x < resultArray.size();x++) {
        TransactionResultComboxAbonnementNr result = resultArray.get(x);
        values.add(result.getNaam());
    }
    
    //  add new model with results to the combobox
    fkaccountNrCB.setModel(new DefaultComboBoxModel(values.toArray()));
  ;
  
    script1 = new TransactionScriptComboxProfileNames(ChangePanel.this);
    ArrayList<TransactionResultComboxProfileNames> resultArray1 = script.query();
    List<String> values = new ArrayList();

    profileName1CB.setModel(new DefaultComboBoxModel (values.toArray()));
    changeAccountBtn.addActionListener(new ChangePanel.ButtonHandler());
    changeProfileBtn.addActionListener(new ChangePanel.ButtonHandler());
    
    add (profiles);
    add (new JLabel ("")); 
    add (profileNameLbl);
    add (profileName1CB);
    add (birthdateLbl);
    add (birthdateField);
    add (fkaccountNrLbl);
    add (fkaccountNrCB);
     add (changeProfileBtn);
      add (new JLabel (""));
      
     add (accounts);
     add (new JLabel (""));
     add (pkaccountNrLbl);
     add (pkaccountNrCB);
     add (accountNameLbl);
     add (accountNameField);
     add (accountStreetLbl);
     add (accountStreetField);
     add (townLbl);
     add (townField);
     add (houseNrLbl);
     add (houseNrField);
     add (postalcodeLbl);
     add (postalcodeField);
     add (changeAccountBtn);
       add (new JLabel (""));
     
     add (viewinghabits);
     add (new JLabel(""));
     add (new JLabel ("Profiel naam"));
     add (profileNameCB);
     add (new JLabel ("Programma ID: "));
     add (programIdCB);
     add (viewingHabitsLbl);
     add (viewingHabitsField);
     add (changeViewingHabitsBtn);
}
    
     class ButtonHandler implements ActionListener { // listens to actions that have been performed
        @Override
        public void actionPerformed(ActionEvent e) {
           TransactionScriptChange addScript = new TransactionScriptChange(ChangePanel.this); // instantiate the script that performs the queries
           
            // listen to what button gets clicked
            if ( e.getSource() == changeProfileBtn ) {
                
                // get strings from textfields and comboboxes
                String profielNaam = profileNameCB.getSelectedItem().toString();
                String geboortedatum = birthdateField.getText();
                String abonnementNr = fkaccountNrCB.getSelectedItem().toString();
                
                addScript.qeuryChangeProfiel(abonnementNr, profielNaam, geboortedatum); // execute query
                
                birthdateField.setText("");
            }
            
            
        }

    }
}
