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
 * <code>TransactionScript3</code> enherits the method from abstract class <code>TransactionScript</code>
 * Executes a query and saves the results in <code>TransactionResult3</code>
 * @see TransactionResult3
 * @author Mika Krooswijk
 * @see TransactionScript
 */
public class TransactionScript3 extends TransactionScript{

    private String abonnement;
    private JPanel panel;
    ArrayList<TransactionResult3> resultArray;
    /**
     * 
     * @param abonnement the abonnement that is used as a parameter
     * @param panel The panel where the error message from an SQLException shows on
     */
    // Contructor initialises
    public TransactionScript3(String abonnement, JPanel panel){
        this.abonnement = abonnement;

        this.panel = panel;
 
        resultArray = new ArrayList<TransactionResult3>();
        this.abonnement = abonnement;
 
        resultArray = new ArrayList();

    }



    public ArrayList query(){

        
        // fills a string with query data
        String query = "SELECT DISTINCT programma.titel, programma.duur FROM abonnement\n" +
" 	INNER JOIN profiel ON abonnement.abonnementNr = profiel.abonnementNr\n" +
" 	INNER JOIN watch ON profiel.abonnementNr = watch.abonnementNr\n" +
" 	INNER JOIN programma ON watch.programmaid = programma.programmaid\n" +
" 	INNER JOIN film ON programma.programmaid = film.programmaid\n" +
" 	WHERE abonnement.naam = \"" + abonnement + "\"\n" +
" 	ORDER BY programma.titel;";
        
  
        try{
            Connection connection = this.dbconnection(panel); // make a connection with the database
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query gets executed
            
            
            while(result.next()) {// fill array with transactionresults based on the query results
                TransactionResult3 r = new TransactionResult3( result.getString("programma.titel"), result.getString("programma.duur"));

                resultArray.add(r);
            }
            
            closeConnection(connection, panel); // close connection with the database
            return resultArray; 
            
        }catch (SQLException exeption) { // // exception when database connection had failed
          JOptionPane.showMessageDialog(panel, "Database connection failed", "error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
        }
        catch (NullPointerException npe) { // // exception when null
          
        }
  
        return resultArray;
      
    }
  
}
