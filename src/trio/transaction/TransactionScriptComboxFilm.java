/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;


import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * <code>TransactionScriptComboboxFilm/code> enherits from abstract class <code>TransactionScript</code>
 * Executes a query and saves the results in <code>TransactionResultComboboxFilm</code>
 * @see TransactionResultComboxFilm
 * @author Mika Krooswijk
 * @see TransactionScript
 */
public class TransactionScriptComboxFilm extends TransactionScript{
    private String serie;
    JPanel panel;
    ArrayList<TransactionResultComboxFilm> resultArray;
    
    /**
     * 
     * 
     * @param panel The panel where the error message from an SQLException shows ons
     */
    // Contructor initialises
    public TransactionScriptComboxFilm(JPanel panel){
        this.panel = panel;
        resultArray = new ArrayList<>();
    }
    
    @Override
    public ArrayList query(){
        
        // fill a string with query data
        String query = "SELECT programma.titel FROM programma INNER JOIN film ON programma.programmaid = film.programmaid ORDER BY programma.titel asc";
        
        
        
      try{
            Connection connection = this.dbconnection(panel); // make a connection with the database
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query gets executed
            
            while(result.next()){ // fill transactionresult class with query results
                TransactionResultComboxFilm r = new TransactionResultComboxFilm(result.getString("titel"));
                resultArray.add(r);
            }
            closeConnection(connection, panel); // close connection with the database
      }catch (SQLException exeption) { // catch exception when connection with database fails
            JOptionPane.showMessageDialog(panel, "Movies were not loaded", "error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }
      return resultArray;
    }

    
}
