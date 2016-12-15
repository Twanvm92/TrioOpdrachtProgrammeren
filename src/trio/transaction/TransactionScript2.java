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
import javax.swing.JPanel;

/**
 *
 * @author Mika Krooswijk
 */
public class TransactionScript2 extends TransactionScript{
    private ArrayList<TransactionResult> resultArray;
    private JPanel panel;
    
    public TransactionScript2(JPanel panel) {
        this.panel = panel;
        resultArray = new ArrayList();
    }
    public ArrayList query() {
        
  
        
        String query = "SELECT programma.titel, AVG(watch.percentage) FROM watch\n" +
"	JOIN programma ON programma.ProgrammaID=watch.ProgrammaID\n" +
"	WHERE watch.AbonnementNr=" + //acountID +" AND programma.titel=\"" + serie + "\"\n" +
"	GROUP BY programma.titel";
        
        
      try{
            Connection connection = this.dbconnection(panel); // maak connectie met de database, geeft panel mee voor error-message
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            if(result.next()){
                
            }
            connection.close();
      }catch (SQLException exeption) {
            System.out.println("error");
      }finally{
          
      }
      return resultArray;
    }

}
