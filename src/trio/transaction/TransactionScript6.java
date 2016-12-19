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
public class TransactionScript6 extends TransactionScript{
        JPanel panel;
    ArrayList<TransactionResult6> resultArray;
        String film;
    
    
    
    public TransactionScript6(String film){
        this.panel = panel;
        resultArray = new ArrayList<TransactionResult6>();
        this.film = film;
    }

    
    
    public ArrayList query(){
        
        Connection connection = this.dbconnection(panel);
        
        
        String query = "SELECT programma.titel, COUNT(watch.ProgrammaID) as quantity FROM programma\n" +
"	JOIN watch ON programma.ProgrammaID=watch.ProgrammaID\n" +
"	WHERE programma.titel = '" + film +"' AND watch.percentage = 100\n" +
"	GROUP BY programma.titel"; 
                
              
                        
        
       
        
      
        
      try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
             
            
            while(result.next()){
                TransactionResult6 r = new TransactionResult6( result.getString("programma.titel"), result.getInt("quantity"));
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
