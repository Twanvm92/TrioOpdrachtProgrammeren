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
 *
 * @author lukab
 */
public class TransactionScript5 extends TransactionScript {
    
    JPanel panel;
    ArrayList<TransactionResult5> resultArray;
    
    
    public TransactionScript5(){
        this.panel = panel;
        resultArray = new ArrayList<TransactionResult5>();
    }

    

    public ArrayList query(){
        
        Connection connection = this.dbconnection(panel);
        String query = "SELECT * FROM abonnement JOIN profiel ON abonnement.abonnementNr=profiel.abonnementNr GROUP BY abonnement.naam HAVING COUNT(*) = 1";
        
      
        
      try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
             
            
            while(result.next()){
                TransactionResult5 r = new TransactionResult5( result.getString("abonnement.naam"));
                resultArray.add(r);
            }
           
             
            closeConnection(connection, panel);
            
            
      }
      
      
      catch (SQLException exeption) {
            JOptionPane.showMessageDialog(panel, "Database connection failed", "error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }
      
      return resultArray;
      
    }
    
    


}
