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
import javax.swing.JPanel;

/**
 *
 * @author lukab
 */
public class TransactionScript4 extends TransactionScript{
    
    JPanel panel;
    ArrayList<TransactionResult4> resultArray;
    
    public TransactionScript4(){
        this.panel = panel;
        resultArray = new ArrayList<>();
    }
    
    @Override
    public ArrayList query(){
        
        Connection connection = this.dbconnection(panel);
        String query = "SELECT programma.titel, film.leeftijdsIndicatie, programma.duur\n" + "FROM film\n" +"JOIN programma\n" +
            "ON programma.ProgrammaID=film.ProgrammaID\n" + "WHERE film.leeftijdsIndicatie < 16\n" + "ORDER BY (programma.duur) desc\n" ;
        
        
        
      try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
             
            
            while(result.next()){
                TransactionResult4 r = new TransactionResult4( result.getString("programma.titel"), result.getInt("film.leeftijdsIndicatie"), result.getString("programma.duur"));
                resultArray.add(r);
            }
            
            for (TransactionResult4 r :resultArray){
                System.out.println(r);
            }
             
            closeConnection(connection, panel);
            
           
            
      }
      
      
            
      catch (SQLException exeption) {
            System.out.println("error");
      }
       return resultArray;
    }
    
    


}
