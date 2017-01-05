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
 * <code>TransactionScript5</code> enherits the method from abstract class <code>TransactionScript</code>
 * Executes a query and saves the results in <code>TransactionResult5</code>
 * @see TransactionResult5
 * @author LukaB
 * @see TransactionScript
 */
public class TransactionScript5 extends TransactionScript {
    
    JPanel panel;
    ArrayList<TransactionResult5> resultArray;
    
     /**
     * 
     * @param panel The panel where the error message from an SQLException shows on
     */
    // Contructor initialises

    
    public TransactionScript5(){
        this.panel = panel;
        resultArray = new ArrayList<TransactionResult5>();
    }

  
          // fill a string with query data

    public ArrayList query(){
        
        Connection connection = this.dbconnection(panel); // make a connection with the database

        String query = "SELECT * FROM abonnement JOIN profiel ON abonnement.abonnementNr=profiel.abonnementNr GROUP BY abonnement.naam HAVING COUNT(*) = 1";
        
      
        
      try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query gets executed
            
             
            
            while(result.next()) { // fill array with transactionresults based on the query results {
                TransactionResult5 r = new TransactionResult5( result.getString("abonnement.naam"));
                resultArray.add(r);
            }
           
             
            closeConnection(connection, panel); // close connection with the database
            
            
      }
      
      
      catch (SQLException exeption) { // exception when database connection had failed{
            JOptionPane.showMessageDialog(panel, "Database connection failed", "error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }
      
      return resultArray;
      
    }
    
    


}
