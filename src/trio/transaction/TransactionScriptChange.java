/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author lukab
 */
public class TransactionScriptChange extends TransactionScript {
        JPanel panel;
    //String abonnementNr, geboortedatum, profielNaam;
    

    /**
     * 
     *
     * @param panel The panel where the error message from an SQLException shows on
     */

    public TransactionScriptChange (JPanel panel){
        
        this.panel = panel;
    }
    
    /**
     * 
     * @return empty array because this method only injects data into a database
     */
    @Override
    public ArrayList query(){
          return null;
    }
    
    /**
     * Changes an existing profile into the database by firing a query
     * @param abonnementNr The unique number of an account
     * @param profielNaam  The profile name connected to the account
     * @param geboortedatum The birthdate of the person behind the profile
     */
    public void qeuryChangeProfiel(String abonnementNr, String profielNaam, String geboortedatum) {
        // fill a string with query data
        String query = "UPDATE profiel"
                + " SET geboortedatum = '" + geboortedatum + "' WHERE AbonnementNr = " + abonnementNr + " AND profielNaam = '" + profielNaam + "'";
        
        try{

            Connection connection = this.dbconnection(panel); // make a connection with the database

            Statement statement = connection.createStatement();
            statement.executeUpdate(query); // query gets executed

            closeConnection(connection, panel); // close connection with the database
            
            //show a pop-up message when account has been created
            JOptionPane.showMessageDialog(panel, "Profile has been changed!", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
      }catch (SQLException exeption) { // catch exception when connection with database fails and does something with it
            JOptionPane.showMessageDialog(panel, "Could not change profile", "Error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }
    }
    
    /**
     * Inserts a new account into the database by firing a query
     * @param abonnementNr The unique number of an account
     * @param naam The name connected to a account
     * @param straat The streetname connected to an account
     * @param postcode The postalcode connected to an account
     * @param huisnummer The housenumber connected to an account
     * @param woonplaats The city connected to an account
     */
    public void qeuryChangeAbonnement(String abonnementNr, String naam, String straat,
            String postcode, String huisnummer, String woonplaats) {
        // fill a string with query data
        String query = "UPDATE abonnement SET naam = '" + naam + "' , straat = '" + straat + "', postcode = '" + postcode + "', huisnummer = " + huisnummer +
                ", Woonplaats = '" + woonplaats + "' WHERE AbonnementNr = " + abonnementNr;
        
        
        try{

            Connection connection = this.dbconnection(panel); // make a connection with the database

            Statement statement = connection.createStatement();
            statement.executeUpdate(query); // query gets executed

            closeConnection(connection, panel); // close connection with the database
            
            //show a pop-up message when account has been created
            JOptionPane.showMessageDialog(panel, "Account has been changed!", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
      }catch (SQLException exeption) { // catch exception when connection with database fails and does something with it
            JOptionPane.showMessageDialog(panel, "Could not change account", "Error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }
    }
    
    /**
     * Inserts a new watch into the database by firing a query
     * @param abonnementNr The account number of the profile that watched something
     * @param naam The name of the profile that watched something
     * @param programmaid The id of a programme that was watched.
     */
    public void qeuryInsertWatch(String abonnementNr, String naam, String programmaid, String percentage) {
         // fill a string with query data
        String query = "INSERT INTO watch"
                + " VALUES('" + abonnementNr + "', '" + naam + "', '" + programmaid + "', '" + percentage + "');";
        
        try{

            Connection connection = this.dbconnection(panel); // make a connection with the database

            Statement statement = connection.createStatement();
            statement.executeUpdate(query); // query gets executed

            closeConnection(connection, panel); // close connection with the database
            
            //show a pop-up message when account has been created
            JOptionPane.showMessageDialog(panel, "Watch has been created!", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
      }catch (SQLException exeption) { // catch exception when connection with database fails and does something with it
          JOptionPane.showMessageDialog(panel, "Could not create watch", "Error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }
    }

}
