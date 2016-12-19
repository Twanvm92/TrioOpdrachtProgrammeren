/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <code>TransactionScript</code> is a super class that provides a connection to a database.
 * @author lukab
 */
abstract public class TransactionScript {
    
    /**
     * 
     * @param panel Panel that is being used to show an SQLException error on.
     * @return Connection Return the connection if it succeeded, otherwise, return null
     */
    public Connection dbconnection(JPanel panel) {
        
        

        try {   //Try to execute the following statements
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/netflix", "netflix", "netflix"); // maak connectie met localhost
            return connection; // returns connection if connection succeeded.
        }
        catch (SQLException sqle) { // Catch SQLException and show an error message on the overviewpanels
              JOptionPane.showMessageDialog(panel, "Database connection failed", "Fout", JOptionPane.ERROR_MESSAGE);
              sqle.printStackTrace(); // print a trace of error messages in the console log
              return null;
        }
        
    }
    
    /**
     * Closes a database connection and catches any SQLExceptions
     * @param connection Connection to the database
     * @param panel Panel that is being used to show an SQLException error on.
     */
    public void closeConnection (Connection connection, JPanel panel) {
        try {
            connection.close();  
        }
        catch (SQLException sqle) {
            JOptionPane.showMessageDialog(panel, "Database connection failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    

    
    
    /**
     * 
     * @return Returns an arraylist of query rows
     */
    abstract public ArrayList query();

        


}
