/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * <code>TransactionScriptAdd</code> enherits from abstract class <code>TransactionScript</code>
 * Executes a query and fills the database with profiles, accounts and watches. 
 * @see TransactionResultAdd
 * @author Mika Krooswijk
 * @see TransactionScript
 */
public class TransactionScriptAdd extends TransactionScript{
    JPanel panel;
    //String abonnementNr, geboortedatum, profielNaam;
    

    /**
     * 
     *
     * @param panel The panel where the error message from an SQLException shows on
     */

    public TransactionScriptAdd(JPanel panel){
        
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
     * Inserts a new profile into the database by firing a query
     * @param abonnementNr The unique number of an account
     * @param profielNaam  The profile name connected to the account
       // fill a string with query data
     */
    public void qeuryInsertProfiel(String abonnementNr, String profielNaam, String geboortedatum) {
        // fill a string with query data
        String query = "INSERT INTO profiel"
                + " VALUES('" + abonnementNr + "', '" + profielNaam + "', '" + geboortedatum + "');";
        
        try{

            Connection connection = this.dbconnection(panel); // make a connection with the database

            Statement statement = connection.createStatement();
            statement.executeUpdate(query); // query gets executed

            closeConnection(connection, panel); // close connection with the database
            
            //show a pop-up message when account has been created
            JOptionPane.showMessageDialog(panel, "Profile has been created!", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
      }catch (SQLException exeption) { // catch exception when connection with database fails and does something with it
            JOptionPane.showMessageDialog(panel, "Could not create profile", "Error", JOptionPane.ERROR_MESSAGE);
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
    public void qeuryInsertAbonnement(String abonnementNr, String naam, String straat,
            String postcode, String huisnummer, String woonplaats) {
        // fill a string with query data
        String query = "INSERT INTO abonnement"
                + " VALUES(" + abonnementNr + ", '" + naam + "', '" + straat
                + "', '" + postcode + "', '" + huisnummer + "', '" + woonplaats + "');";
        
        try{

            Connection connection = this.dbconnection(panel); // make a connection with the database

            Statement statement = connection.createStatement();
            statement.executeUpdate(query); // query gets executed

            closeConnection(connection, panel); // close connection with the database
            
            //show a pop-up message when account has been created
            JOptionPane.showMessageDialog(panel, "Account has been created!", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
      }catch (SQLException exeption) { // catch exception when connection with database fails and does something with it
            JOptionPane.showMessageDialog(panel, "Could not create account", "Error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }
    }
    
    /**
     * Inserts a new watch into the database by firing a query
     * @param abonnementNr The account number of the profile that watched something
     * @param naam The name of the profile that watched something
     * @param programmaid The id of a programme that was watched.
     */
    public void qeuryInsertWatch(String abonnementNr, String naam, String programmaTitel, String percentage) {
         // fill a string with query data
        String query = "INSERT INTO watch"
                + " VALUES('" + abonnementNr + "', '" + naam + "', (SELECT programmaid FROM programma "
                + "WHERE titel = '" + programmaTitel + "'), '" + percentage + "');";
        
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
