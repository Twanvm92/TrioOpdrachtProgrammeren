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
 * <code>TransactionScriptComboxProfiel</code> enherits from abstract class <code>TransactionScript</code>
 * Executes a query and saves the results in <code>TransactionResultComboxSerie</code>
 * @see TransactionResultComboxProfiel
 * @author Twanvm
 * @see TransactionScript
 */
public class TransactionScriptComboxProfiel extends TransactionScript{
    private String abonnementNr;
    JPanel panel;
    ArrayList<TransactionResultComboxProfiel> resultArray;
    
    /**
     * 
     * 
     * @param abonnementNr Number of a selected account
     * @param panel The panel where the error message from an SQLException shows 
     */
    // Contructor initialises
    public TransactionScriptComboxProfiel(String abonnementNr, JPanel panel){
        this.abonnementNr = abonnementNr;
        this.panel = panel;
        resultArray = new ArrayList<>();
    }
    
    @Override
    public ArrayList query(){
        
        // fill a string with query data
        String query = "SELECT profielnaam FROM profiel"
                + " INNER JOIN abonnement ON abonnement.abonnementnr = profiel.abonnementnr"
                + " WHERE profiel.abonnementnr = " + abonnementNr + " ORDER BY profielnaam;";
        
        
        
      try{
            Connection connection = this.dbconnection(panel); // make a connection with the database
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query gets executed
            
            while(result.next()){ // fill transactionresult class with query results
                TransactionResultComboxProfiel r = new TransactionResultComboxProfiel(result.getString("profielnaam"));
                resultArray.add(r);
            }
            closeConnection(connection, panel); // close connection with the database
      }catch (SQLException exeption) { // catch exception when connection with database fails
            JOptionPane.showMessageDialog(panel, "Profiles were not loaded", "error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }
      return resultArray;
    }

    
}
