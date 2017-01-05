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
 * <code>TransactionScriptAbonnementAll</code> enherits from abstract class <code>TransactionScript</code>
 * Executes a query and saves the results in <code>TransactionResultAbonnementAll</code>
 * @see TransactionResultAbonnementAll
 * @author lukab
 * @see TransactionScript
 */
public class TransactionScriptAbonnementAll extends TransactionScript {
        JPanel panel;
        String abonnementNr;
        ArrayList<TransactionResultAbonnementAll> all;
    /**
     * 
     * 
     * @param panel The panel where the error message from an SQLException shows ons
     */
    // Contructor initialises
    public TransactionScriptAbonnementAll (JPanel panel, String abonnementNr){
        this.panel = panel;
        this.abonnementNr = abonnementNr;
        all = new ArrayList<TransactionResultAbonnementAll>();
    
    }
    
    /**
     * 
     * @return Returns an arraylist of query rows
     */
 
    public ArrayList query(){
        
        // fill a string with query data
        String query = "SELECT * FROM abonnement WHERE AbonnementNr = " + abonnementNr;
        
        
        
      try{
            Connection connection = dbconnection(panel); // make a connection with the database
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query gets executed
            
            while(result.next()){ // fill transactionresult class with query results
                TransactionResultAbonnementAll r = new TransactionResultAbonnementAll(result.getString("naam"), result.getString("postcode"), result.getString("straat"),
                        result.getInt("huisnummer"), result.getString("Woonplaats"));
                
                all.add(r);
                
                System.out.print(all);
                
            }
            
           
            closeConnection(connection, panel); // close connection with the database
      }catch (SQLException exeption) { // catch exception when connection with database fails
            JOptionPane.showMessageDialog(panel, "Account names were not loaded", "error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }
            return all;
    }
    
  
}

