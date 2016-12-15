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

/**
 *
 * @author Mika Krooswijk
 */
public class TransactionScript3 extends TransactionScript{
    String account;
    ArrayList<TransactionResult3> resultArray;
    
    public TransactionScript3(String account){
        resultArray = new ArrayList<TransactionResult3>();
        this.account = account;
    }
    public void query(){
        
        
        String query = "SELECT DISTINCT programma.titel, programma.duur FROM abonnement\n" +
" 	INNER JOIN profiel ON abonnement.abonnementNr = profiel.abonnementNr\n" +
" 	INNER JOIN watch ON profiel.abonnementNr = watch.abonnementNr\n" +
" 	INNER JOIN programma ON watch.programmaid = programma.programmaid\n" +
" 	INNER JOIN film ON programma.programmaid = film.programmaid\n" +
" 	WHERE abonnement.naam = \"" + account + "\"\n" +
" 	ORDER BY programma.titel;";
        
  
      try{
          
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/netflix", "netflix", "netflix");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            
            while(result.next()){
                TransactionResult3 r = new TransactionResult3(result.getString("programma.titel"));
                resultArray.add(r);
            }
            
            for (TransactionResult3 r :resultArray){
                System.out.println(r);
            }
            
            connection.close();
            
      }catch (SQLException exeption) {
            exeption.printStackTrace();
      }
    }
}
