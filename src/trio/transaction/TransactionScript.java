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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * <code>TransactionScript</code> is een super klasse die een database connection verzorgt.
 * @author lukab
 */
abstract public class TransactionScript {
    
    /**
     * 
     * @param panel het paneel waar de SQLException error message wordt getoond.
     * 
     */
    public void dbconnection(JPanel panel) {
        try {   // probeer de volgende statements uit te voeren
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/netflix", "netflix", "netflix"); // maak connectie met localhost
            //Statement statement = connection.createStatement(); // maak statement
            //ResultSet resultset = statement.executeQuery("SELECT * FROM abonnement;"); // laat statement een query uitvoeren
        }
        catch (SQLException sqle) { // vang SQLException op en doe er wat mee
              JOptionPane.showMessageDialog(panel, "Database connectie is mislukt", "Fout", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    abstract public void query();
        
}
