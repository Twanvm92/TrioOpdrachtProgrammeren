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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mika Krooswijk
 */
public class TransactionScript1 extends TransactionScript{
    
    public void query(String serie){
        
        Connection  connection;
        String query = " SELECT programma.titel, aflevering.volgnummer, AVG(watch.percentage) FROM watch" +
" 	INNER JOIN programma ON watch.programmaid = programma.programmaid" +
" 	INNER JOIN aflevering ON programma.programmaid = aflevering.programmaid" +
" 	INNER JOIN serie ON aflevering.titelserie = serie.titel" +
" 	WHERE serie.titel '" + serie + "' " +
" 	GROUP BY watch.programmaid;";
        
        
        
      try{
            
          connection = DriverManager.getConnection("jdbc:mysql://localhost/netflix", "duo1", "duo");
          Statement statement = connection.createStatement();
          ResultSet result = statement.executeQuery(query);
            
            while (result.next()){
                
            }
      }catch (SQLException exeption) {
            System.out.println("error");
      }
    }
}
