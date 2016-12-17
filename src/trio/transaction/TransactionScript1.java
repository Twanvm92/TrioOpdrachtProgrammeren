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
 * <code>TransactionScript1</code> erft methodes van abstracte klasse <code>TransactionScript</code>
 * Voert een querie uit op de database en slaat de results op in <code>TransactionResult1</code>
 * @see TransactionResult1
 * @author Mika Krooswijk
 * @see TransactionScript
 */
public class TransactionScript1 extends TransactionScript{
    private String serie;
    JPanel panel;
    ArrayList<TransactionResult1> resultArray;
    

    /**
     * 
     * @param serie de serie die meegegeven wordt aan een query.
     * @param panel dit is het paneel waar de error message van een exception op verschijnt.
     */
    // Contructor initialiseert

    public TransactionScript1(String serie, JPanel panel){
        this.serie = serie;
        this.panel = panel;
        resultArray = new ArrayList<TransactionResult1>();
    }
    
   
     
    

    public ArrayList query(){
        

        
        // vult een string met query gegevens
        String query = " SELECT programma.titel, aflevering.volgnummer, AVG(watch.percentage) FROM watch" +
" 	INNER JOIN programma ON watch.programmaid = programma.programmaid" +
" 	INNER JOIN aflevering ON programma.programmaid = aflevering.programmaid" +
" 	INNER JOIN serie ON aflevering.titelserie = serie.titel" +
" 	WHERE serie.titel =\"" + serie + "\" " +
" 	GROUP BY watch.programmaid;";
        
        
        
      try{

            Connection connection = this.dbconnection(panel); // maak connectie met de database, geeft panel mee voor error-message

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query wordt uitgevoerd

            while(result.next()){ // vul transactionresult class met resultaten van de query
                TransactionResult1 r = new TransactionResult1(result.getString("programma.titel"), result.getDouble("AVG(watch.percentage)") );
                
                resultArray.add(r);
                
            }
            closeConnection(connection, panel); // sluit de connectie met de database
      }catch (SQLException exeption) { // vangt exception op wanneer connectie met database niet gemaakt kan worden
            exeption.printStackTrace();
      }
      return resultArray;
    }

    
}
