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
 * @author Mika Krooswijk
 */
public class TransactionScript1 extends TransactionScript{
    private String serie;
    JPanel panel;
    ArrayList<TransactionResult> resultArray;
    

    public TransactionScript1(String serie, JPanel panel){
        this.serie = serie;
        this.panel = panel;
        resultArray = new ArrayList<>();
    }
    
    @Override
    public void query(){

        
        Connection connection = this.dbconnection(panel);
        String query = " SELECT programma.titel, aflevering.volgnummer, AVG(watch.percentage) FROM watch" +
" 	INNER JOIN programma ON watch.programmaid = programma.programmaid" +
" 	INNER JOIN aflevering ON programma.programmaid = aflevering.programmaid" +
" 	INNER JOIN serie ON aflevering.titelserie = serie.titel" +
" 	WHERE serie.titel '" + serie + "' " +
" 	GROUP BY watch.programmaid;";
        
        
        
      try{

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while(result.next()){

                
            }
            closeConnection(connection, panel);
      }catch (SQLException exeption) {
            System.out.println("error");
      }
      
    }

    
}
