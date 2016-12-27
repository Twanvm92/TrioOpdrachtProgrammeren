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
 * <code>TransactionScript4</code> enherits the method from abstract class <code>TransactionScript</code>
 * Executes a query and saves the results in <code>TransactionResult4</code>
 * @see TransactionResult4
 * @author lukab
 * @see TransactionScript
 */

public class TransactionScript4 extends TransactionScript{
    
    JPanel panel;
    ArrayList<TransactionResult4> resultArray;
    
     /**
     * 
     * @param panel The panel where the error message from an SQLException shows on
     */
    // Contructor initialises
    public TransactionScript4(){
        this.panel = panel;
        resultArray = new ArrayList<TransactionResult4>();
    }
    
    @Override
    public ArrayList query(){
        // fill a string with query data
        Connection connection = this.dbconnection(panel); // make a connection with the database
        String query = "SELECT programma.titel, film.leeftijdsIndicatie, programma.duur\n" + "FROM film\n" +"JOIN programma\n" +
            "ON programma.ProgrammaID=film.ProgrammaID\n" + "WHERE film.leeftijdsIndicatie < 16\n" + "ORDER BY (programma.duur) desc\n" ;
        
        
        
      try{
            Statement statement = connection.createStatement(); 
            ResultSet result = statement.executeQuery(query);
            
             
            
            while(result.next()) { // fill array with transactionresults based on the query results {
                TransactionResult4 r = new TransactionResult4( result.getString("programma.titel"), result.getInt("film.leeftijdsIndicatie"), result.getString("programma.duur"));
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
