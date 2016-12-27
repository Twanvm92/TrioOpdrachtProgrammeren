/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author lukab
 */
public class TransactionScriptCombxProgrTitel2 extends TransactionScript{
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
    public TransactionScriptCombxProgrTitel2 (String profielNaam, JPanel panel){
        this.profielNaam = profielNaam;
        this.panel = panel;
        resultArray = new ArrayList<>();
    }
    
    @Override
    public ArrayList query(){
        
        // fill a string with query data
        String query = "SELECT programma.titel\n" +
"		FROM programma\n" +
"		WHERE programma.programmaid IN (\n" +
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

    