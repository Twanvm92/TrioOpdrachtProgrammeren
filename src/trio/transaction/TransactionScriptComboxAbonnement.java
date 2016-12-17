/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;


import java.sql.*;
import java.util.ArrayList;
import javax.swing.JPanel;
/**
 * <code>TransactionScriptComboboxAbonnement</code> enherits from abstract class <code>TransactionScript</code>
 * Executes a query and saves the results in <code>TransactionResultComboboxAbonnement</code>
 * @see TransactionResultComboboxAbonnement
 * @author Mika Krooswijk
 * @see TransactionScript
 */
public class TransactionScriptComboxAbonnement extends TransactionScript{
    JPanel panel;
    ArrayList<TransactionResultComboxAbonnement> resultArray;
    
    /**
     * 
     * 
     * @param panel The panel where the error message from an SQLException shows ons
     */
    // Contructor initialises
    public TransactionScriptComboxAbonnement(JPanel panel){
        this.panel = panel;
        resultArray = new ArrayList<>();
    }
    
    /**
     * 
     * @return Returns an arraylist of query rows
     */
    @Override
    public ArrayList query(){
        
        // fill a string with query data
        String query = "SELECT naam FROM abonnement ORDER BY naam;";
        
        
        
      try{
            Connection connection = this.dbconnection(panel); // make a connection with the database
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query gets executed
            
            while(result.next()){ // fill transactionresult class with query results
                TransactionResultComboxAbonnement r = new TransactionResultComboxAbonnement(result.getString("naam"));
                resultArray.add(r);
            }
            closeConnection(connection, panel); // close connection with the database
      }catch (SQLException exeption) { // catch exception when connection with database fails
            System.out.println("error");
      }
      return resultArray;
    }

    
}
