/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author lukab
 */
public class TransactionScript5 extends TransactionScript{
    
    JPanel panel;
    ArrayList<TransactionResult5> resultArray;
    
    
    public TransactionScript5(){
    this.panel = panel;
        resultArray = new ArrayList<>();
    }

    
    @Override
    public void query(){
        
        Connection connection = this.dbconnection(panel);
        String query = "SELECT abbonement.naam FROM abonnement\n" +
"	INNER JOIN profiel ON abonnement.abonnementNr = profiel.abonnementNr\n" +
"	GROUP BY abonnement.naam\n" +
"	HAVING COUNT(*) = 1;" ;
        
        
        
      try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
             
            
            while(result.next()){
                TransactionResult5 r = new TransactionResult5( result.getString( " abonnement.naam"));
                resultArray.add(r);
            }
            
            for (TransactionResult5 r :resultArray){
                System.out.println(r);
            }
             
            closeConnection(connection, panel);
            
            
      }
      
      
      catch (SQLException exeption) {
            System.out.println("error");
      }
      
    }
    
    


}
