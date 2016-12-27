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
 * <code>TransactionScript6</code> enherits the method from abstract class <code>TransactionScript</code>
 * Executes a query and saves the results in <code>TransactionResult6</code>
 * @see TransactionResult6
 * @author Mika Krooswijk
 * @see TransactionScript
 */

public class TransactionScript6 extends TransactionScript{
        JPanel panel;
    ArrayList<TransactionResult6> resultArray;
        String film;
    
     /**
     * 
     * @param film the film that is used as a parameter
     * @param panel The panel where the error message from an SQLException shows on
     */
    // Contructor initialise
    
    public TransactionScript6(String film){
        this.panel = panel;
        resultArray = new ArrayList<TransactionResult6>();
        this.film = film;
    }

    
    
    public ArrayList query(){
        
        Connection connection = this.dbconnection(panel); // make a connection with the database
        
         // fill a string with query data
        String query = "SELECT programma.titel, COUNT(watch.ProgrammaID) as quantity FROM programma\n" +
"	JOIN watch ON programma.ProgrammaID=watch.ProgrammaID\n" +
"	WHERE programma.titel = '" + film +"' AND watch.percentage = 100\n" +
"	GROUP BY programma.titel"; 
                
              
                        
        
       
        
      
        
      try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
             
            
            while(result.next()) { // fill array with transactionresults based on the query results {
                TransactionResult6 r = new TransactionResult6( result.getString("programma.titel"), result.getInt("quantity"));
                resultArray.add(r);
                
               
            }
           
             
            closeConnection(connection, panel); // close connection with the database
            
            
      }
      
      
      catch (SQLException exeption) {// exception when database connection had failed {
            JOptionPane.showMessageDialog(panel, "Database connection failed", "error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }
      
      return resultArray;
      
    }
}
