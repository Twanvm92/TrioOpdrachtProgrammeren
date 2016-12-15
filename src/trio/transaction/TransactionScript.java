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

/**
 *
 * @author lukab
 */
public class TransactionScript {
    public void dbconnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/netflix", "netflix", "netflix");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM abonnement;");
            while (resultset.next()) {
                int Sleutel = resultset.getInt("AbonnementNr");
                String Naam = resultset.getString("naam");
                System.out.println(Sleutel + " " + Naam);
                
            }
        }
        catch (SQLException sqle) {
              //JOptionPane.showMessageDialog(controlPanel, "Fout", "Er is een fout opgetreden in de mysql", JOptionPane.ERROR_MESSAGE);
              System.out.println("SQL error");
        }
    }
        
}
