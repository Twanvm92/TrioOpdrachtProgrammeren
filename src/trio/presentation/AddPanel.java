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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import trio.transaction.*;

/**
 * The user can add accounts, profile and
 * viewinghabits by using <code>AddPanel</code>
 * @see NetflixView
 * @author Lukab, mikakrooswijk
 * @see ControlPanel
 */
public class AddPanel extends JPanel{
    JTextField profileNameField, birthdateField, fkaccountNrField,pkaccountNrField, accountNameField, accountStreetField, 
            townField, houseNrField, postalcodeField, viewingHabitsField;
    JLabel profileNameLbl, birthdateLbl, fkaccountNrLbl, pkaccountNrLbl, accountNameLbl, accountStreetLbl, townLbl, houseNrLbl,
            postalcodeLbl, programIdLbl, viewingHabitsLbl, viewinghabits, accounts, profiles, kijkgedragAccountNrLbl;
    JButton addProfileBtn, addAccountBtn, addViewingHabitsBtn;
    JComboBox programmaTitelCB, profileNameCB, fkaccountNrCB, kijkgedragAccountNrCB;
    private TransactionScriptComboxAbonnementNr scriptAbonnementNr;
    private TransactionScriptComboxProfiel scriptProfiel;
    private DefaultComboBoxModel accountNrModel;
    
public AddPanel(){
    
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
    kijkgedragAccountNrLbl = new JLabel ("Abonneenummer: ");
    
    pkaccountNrLbl = new JLabel ("Abonneenummer: ");
    accountNameLbl = new JLabel ("Abonnee naam: ");
    accountStreetLbl = new JLabel ("Straat: ");
    townLbl = new JLabel ("Plaats: ");
    houseNrLbl = new JLabel ("Huisnummer: ");
    postalcodeLbl = new JLabel ("Postcode: ");
    
    viewingHabitsLbl = new JLabel ("Percentage ");
    viewingHabitsField = new JTextField (20);
    
    
    programIdLbl = new JLabel ("Programma ID"); 
    programmaTitelCB = new JComboBox();
    
    
    profileNameField = new JTextField (20);
    birthdateField = new JTextField (20);

    
    pkaccountNrField = new JTextField (20);
    accountNameField = new JTextField (20);
    accountStreetField = new JTextField (20);
    townField = new JTextField (20);
    houseNrField = new JTextField (20);
    postalcodeField = new JTextField (20);
    
    addProfileBtn = new JButton ("Voeg profiel toe");
    addAccountBtn = new JButton ("Voeg account toe");
    addViewingHabitsBtn = new JButton ("Voeg kijkgedrag toe");
    
    
    // declare and initialize new Transitionscript
    // put results of the query() method in an arraylist.
    scriptAbonnementNr = new TransactionScriptComboxAbonnementNr(AddPanel.this);
    ArrayList<TransactionResultComboxAbonnementNr> resultArrayAbonnement = scriptAbonnementNr.query();
    List<String> valuesAbonnement = new ArrayList();

    // create a combobox that will be used to hold accountnumbers
    fkaccountNrCB = new JComboBox();
    kijkgedragAccountNrCB = new JComboBox();

    // add results from resultArray to a list
    for (int x = 0; x < resultArrayAbonnement.size();x++) {
        TransactionResultComboxAbonnementNr result = resultArrayAbonnement.get(x);
        valuesAbonnement.add(result.getNaam());
    }
    
    //  add new model with results to the combobox
    fkaccountNrCB.setModel(new DefaultComboBoxModel(valuesAbonnement.toArray()));
    kijkgedragAccountNrCB.setModel(new DefaultComboBoxModel(valuesAbonnement.toArray()));
    
    // declare and initialize new Transitionscript
    // put results of the query() method in an arraylist.
    scriptProfiel = new TransactionScriptComboxProfiel(kijkgedragAccountNrCB.getSelectedItem().toString(), AddPanel.this);
    ArrayList<TransactionResultComboxProfiel> resultArrayProfiel = scriptProfiel.query();
    List<String> valuesProfiel = new ArrayList();

    // create a combobox that will be used to hold accountnumbers
    profileNameCB = new JComboBox();

    // add results from resultArray to a list
    for (int x = 0; x < resultArrayProfiel.size();x++) {
        TransactionResultComboxProfiel result = resultArrayProfiel.get(x);
        valuesProfiel.add(result.getNaam());
    }
    
    //  add new model with results to the combobox
    profileNameCB.setModel(new DefaultComboBoxModel(valuesProfiel.toArray()));
    
    // Make new script and fire querie again for new results and make a list
    TransactionScriptComboxProgrTitel scriptProgrTitel = new TransactionScriptComboxProgrTitel(profileNameCB.getSelectedItem().toString(), AddPanel.this);
    ArrayList<TransactionResultComboxProgrTitel> resultArrayProgrTitel = scriptProgrTitel.query();
    List<String> valuesProgrTitel = new ArrayList();

    // add results from resultArray to a list
    for (int x = 0; x < resultArrayProgrTitel.size();x++) {
        TransactionResultComboxProgrTitel resultProgrTitel = resultArrayProgrTitel.get(x);
        valuesProgrTitel.add(resultProgrTitel.getProgramme());
    }


    //  add new model with results to the combobox
    programmaTitelCB.setModel(new DefaultComboBoxModel(valuesProgrTitel.toArray()));
    
    ItemListener listen = new ComboboxItemChangeListener();
    ActionListener knophandler = new ButtonHandler();
    
    profileNameCB.addItemListener(listen);
    kijkgedragAccountNrCB.addItemListener(listen);
    addAccountBtn.addActionListener(knophandler);
    addProfileBtn.addActionListener(knophandler);
    addViewingHabitsBtn.addActionListener(knophandler);
    
    add (profiles);
    add (new JLabel (""));
    add (profileNameLbl);
    add (profileNameField);
    add (birthdateLbl);
    add (birthdateField);
    add (fkaccountNrLbl);
    add (fkaccountNrCB);
     add (addProfileBtn);
      add (new JLabel (""));
      
     add (accounts);
     add (new JLabel (""));
     add (pkaccountNrLbl);
     add (pkaccountNrField);
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
     add (addAccountBtn);
       add (new JLabel (""));
     
     add (viewinghabits);
     add (new JLabel(""));
     add (new JLabel ("Profiel naam"));
     add (profileNameCB);
     add (kijkgedragAccountNrLbl);
     add (kijkgedragAccountNrCB);
     add (new JLabel ("Programma titel: "));
     add (programmaTitelCB);
     add (viewingHabitsLbl);
     add (viewingHabitsField);
     add (addViewingHabitsBtn);
     
    
    
    
    
}
    /**
     * Actionlistener that will fire queries when one of the three available buttons is clicked.
     */
    class ButtonHandler implements ActionListener { // listens to actions that have been performed
        @Override
        public void actionPerformed(ActionEvent e) {
           TransactionScriptAdd addScript = new TransactionScriptAdd(AddPanel.this); // instantiate the script that performs the queries
           
            // listen to what button gets clicked
            if ( e.getSource() == addProfileBtn ) {
                
                // get strings from textfields and comboboxes
                String profielNaam = profileNameField.getText();
                String geboortedatum = birthdateField.getText();
                String abonnementNr = fkaccountNrCB.getSelectedItem().toString();
                
                addScript.qeuryInsertProfiel(abonnementNr, profielNaam, geboortedatum); // execute query
                
                // Make new script and fire querie again for new results and make a list
                TransactionScriptComboxProfiel script = new TransactionScriptComboxProfiel(kijkgedragAccountNrCB.getSelectedItem().toString(), AddPanel.this);
                ArrayList<TransactionResultComboxProfiel> resultArray = script.query();
                List<String> values = new ArrayList();
                
                // add results from resultArray to a list
                for (int x = 0; x < resultArray.size();x++) {
                    TransactionResultComboxProfiel result = resultArray.get(x);
                    values.add(result.getNaam());
                }
                
                
                //  add new model with results to the comboboxes
                profileNameCB.setModel(new DefaultComboBoxModel(values.toArray()));
               
                
                // reset input fields
                profileNameField.setText("");
                birthdateField.setText("");
            }
            
            // listen to what button gets clicked
            if ( e.getSource() == addAccountBtn ) {
                
                // get strings from textfields and comboboxes
                String abonnementNaam = accountNameField.getText();
                String straat = accountStreetField.getText();
                String abonnementNr = pkaccountNrField.getText();
                String postcode = postalcodeField.getText();
                String huisnummer = houseNrField.getText();
                String woonplaats = townField.getText();
                
                addScript.qeuryInsertAbonnement(abonnementNr, abonnementNaam, straat, // execute query
                                            postcode, huisnummer, woonplaats);
                
                
                
                // Make new script and fire querie again for new results and make a list
                TransactionScriptComboxAbonnementNr script = new TransactionScriptComboxAbonnementNr(AddPanel.this);
                ArrayList<TransactionResultComboxAbonnementNr> resultArray2 = script.query();
                List<String> values = new ArrayList();
                
                // add results from resultArray to a list
                for (int x = 0; x < resultArray2.size();x++) {
                    TransactionResultComboxAbonnementNr result = resultArray2.get(x);
                    values.add(result.getNaam());
                }
                
                
                //  add new model with results to the comboboxes
                fkaccountNrCB.setModel(new DefaultComboBoxModel(values.toArray()));
                kijkgedragAccountNrCB.setModel(new DefaultComboBoxModel(values.toArray()));
                
                // reset all text fields under Account
                accountNameField.setText("");
                accountStreetField.setText("");
                pkaccountNrField.setText("");
                postalcodeField.setText("");
                houseNrField.setText("");
                townField.setText("");
                
            }
            
            // listen to what button gets clicked
            if ( e.getSource() == addViewingHabitsBtn ) {
                
                // get strings from textfields and comboboxes
                String naam = profileNameField.getText();
                String programmaTitel = programmaTitelCB.getSelectedItem().toString();
                String profielNaam = profileNameCB.getSelectedItem().toString();
                String percentage = viewingHabitsField.getText();
                String abonnementNr = kijkgedragAccountNrCB.getSelectedItem().toString();
                
                addScript.qeuryInsertWatch(abonnementNr, profielNaam, programmaTitel, percentage);// execute query
                
                 // Make new script and fire querie again for new results and make a list
                TransactionScriptComboxProgrTitel scriptProgrTitel = new TransactionScriptComboxProgrTitel(profileNameCB.getSelectedItem().toString(), AddPanel.this);
                ArrayList<TransactionResultComboxProgrTitel> resultArrayProgrTitel = scriptProgrTitel.query();
                List<String> valuesProgrTitel = new ArrayList();

                // add results from resultArray to a list
                for (int x = 0; x < resultArrayProgrTitel.size();x++) {
                    TransactionResultComboxProgrTitel resultProgrTitel = resultArrayProgrTitel.get(x);
                    valuesProgrTitel.add(resultProgrTitel.getProgramme());
                }


                //  add new model with results to the combobox
                programmaTitelCB.setModel(new DefaultComboBoxModel(valuesProgrTitel.toArray()));
                
                // reset all text fields under Kijkgedrag
                viewingHabitsField.setText("");
                   
                
            }
         
        }

    }
    
