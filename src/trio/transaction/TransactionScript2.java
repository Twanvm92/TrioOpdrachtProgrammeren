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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Mika Krooswijk
 */
public class TransactionScript2 extends TransactionScript{
    private ArrayList<TransactionResult2> resultArray;
    private JPanel panel;
    String accountID;
    String titel;
    
    public TransactionScript2(String accountID, String titel, JPanel panel) {
        this.panel = panel;
        resultArray = new ArrayList();
        this.accountID = accountID;
        this.titel  = titel;
    }
    public ArrayList query() {
        
  
        
        String query = "SELECT programma.titel, AVG(watch.percentage) FROM watch\n" +
"	JOIN programma ON programma.ProgrammaID=watch.ProgrammaID\n" +
"	WHERE watch.AbonnementNr=" + accountID +"  AND programma.titel='" + titel +"'\n" +
"	GROUP BY programma.titel";
        
        
      try{
            Connection connection = this.dbconnection(panel); // maak connectie met de database, geeft panel mee voor error-message
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while(result.next()){
                TransactionResult2 r = new TransactionResult2(result.getString("programma.titel"), result.getDouble("AVG(watch.percentage)"));
                
                resultArray.add(r);
            }
            
            connection.close();
      }catch (SQLException exeption) {
            JOptionPane.showMessageDialog(panel, "Database connectie kon niet gesloten worden", "Fout", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }finally{
          
      }
      return resultArray;
    }

}
