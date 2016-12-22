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
 * <code>TransactionScript1</code> enherits the method from abstract class <code>TransactionScript</code>
 * Executes a query and saves the results in <code>TransactionResult1</code>
 * @see TransactionResult1
 * @author Mika Krooswijk
 * @see TransactionScript
 */


public class TransactionScript1 extends TransactionScript{
    private String serie;
    JPanel panel;
    ArrayList<TransactionResult1> resultArray;
    

    /**
     * 
     * @param serie the serie that is used as a parameter
     * @param panel The panel where the error message from an SQLException shows on
     */
    // Contructor initialise

    public TransactionScript1(String serie, JPanel panel){
        this.serie = serie;
        this.panel = panel;
        resultArray = new ArrayList<TransactionResult1>();
    }
    
   
     
    

    public ArrayList query(){
        

       /** 
        * Selects the program title and watch percentage of specific serie title
        * @param serie the specific serie title
        */
          // fill a string with query data
        String query = " SELECT programma.titel, aflevering.volgnummer, AVG(watch.percentage) FROM watch" +
" 	INNER JOIN programma ON watch.programmaid = programma.programmaid" +
" 	INNER JOIN aflevering ON programma.programmaid = aflevering.programmaid" +
" 	INNER JOIN serie ON aflevering.titelserie = serie.titel" +
" 	WHERE serie.titel =\"" + serie + "\" " +
" 	GROUP BY watch.programmaid;";
        
        
        
      try{

            Connection connection = this.dbconnection(panel); // make a connection with the database

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query gets executed

            while(result.next()){ // fill array with transactionresults based on the query results
                TransactionResult1 r = new TransactionResult1(result.getString("programma.titel"), result.getDouble("AVG(watch.percentage)") );
                
                resultArray.add(r);
                
            }
            closeConnection(connection, panel);// close connection with the database
      }catch (SQLException exeption) { // exception when database connection had failed
            JOptionPane.showMessageDialog(panel, "Database connection failed", "error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }
      return resultArray;
    }

    
}