    /**
     * Class that listens if an item has been selected.
     * In this case it is used to listen to items that are selected in a combobox
     */
    class ComboboxItemChangeListener implements ItemListener{
        /**
         * Listens if an item in the combobox <code>kijkgedragAccountNrCB</code> gets selected
         * @param event event that fires after an item in the combobox <code>kijkgedragAccountNrCB</code>
         * changed.
         */
        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                
                if ( event.getSource() == kijkgedragAccountNrCB ) {
                    // Make new script and fire querie again for new results and make a list
                     TransactionScriptComboxProfiel script = new TransactionScriptComboxProfiel(kijkgedragAccountNrCB.getSelectedItem().toString(), AddPanel.this);
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
                
                if ( event.getSource() == profileNameCB) {
                
                    // Make new script and fire querie again for new results and make a list
                   TransactionScriptComboxProgrTitel scriptProgrTitel = new TransactionScriptComboxProgrTitel(profileNameCB.getSelectedItem().toString(), AddPanel.this);
                   ArrayList<TransactionResultComboxProgrTitel> resultArrayProgrTitel = scriptProgrTitel.query();
                   List<String> valuesProgrTitel = new ArrayList();

                   // add results from resultArray to a list
                   for (int x = 0; x < resultArrayProgrTitel.size();x++) {
                       TransactionResultComboxProgrTitel resultProgrTitel = resultArrayProgrTitel.get(x);
                       valuesProgrTitel.add(resultProgrTitel.getProgramme());
                   }


                   //  add new model with results to the combobox
                   programmaTitelCB.setModel(new DefaultComboBoxModel(valuesProgrTitel.toArray()));
                }
           }
        }       
    }
}