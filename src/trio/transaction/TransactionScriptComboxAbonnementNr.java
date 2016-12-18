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
 * <code>TransactionScriptComboboxAbonnementNr</code> enherits from abstract class <code>TransactionScript</code>
 * Executes a query and saves the results in <code>TransactionResultComboboxAbonnementNr</code>
 * @see TransactionResultComboboxAbonnementNr
 * @author Twanvm
 * @see TransactionScript
 */
public class TransactionScriptComboxAbonnementNr extends TransactionScript{
    JPanel panel;
    ArrayList<TransactionResultComboxAbonnementNr> resultArray;
    
    /**
     * 
     * 
     * @param panel The panel where the error message from an SQLException shows ons
     */
    // Contructor initialises
    public TransactionScriptComboxAbonnementNr(JPanel panel){
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
        String query = "SELECT abonnementnr FROM abonnement;";
        
        
        
      try{
            Connection connection = dbconnection(panel); // make a connection with the database
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query gets executed
            
            while(result.next()){ // fill transactionresult class with query results
                TransactionResultComboxAbonnementNr r = new TransactionResultComboxAbonnementNr(result.getString("abonnementnr"));
                resultArray.add(r);
            }
            closeConnection(connection, panel); // close connection with the database
      }catch (SQLException exeption) { // catch exception when connection with database fails
            System.out.println("error");
      }
      return resultArray;
    }

    
}
