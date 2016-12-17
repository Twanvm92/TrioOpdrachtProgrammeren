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
    String abonnementNr, geboortedatum, profielNaam;
    

    /**
     * 
     *
     * @param panel The panel where the error message from an SQLException shows on
     */
    // Contructor initialiseert

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
     * @param abonnementNr
     * @param profielNaam
     * @param geboortedatum
     */
    public void qeuryInsertProfiel(String abonnementNr, String profielNaam, String geboortedatum) {
        // fill a string with query data
        String query = "INSERT INTO profiel"
                + "VALUES('" + abonnementNr + "', '" + profielNaam + "', '" + "', " + geboortedatum + "');";
        
        try{

            Connection connection = this.dbconnection(panel); // make a connection with the database

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query gets executed

            closeConnection(connection, panel); // close connection with the database
      }catch (SQLException exeption) { // catch exception when connection with database fails
            exeption.printStackTrace();
      }
    }
    
    /**
     * Inserts a new account into the database by firing a query
     * @param abonnementNr
     * @param naam
     * @param straat
     * @param postcode
     * @param huisnummer
     * @param woonplaats
     */
    public void qeuryInsertAbonnement(String abonnementNr, String naam, String straat,
            String postcode, String huisnummer, String woonplaats) {
        // fill a string with query data
        String query = "INSERT INTO abonnement"
                + "VALUES('" + abonnementNr + "', '" + naam + "', '" + "', " + straat
                + "', '" + postcode + "', '" + huisnummer + "', '" + "', " + woonplaats + "');";
        
        try{

            Connection connection = this.dbconnection(panel); // make a connection with the database

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query gets executed

            closeConnection(connection, panel); // close connection with the database
      }catch (SQLException exeption) { // catch exception when connection with database fails
            exeption.printStackTrace();
      }
    }
    
    /**
     * Inserts a new watch into the database by firing a query
     * @param abonnementnr
     * @param naam
     * @param programmaid
     */
    public void qeuryInsertWatch(String abonnementnr, String naam, String programmaid, String percentage) {
         // fill a string with query data
        String query = "INSERT INTO watch"
                + "VALUES('" + abonnementNr + "', '" + naam + "', '" + "', " + programmaid + "', '" + percentage + "');";
        
        try{

            Connection connection = this.dbconnection(panel); // make a connection with the database

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query gets executed

            closeConnection(connection, panel); // close connection with the database
      }catch (SQLException exeption) { // catch exception when connection with database fails
            exeption.printStackTrace();
      }
    }

    
}
