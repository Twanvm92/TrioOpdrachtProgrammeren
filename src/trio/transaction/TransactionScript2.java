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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * <code>TransactionScript2</code> enherits the method from abstract class <code>TransactionScript</code>
 * Executes a query and saves the results in <code>TransactionResult12/code>
 * @see TransactionResult2
 * @author Mika Krooswijk
 * @see TransactionScript
 */

public class TransactionScript2 extends TransactionScript{
    private ArrayList<TransactionResult2> resultArray;
    private JPanel panel;
    String accountID;
    String titel;
    
    
    /**
     * 
     * @param title the title that is used as a parameter
     * @param panel The panel where the error message from an SQLException shows on
     * @param accountID the ID of a specific account 
     */
    // Contructor initialises

    
    public TransactionScript2(String accountID, String titel, JPanel panel) {
        this.panel = panel;
        resultArray = new ArrayList();
        this.accountID = accountID;
        this.titel  = titel;
    }
    public ArrayList query() {
        
          /** 
        * Selects the program title and watch percentage of specific serie title and accountID
        * @param serie the specific serie title
        * @param accountID the specific account ID
        */
          // fill a string with query data
        
        String query = "SELECT programma.titel, AVG(watch.percentage) FROM watch\n" +
"	JOIN programma ON programma.ProgrammaID=watch.ProgrammaID\n" +
"	JOIN profiel ON watch.AbonnementNr = profiel.AbonnementNr\n" +
"	JOIN abonnement ON profiel.AbonnementNr = abonnement.AbonnementNr\n" +
"	JOIN aflevering ON programma.ProgrammaID=aflevering.ProgrammaID\n" +
"	WHERE abonnement.naam =\"" + accountID + "\" AND aflevering.titelSerie=\"" + titel + "\"\n" +
"	GROUP BY programma.titel";
        
        
      try{
            Connection connection = this.dbconnection(panel); // make a connection with the database
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while(result.next()){ // fill array with transactionresults based on the query results
                TransactionResult2 r = new TransactionResult2(result.getString("programma.titel"), result.getDouble("AVG(watch.percentage)"));
                
                resultArray.add(r);
            }
            
            connection.close(); // close connection with the database
      }catch (SQLException exeption) { // exception when database connection had failed
            JOptionPane.showMessageDialog(panel, "Database connection failed", "error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }finally{
          
      }
      return resultArray;
    }

}
