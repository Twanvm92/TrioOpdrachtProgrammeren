/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trio.transaction.TransactionResultAbonnementAll;
import trio.transaction.TransactionResultComboxAbonnementNr;
import trio.transaction.TransactionResultComboxProfiel;
import trio.transaction.TransactionResultComboxProgrTitel;
import trio.transaction.TransactionScriptAbonnementAll;
import trio.transaction.TransactionScriptChange;
import trio.transaction.TransactionScriptComboxAbonnementNr;
import trio.transaction.TransactionScriptComboxProfiel;
import trio.transaction.TransactionScriptAbonnementAll;
import trio.transaction.TransactionScriptCombxProgrTitel2;



/**
 * The user can change accounts, profile and
 * viewinghabits by using <code> ChangePanel </code>
 * @see NetflixView
 * @author Lukab
 * @see ControlPanel
 */
public class ChangePanel extends JPanel {
    JTextField birthdateField, fkaccountNrField,pkaccountNrField, accountNameField, accountStreetField, 
            townField, houseNrField, postalcodeField, viewingHabitsField;
    JLabel profileNameLbl, birthdateLbl, fkaccountNrLbl, pkaccountNrLbl, accountNameLbl, accountStreetLbl, townLbl, houseNrLbl,
            postalcodeLbl, programIdLbl, viewingHabitsLbl, viewinghabits, accounts, profiles;
    JButton changeProfileBtn, changeAccountBtn, changeViewingHabitsBtn;
    JComboBox programIdCB, profileNameCB, fkaccountNrCB, profileName1CB, pkaccountNrCB, programTitleCB, viewingHabitsAccountNrCB;
      private TransactionScriptComboxAbonnementNr script;
      private TransactionScriptComboxProfiel scriptprofiel;
      private TransactionScriptAbonnementAll all;
      private TransactionScriptCombxProgrTitel2 scriptProgram;
      
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
    programIdLbl = new JLabel ("Programma ID"); 
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
  
    scriptprofiel = new TransactionScriptComboxProfiel(fkaccountNrCB.getSelectedItem().toString(), ChangePanel.this);
    ArrayList<TransactionResultComboxProfiel> resultArrayProfiel = scriptprofiel.query();
    List<String> valuesProfiel = new ArrayList();
    
    for (int x = 0; x < resultArrayProfiel.size();x++) {
        TransactionResultComboxProfiel result = resultArrayProfiel.get(x);
        valuesProfiel.add(result.getNaam());
    }
    
   
    
