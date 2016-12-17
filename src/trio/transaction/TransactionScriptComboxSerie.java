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
 * <code>TransactionScript1</code> enherits from abstract class <code>TransactionScript</code>
 * Executes a query and saves the results in <code>TransactionResult1</code>
 * @see TransactionResult1
 * @author Mika Krooswijk
 * @see TransactionScript
 */
public class TransactionScriptComboxSerie extends TransactionScript{
    JPanel panel;
    ArrayList<TransactionResultComboxSerie> resultArray;
    
    /**
     * 
     * 
     * @param panel The panel where the error message from an SQLException shows ons
     */
    // Contructor initialises
    public TransactionScriptComboxSerie(JPanel panel){
        this.panel = panel;
        resultArray = new ArrayList<>();
    }
    
    @Override
    public ArrayList query(){
        
        // fill a string with query data
        String query = "SELECT titel FROM serie ORDER BY titel;";
        
        
        
      try{
            Connection connection = this.dbconnection(panel); // make a connection with the database
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query gets executed
            
            while(result.next()){ // fill transactionresult class with query results
                TransactionResultComboxSerie r = new TransactionResultComboxSerie(result.getString("serie.titel"));
                resultArray.add(r);
            }
            closeConnection(connection, panel); // close connection with the database
      }catch (SQLException exeption) { // catch exception when connection with database fails
            System.out.println("error");
      }
      return resultArray;
    }

    
}
