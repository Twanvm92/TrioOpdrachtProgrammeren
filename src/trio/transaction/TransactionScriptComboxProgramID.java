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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Mika Krooswijk
 */
public class TransactionScriptComboxProgramID  extends TransactionScript{
    JPanel panel;
    ArrayList<TransactionResultProgramID> resultArray;
    public TransactionScriptComboxProgramID(JPanel panel){
        this.panel = panel;
        resultArray = new ArrayList<TransactionResultProgramID>();
    }
    
    public ArrayList query(){
        String query = "SELECT ProgrammaID FROM watch";
        
        try{
            Connection connection = dbconnection(panel); // make a connection with the database
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query); // query gets executed
            
            while(result.next()){ // fill transactionresult class with query results
                TransactionResultProgramID r = new TransactionResultProgramID(result.getString("ProgrammaID"));
                resultArray.add(r);
            }
            
            
            closeConnection(connection, panel); // close connection with the database
            
            
            
      }catch (SQLException exeption) { // catch exception when connection with database fails
            JOptionPane.showMessageDialog(panel, "profielen were not loaded", "error", JOptionPane.ERROR_MESSAGE);
            exeption.printStackTrace();
      }
      return resultArray;
    }
    }
    

