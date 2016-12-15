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

/**
 *
 * @author Mika Krooswijk
 */
public class TransactionScript2 {
    public class TransactionScript1 extends TransactionScript{
    
    public void query(int acountID, String serie) throws SQLException{
        
        Connection  connection;
        String query = "SELECT programma.titel, AVG(watch.percentage) FROM watch\n" +
"	JOIN programma ON programma.ProgrammaID=watch.ProgrammaID\n" +
"	WHERE watch.AbonnementNr=" + acountID +" AND programma.titel=\"" + serie + "\"\n" +
"	GROUP BY programma.titel";
        
        connection = DriverManager.getConnection("jdbc:mysql://localhost/netflix", "duo1", "duo");
        Statement statement = connection.createStatement();
        
      try{
            ResultSet result = statement.executeQuery(query);
            
            if(result.next()){
                
            }
      }catch (SQLException exeption) {
            System.out.println("error");
      }finally{
          connection.close();
      }
    }
}
}
