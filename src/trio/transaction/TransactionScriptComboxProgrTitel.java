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
 * <code>TransactionScriptComboxProgrTitel</code> enherits from abstract class <code>TransactionScript</code>
 * Executes a query and saves the results in <code>TransactionResultComboxProgrTitel</code>
 * @see TransactionResultComboxProgrTitel
 * @author Twanvm
 * @see TransactionScript
 */
public class TransactionScriptComboxProgrTitel extends TransactionScript{
    private String profielNaam;
    JPanel panel;
    ArrayList<TransactionResultComboxProgrTitel> resultArray;
    
    /**
     * 
     * 
     * @param profielNaam Name of a selected profile
     * 
     * @param panel The panel where the error message from an SQLException shows 
     */
    // Contructor initialises
    public TransactionScriptComboxProgrTitel(String profielNaam, JPanel panel){
        this.profielNaam = profielNaam;
        this.panel = panel;
        resultArray = new ArrayList<>();
    }
    
    @Override
    public ArrayList query(){
        
        // fill a string with query data
        String query = "SELECT programma.titel\n" +
"		FROM programma\n" +
"		WHERE programma.programmaid NOT IN (\n" +
"               SELECT watch.programmaid\n" +
"               FROM watch\n" +
"               WHERE profielnaam = '" + profielNaam + "' ORDER BY programma.titel ASC);";
        
        
        
      try{
            Connection connection = this.dbconnection(panel); // make a connection with the database
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query gets executed
            
            while(result.next()){ // fill transactionresult class with query results
                TransactionResultComboxProgrTitel r = new TransactionResultComboxProgrTitel(result.getString("programma.titel"));
                resultArray.add(r);
            }
            closeConnection(connection, panel); // close connection with the database
      }catch (SQLException exeption) { // catch exception when connection with database fails
            JOptionPane.showMessageDialog(panel, "Programmmes were not loaded", "error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }
      return resultArray;
    }

    
}
