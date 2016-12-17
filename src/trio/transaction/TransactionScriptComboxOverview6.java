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
public class TransactionScriptComboxOverview6 extends TransactionScript {
       private String film;
    JPanel panel;
    ArrayList<TransactionResultComboxOverview6> resultArray;
    
    /**
     * 
     * @param serie de serie die meegegeven wordt aan een query.
     * @param panel dit is het paneel waar de error message van een exception op verschijnt.
     */
    // Contructor initialiseert
    public TransactionScriptComboxOverview6(JPanel panel){
        this.panel = panel;
        resultArray = new ArrayList<TransactionResultComboxOverview6>();
    }
    
    @Override
    public ArrayList query(){
        
        // vult een string met query gegevens
        String query = "SELECT programma.titel FROM programma JOIN film on programma.ProgrammaID = film.ProgrammaID ORDER BY programma.titel ASC ;";
        
        
        
      try{
            Connection connection = this.dbconnection(panel); // maak connectie met de database, geeft panel mee voor error-message
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query wordt uitgevoerd
            
            while(result.next()){ // vul transactionresult class met resultaten van de query
                TransactionResultComboxOverview6 r = new TransactionResultComboxOverview6(result.getString("programma.titel"));
                resultArray.add(r);
                
           
            }
            closeConnection(connection, panel); // sluit de connectie met de database
      }catch (SQLException exeption) { // vang exception op wanneer connectie met database niet gemaakt kan worden
            System.out.println("error");
      }
      return resultArray;
    }

}