    programTitleCB = new JComboBox();
    viewingHabitsAccountNrCB = new JComboBox();
    profileName1CB.setModel(new DefaultComboBoxModel (valuesProfiel.toArray()));
    profileNameCB.setModel(new DefaultComboBoxModel (valuesProfiel.toArray()));
    viewingHabitsAccountNrCB.setModel(new DefaultComboBoxModel (values.toArray()));
    pkaccountNrCB.setModel(new DefaultComboBoxModel (values.toArray()));
    
    
     
    
    fkaccountNrCB.addItemListener(new ChangePanel.ComboboxItemChangeListener());
    pkaccountNrCB.addItemListener(new ChangePanel.ComboboxItemChangeListener());
    viewingHabitsAccountNrCB.addItemListener(new ChangePanel.ComboboxItemChangeListener());
    changeAccountBtn.addActionListener(new ChangePanel.ButtonHandler());
    changeProfileBtn.addActionListener(new ChangePanel.ButtonHandler());
    changeViewingHabitsBtn.addActionListener(new ChangePanel.ButtonHandler());
    profileNameCB.addItemListener(new ChangePanel.ComboboxItemChangeListener());
    
    
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
     add (new JLabel ("Abonnement nummer"));
     add (viewingHabitsAccountNrCB);
     add (new JLabel ("Programma titel"));
     add (programTitleCB);
     add (viewingHabitsLbl);
     add (viewingHabitsField);
     add (changeViewingHabitsBtn);
}

   
    
     class ButtonHandler implements ActionListener { // listens to actions that have been performed
        @Override
        public void actionPerformed(ActionEvent e) {
           TransactionScriptChange changeScript = new TransactionScriptChange(ChangePanel.this); // instantiate the script that performs the queries
           
            // listen to what button gets clicked
            if ( e.getSource() == changeProfileBtn ) {
                
                // get strings from textfields and comboboxes
                String profielNaam = profileName1CB.getSelectedItem().toString();
                String geboortedatum = birthdateField.getText();
                String abonnementNr = fkaccountNrCB.getSelectedItem().toString();
                
                changeScript.qeuryChangeProfiel(abonnementNr, profielNaam, geboortedatum); // execute query
                
                birthdateField.setText("");
            }
            
            if (e.getSource() == changeAccountBtn ) {
               
                
                String accountNr = pkaccountNrCB.getSelectedItem().toString();
                String street = accountStreetField.getText();
                String name = accountNameField.getText();
                String houseNumber = houseNrField.getText();
                String town = townField.getText();
                String postalcode = postalcodeField.getText();
                
                changeScript.qeuryChangeAbonnement(accountNr, name, street, postalcode, houseNumber, town);
            }
            
            
            if (e.getSource() == changeViewingHabitsBtn) {
                
                String accountNr = viewingHabitsAccountNrCB.getSelectedItem().toString();
                String programTitle = programTitleCB.getSelectedItem().toString();
                String percentage = viewingHabitsField.getText();
                String profileName = profileNameCB.getSelectedItem().toString();
                
                changeScript.qeuryChangeWatch(accountNr, profileName, programTitle, percentage);
            }
            
            
        }

    }
     
      
      
      class ComboboxItemChangeListener implements ItemListener{
        /**
         * Listens if an item in the combobox  gets selected
         * @param event event that fires after an item in the combobox
         * changed.
         */
        @Override
        public void itemStateChanged(ItemEvent event) {
           if (event.getStateChange() == ItemEvent.SELECTED) {
               
               if ( event.getSource() == pkaccountNrCB) {
               
               // Make new script and fire querie again for new results and make a list
                TransactionScriptAbonnementAll script = new TransactionScriptAbonnementAll(ChangePanel.this, pkaccountNrCB.getSelectedItem().toString());
                ArrayList<TransactionResultAbonnementAll> list = script.query();
                TransactionResultAbonnementAll all = list.get(0);

                accountNameField.setText( all.getNaam());
                accountStreetField.setText( all.getStraat());
                townField.setText( all.getWoonplaats());
                houseNrField.setText("" + all.getHuisnummer());
                postalcodeField.setText( all.getPostcode());
                System.out.println(all.getNaam());
                
                
               }
               
               if (event.getSource() == fkaccountNrCB) {
                    
             // Make new script and fire querie again for new results and make a list
                TransactionScriptComboxProfiel script = new TransactionScriptComboxProfiel(fkaccountNrCB.getSelectedItem().toString(), ChangePanel.this);
                ArrayList<TransactionResultComboxProfiel> resultArray = script.query();
                List<String> values = new ArrayList();
                
                // add results from resultArray to a list
                for (int x = 0; x < resultArray.size();x++) {
                    TransactionResultComboxProfiel result = resultArray.get(x);
                    values.add(result.getNaam());
                }
                
                
                //  add new model with results to the combobox
                profileName1CB.setModel(new DefaultComboBoxModel(values.toArray()));
           }
        
               if (event.getSource() == viewingHabitsAccountNrCB) {
               
             TransactionScriptComboxProfiel script = new TransactionScriptComboxProfiel(viewingHabitsAccountNrCB.getSelectedItem().toString(), ChangePanel.this);
                ArrayList<TransactionResultComboxProfiel> resultArray = script.query();
                List<String> values = new ArrayList();
                
                // add results from resultArray to a list
                for (int x = 0; x < resultArray.size();x++) {
                    TransactionResultComboxProfiel result = resultArray.get(x);
                    values.add(result.getNaam());
                }
                
                
                //  add new model with results to the combobox
                profileNameCB.setModel(new DefaultComboBoxModel(values.toArray()));
                
               }
               
               if (event.getSource() == profileNameCB) {
               
               // Make new script and fire querie again for new results and make a list
               TransactionScriptCombxProgrTitel2 script = new TransactionScriptCombxProgrTitel2 (profileNameCB.getSelectedItem().toString(), ChangePanel.this);
                ArrayList<TransactionResultComboxProgrTitel> resultArray = script.query();
                List<String> values = new ArrayList();
                
                // add results from resultArray to a list
                for (int x = 0; x < resultArray.size();x++) {
                    TransactionResultComboxProgrTitel result = resultArray.get(x);
                    values.add(result.getProgramme());
                }
                
                
                //  add new model with results to the combobox
                    programTitleCB.setModel(new DefaultComboBoxModel(values.toArray()));
                
               }
          
           }
        }       
    }

      
      }
