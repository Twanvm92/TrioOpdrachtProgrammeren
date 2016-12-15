/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author lukab
 */
public class AddPanel extends JPanel{
    JTextField profileNameField, birthdateField, fkaccountNrField,pkaccountNrField, accountNameField, accountStreetField, 
            townField, houseNrField, postalcodeField, viewingHabitsField;
    JLabel profileNameLbl, birthdateLbl, fkaccountNrLbl, pkaccountNrLbl, accountNameLbl, accountStreetLbl, townLbl, houseNrLbl,
            postalcodeLbl, programIdLbl, viewingHabitsLbl, viewinghabits, accounts, profiles;
    JButton addProfileBtn, addAccountBtn, addViewingHabitsBtn;
    JComboBox programIdCB, profileNameCB, fkaccountNrCB;
    
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
    
    pkaccountNrLbl = new JLabel ("Abonneenummer: ");
    accountNameLbl = new JLabel ("Abonnee naam: ");
    accountStreetLbl = new JLabel ("Straat: ");
    townLbl = new JLabel ("Plaats: ");
    houseNrLbl = new JLabel ("Huisnummer: ");
    postalcodeLbl = new JLabel ("Postcode: ");
    
    viewingHabitsLbl = new JLabel ("Percentage ");
    viewingHabitsField = new JTextField (20);
    
    
    profileNameCB = new JComboBox();
    fkaccountNrCB = new JComboBox();
    programIdLbl = new JLabel ("Programma ID"); //Combobox met programma's?'
    programIdCB = new JComboBox();
    
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
     add (new JLabel ("Programma ID: "));
     add (programIdCB);
     add (viewingHabitsLbl);
     add (viewingHabitsField);
     add (addViewingHabitsBtn);
     
     
    
    
    
}   
}