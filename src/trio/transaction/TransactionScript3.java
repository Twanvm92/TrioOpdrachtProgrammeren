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
 * <code>TransactionScript3</code> erft methodes van abstracte klasse <code>TransactionScript</code>
 * * Voert een querie uit op de database en slaat de results op in <code>TransactionResult1</code>
 * @author Mika Krooswijk
 * @see TransactionResult3
 * @see TransactionScript
 */
public class TransactionScript3 extends TransactionScript{
    private String abonnement;
    private JPanel panel;
    ArrayList<TransactionResult3> resultArray;
    /**
     * 
     * @param abonnement het abonnement dat meegegeven wordt aan een query.
     * @param panel dit is het paneel waar de error message van een exception op verschijnt.
     */
    // Contructor initialiseert
    public TransactionScript3(String abonnement, JPanel panel){
        this.abonnement = abonnement;
        this.panel = panel;
        resultArray = new ArrayList<TransactionResult3>();
    }
    /**
     * @see TransactionScript gebruikt database connection methode van deze klasse
     */
    @Override
    public void query(){
        
        // vult een string met query gegevens
        String query = "SELECT DISTINCT programma.titel, programma.duur FROM abonnement\n" +
" 	INNER JOIN profiel ON abonnement.abonnementNr = profiel.abonnementNr\n" +
" 	INNER JOIN watch ON profiel.abonnementNr = watch.abonnementNr\n" +
" 	INNER JOIN programma ON watch.programmaid = programma.programmaid\n" +
" 	INNER JOIN film ON programma.programmaid = film.programmaid\n" +
" 	WHERE abonnement.naam = \"" + abonnement + "\"\n" +
" 	ORDER BY programma.titel;";
        
  
      try{
            Connection connection = this.dbconnection(panel); // maak connectie met de database, geeft panel mee voor error-message
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query wordt uitgevoerd
            
            
<<<<<<< HEAD
            while(result.next()){
                TransactionResult3 r = new TransactionResult3( result.getString("programma.titel"), result.getNString("programma.duur"));
=======
            while(result.next()){ // vul transactionresult class met resultaten van de query
                TransactionResult3 r = new TransactionResult3(result.getString("programma.titel"));
>>>>>>> refs/remotes/origin/master
                resultArray.add(r);
            }
            
            for (TransactionResult3 r :resultArray){
                System.out.println(r);
            }
            
            closeConnection(connection, panel); // sluit de connectie met de database
            
      }catch (SQLException exeption) { // vang exception op wanneer connectie met database niet gemaakt kan worden
          JOptionPane.showMessageDialog(panel, "Database connectie kon niet gesloten worden", "Fout", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }
      catch (NullPointerException npe) { // vang exception op wanneer connectie null is
          
      }
    }
}
